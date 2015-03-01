inherit image_types

IMAGE_DEPENDS_boot = "dosfstools-native mtools-native"

IMAGE_CMD_boot () {

	BLOCKS=6144
	rm -f ${WORKDIR}/boot.img

	mkfs.vfat -n "boot" -S 512 -C ${WORKDIR}/boot.img $BLOCKS
	mcopy -i ${WORKDIR}/boot.img -s ${DEPLOY_DIR_IMAGE}/bzImage ::/vmlinuz

	install ${WORKDIR}/boot.img ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.hddimg
	ln -s ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.hddimg ${DEPLOY_DIR_IMAGE}/${IMAGE_BASENAME}-${MACHINE}.hddimg

}

IMAGE_CMD_toflash () {

	rm -rf 	${WORKDIR}/toFlash
	install -d ${WORKDIR}/toFlash/u-boot-envs/

	install ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext4	${WORKDIR}/toFlash/edison-image-edison.ext4
	install ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.hddimg	${WORKDIR}/toFlash/edison-image-edison.hddimg

	install ${DEPLOY_DIR_IMAGE}/u-boot-edison.bin		${WORKDIR}/toFlash/
	install ${DEPLOY_DIR_IMAGE}/u-boot-edison.img		${WORKDIR}/toFlash/
	install ${DEPLOY_DIR_IMAGE}/u-boot-envs/*.bin		${WORKDIR}/toFlash/u-boot-envs/

	install ${DEPLOY_DIR_IMAGE}/ifwi/*.bin			${WORKDIR}/toFlash/

	tar cvjf ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.toflash.tar.bz2 -C ${WORKDIR} toFlash/

	rm -f ${DEPLOY_DIR_IMAGE}/${IMAGE_BASENAME}-${MACHINE}.toflash.tar.bz2
	ln -s ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.toflash.tar.bz2 ${DEPLOY_DIR_IMAGE}/${IMAGE_BASENAME}-${MACHINE}.toflash.tar.bz2
}

IMAGE_TYPEDEP_toflash = "ext4 boot"
