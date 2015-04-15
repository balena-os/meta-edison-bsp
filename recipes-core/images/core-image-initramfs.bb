# Simple initramfs image.
DESCRIPTION = "Small initramfs image capable of supporting fota."

PACKAGE_INSTALL = "initramfs-boot busybox udev base-passwd ${ROOTFS_BOOTSTRAP_INSTALL}"

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = ""

IMAGE_LINGUAS = ""

LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
inherit core-image

IMAGE_ROOTFS_SIZE = "8192"

BAD_RECOMMENDATIONS += "busybox-syslog systemd"

ROOTFS_POSTPROCESS_COMMAND += " edison_image_fixup ; "

edison_image_fixup() {

	cd ${IMAGE_ROOTFS}
	mkdir dev
	mknod -m 622 dev/console c 5 1
	mknod -m 622 dev/ttyMFD2 c 4 0
}
