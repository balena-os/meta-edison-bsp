KBRANCH ?= "standard/base"

require recipes-kernel/linux/linux-yocto.inc

SRC_URI = " \
    git://github.com/resin-os/linux-edison;protocol=https;branch=eds-4.16 \
    file://0001-Add-kernel-parameter-to-enable-i2c_6-pinctrl-mapping.patch \
    file://0002-Enable-pwm0-1-2-3-pinmux-on-Edison-board.patch \
    "

SRCREV = "d245582e1b9b7c22394eb17fae8a7849f37b93cb"

LINUX_VERSION ?= "4.16.0"
LINUX_VERSION_EXTENSION = "-edison-${LINUX_KERNEL_TYPE}"

PV = "${LINUX_VERSION}+git${SRCPV}"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

# this tells yocto to use the defconfig supplied with the kernel
KBUILD_DEFCONFIG = "i386_defconfig"
# this tells yocto to expand the defconfig, i.e. make defconfig
KCONFIG_MODE = "--alldefconfig"

COMPATIBLE_MACHINE = "edison"
