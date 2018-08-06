KBRANCH ?= "standard/base"

inherit kernel
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

COMPATIBLE_MACHINE = "edison"

# work around a bug which makes the build system use the x86-64 kernel config instead of the x86-32 bits one
do_kernel_configme[depends] += "virtual/kernel:do_prepare_recipe_sysroot"
