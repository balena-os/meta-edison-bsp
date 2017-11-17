KBRANCH ?= "standard/base"

require recipes-kernel/linux/linux-yocto.inc

SRC_URI = " \
    git://github.com/resin-os/linux-edison;protocol=https;branch=eds-4.13 \
    file://0001-Add-kernel-parameter-to-enable-i2c_6-pinctrl-mapping.patch \
    "

SRCREV = "54f9552249b720ef9d33a7eb9e0d1f8f53ce1025"

LINUX_VERSION ?= "4.13.0"
LINUX_VERSION_EXTENSION = "-edison-${LINUX_KERNEL_TYPE}"

PV = "${LINUX_VERSION}+git${SRCPV}"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

# this tells yocto to use the defconfig supplied with the kernel
KBUILD_DEFCONFIG = "i386_defconfig"
# this tells yocto to expand the defconfig, i.e. make defconfig
KCONFIG_MODE = "--alldefconfig"

COMPATIBLE_MACHINE = "edison"
