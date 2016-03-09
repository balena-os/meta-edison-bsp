FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

LINUX_VERSION = "3.19.5"

SRC_URI = "git://github.com/01org/edison-linux.git;protocol=git;branch=wip-edison-${LINUX_VERSION};nocheckout=1;name=machine"
SRC_URI += "file://defconfig"

SRCREV_machine = "2a02f645592dc8a4f230fdbb79b00cf5eaac1764"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "edison"

