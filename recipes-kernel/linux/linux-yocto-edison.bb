FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

LINUX_VERSION = "3.10.17"

SRC_URI = "git://github.com/01org/edison-linux.git;protocol=git;branch=edison-${LINUX_VERSION};nocheckout=1;name=machine"
SRC_URI += "file://defconfig"

SRCREV_machine = "65fe76300c984b17d06429f0dd0c8cf2a638fb21"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "edison"

