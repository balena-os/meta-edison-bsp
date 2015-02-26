# include this file to customize standard Yocto images for edison

IMAGE_ROOTFS_SIZE = "524288"

IMAGE_FEATURES += "debug-tweaks package-management"

# Do not use initrd
INITRD = ""
INITRD_IMAGE = ""

# Do not use legacy nor EFI BIOS
PCBIOS = "0"

# Do not support bootable USB stick
NOISO = "1"
ROOTFS = ""

# This is useless stuff, but necessary for building because
# inheriting bootimg also brings syslinux in..
AUTO_SYSLINUXCFG = "1"
SYSLINUX_ROOT = ""
SYSLINUX_TIMEOUT ?= "10"
SYSLINUX_LABELS ?= "boot install"
LABELS_append = " ${SYSLINUX_LABELS} "

# This has to be set after including core-image otherwise it's overriden with "1"
# and this cancel creation of the boot hddimg
NOHDD = "0"

inherit bootimg
do_bootimg[depends] += "${PN}:do_rootfs"

ROOTFS_POSTPROCESS_COMMAND += " edison_image_fixup ; "

edison_image_fixup() {

	cd ${IMAGE_ROOTFS}

	# set watchdog to 90 seconds
	if [ -e etc/systemd/system.conf ] ; then
		sed -i -e 's/#RuntimeWatchdogSec=0/RuntimeWatchdogSec=90/' etc/systemd/system.conf
	fi
}
