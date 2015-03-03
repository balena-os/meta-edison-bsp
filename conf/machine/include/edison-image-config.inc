# include this file to customize standard Yocto images for edison

IMAGE_ROOTFS_SIZE = "524288"

IMAGE_FEATURES += "debug-tweaks package-management"

ROOTFS_POSTPROCESS_COMMAND += " edison_image_fixup ; "

edison_image_fixup() {

	cd ${IMAGE_ROOTFS}

	# set watchdog to 90 seconds
	if [ -e etc/systemd/system.conf ] ; then
		sed -i -e 's/#RuntimeWatchdogSec=0/RuntimeWatchdogSec=90/' etc/systemd/system.conf
	fi
}

ROOTFS_POSTPROCESS_COMMAND =+ " add_custom_smart_config ; "

add_custom_smart_config() {
        smart	--data-dir=${IMAGE_ROOTFS}/var/lib/smart channel \
		--add edison-all type=rpm-md name="Edison Package Repository (all)" \
		baseurl=http://sandbox.sakoman.com/feeds/edison-12.0.1/repo/rpm/all -y
        smart	--data-dir=${IMAGE_ROOTFS}/var/lib/smart channel \
		--add edison-core2-32 type=rpm-md name="Edison Package Repository (core2-32)" \
		baseurl=http://sandbox.sakoman.com/feeds/edison-12.0.1/repo/rpm/core2_32 -y
        smart	--data-dir=${IMAGE_ROOTFS}/var/lib/smart channel \
		--add edison-machine type=rpm-md name="Edison Package Repository (edison-machine)" \
		baseurl=http://sandbox.sakoman.com/feeds/edison-12.0.1/repo/rpm/edison -y
}
