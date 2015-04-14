inherit image_types

IMAGE_DEPENDS_boot = "virtual/kernel dosfstools-native mtools-native"
IMAGE_TYPEDEP_boot = "ext4 tar"

IMAGE_CMD_boot () {

	BLOCKS=32768
	rm -f ${WORKDIR}/boot.img

	mkfs.vfat -n "boot" -S 512 -C ${WORKDIR}/boot.img $BLOCKS

	# Copy kernel
	mcopy -i ${WORKDIR}/boot.img -s ${DEPLOY_DIR_IMAGE}/bzImage-edison.bin ::/vmlinuz

	# Copy fota kernel (includes initramfs)
	if [ -e ${DEPLOY_DIR_IMAGE}/bzImage-initramfs-edison.bin ]; then
		mcopy -i ${WORKDIR}/boot.img -s ${DEPLOY_DIR_IMAGE}/bzImage-initramfs-edison.bin ::/vmlinuzi
	fi

	install ${WORKDIR}/boot.img ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.hddimg
	ln -s ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.hddimg ${DEPLOY_DIR_IMAGE}/${IMAGE_BASENAME}-${MACHINE}.hddimg
}

IMAGE_DEPENDS_toflash = "ifwi flashall u-boot u-boot-mkimage-native"
IMAGE_TYPEDEP_toflash = "ext4 boot"

IMAGE_CMD_toflash () {

	rm -rf 	${WORKDIR}/toFlash
	install -d ${WORKDIR}/toFlash/u-boot-envs/

	install ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext4	${WORKDIR}/toFlash/edison-image-edison.ext4
	install ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.hddimg	${WORKDIR}/toFlash/edison-image-edison.hddimg

	install ${DEPLOY_DIR_IMAGE}/u-boot-edison.bin		${WORKDIR}/toFlash/
	install ${DEPLOY_DIR_IMAGE}/u-boot-edison.img		${WORKDIR}/toFlash/
	install ${DEPLOY_DIR_IMAGE}/u-boot-envs/*.bin		${WORKDIR}/toFlash/u-boot-envs/

	install ${DEPLOY_DIR_IMAGE}/ifwi/*.bin			${WORKDIR}/toFlash/

	install ${DEPLOY_DIR_IMAGE}/flashall/filter-dfu-out.js		${WORKDIR}/toFlash/
	install ${DEPLOY_DIR_IMAGE}/flashall/flashall.*			${WORKDIR}/toFlash/
	install ${DEPLOY_DIR_IMAGE}/flashall/ota_update.cmd		${WORKDIR}/toFlash/
	install ${DEPLOY_DIR_IMAGE}/flashall/pft-config-edison.xml	${WORKDIR}/toFlash/
	install ${DEPLOY_DIR_IMAGE}/flashall/FlashEdison.json		${WORKDIR}/toFlash/

	# Preprocess OTA script
	# Compute sha1sum of each file under toFlash and build an array containing
	# @@sha1_filename:SHA1VALUE
	pth_out=${WORKDIR}/toFlash/
	tab_size=$(for fil in $(find $pth_out -maxdepth 1 -type f -printf "%f\n") ; do sha1_hex=$(sha1sum "$pth_out$fil" | cut -c -40); echo "@@sha1_$fil:$sha1_hex" ; done ;)

	# iterate the array and do tag -> value substitution in ota_update.cmd
	for elem in $tab_size ; do echo "$elem" > /tmp/elem.txt ; IFS=':' read -a fld_elem < /tmp/elem.txt ; sed -i "s/${fld_elem[0]}/${fld_elem[1]}/g" ${WORKDIR}/toFlash/ota_update.cmd; done;

	# Convert OTA script to u-boot script
	mkimage -a 0x10000 -T script -C none -n 'Edison Updater script' -d ${WORKDIR}/toFlash/ota_update.cmd ${WORKDIR}/toFlash/ota_update.scr
	rm ${WORKDIR}/toFlash/ota_update.cmd

	# generate a formatted list of all packages included in the image
	awk '{print $1 " " $3}' ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.manifest > ${WORKDIR}/toFlash/package-list.txt

	tar cvjf ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.toflash.tar.bz2 -C ${WORKDIR} toFlash/

	rm -f ${DEPLOY_DIR_IMAGE}/${IMAGE_BASENAME}-${MACHINE}.toflash.tar.bz2
	ln -s ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.toflash.tar.bz2 ${DEPLOY_DIR_IMAGE}/${IMAGE_BASENAME}-${MACHINE}.toflash.tar.bz2
}