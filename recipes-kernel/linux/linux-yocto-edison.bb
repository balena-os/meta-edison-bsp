FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

LINUX_VERSION = "3.19.5"

SRC_URI = "git://github.com/01org/edison-linux.git;protocol=git;branch=wip-edison-${LINUX_VERSION};nocheckout=1;name=machine"
SRC_URI += "file://defconfig"

SRCREV_machine = "4bf19a00b2683d131158caaaffe2f947f42bac84"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "edison"

