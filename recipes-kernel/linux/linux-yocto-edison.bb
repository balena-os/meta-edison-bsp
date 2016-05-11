FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

LINUX_VERSION = "3.19.5"

SRC_URI = "git://github.com/01org/edison-linux.git;protocol=git;branch=wip-edison-${LINUX_VERSION};nocheckout=1;name=machine"
SRC_URI += "file://defconfig"

SRCREV_machine = "2a02f645592dc8a4f230fdbb79b00cf5eaac1764"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

PV = "${LINUX_VERSION}+git${SRCPV}"

# Fix the KERNEL_OUTPUT variable
# Bug introduced in a6f52930a68d8462e23486d51cdda715072dd752
KERNEL_OUTPUT = "arch/x86/boot/${KERNEL_IMAGETYPE}"

COMPATIBLE_MACHINE = "edison"
