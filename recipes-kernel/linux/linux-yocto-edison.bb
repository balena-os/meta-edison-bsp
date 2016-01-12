FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

LINUX_VERSION = "3.19.5"

SRC_URI = "git://github.com/01org/edison-linux.git;protocol=git;branch=wip-edison-${LINUX_VERSION};nocheckout=1;name=machine"
SRC_URI += "file://defconfig"

SRCREV_machine = "ac21b0645a255aa6d2038dc542ecba06a628d4e0"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "edison"

