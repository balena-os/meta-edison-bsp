# include this file to customize standard Yocto images for edison

IMAGE_FEATURES += "debug-tweaks package-management ssh-server-openssh"

ROOTFS_POSTPROCESS_COMMAND =+ " add_custom_smart_config ; "

add_custom_smart_config() {

	if [ -d ${IMAGE_ROOTFS}/var/lib/smart ] ; then
		smart	--data-dir=${IMAGE_ROOTFS}/var/lib/smart channel \
			--add edison-all type=rpm-md name="Edison Package Repository (all)" \
			baseurl=${FEED_URL}/repo/rpm/all -y
		smart	--data-dir=${IMAGE_ROOTFS}/var/lib/smart channel \
			--add edison-core2-32 type=rpm-md name="Edison Package Repository (core2-32)" \
			baseurl=${FEED_URL}/repo/rpm/core2_32 -y
		smart	--data-dir=${IMAGE_ROOTFS}/var/lib/smart channel \
			--add edison-machine type=rpm-md name="Edison Package Repository (edison-machine)" \
			baseurl=${FEED_URL}/repo/rpm/edison -y
	fi
}
