SUMMARY = "Bootable SD card creation script"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://mksdcard"

PR = "r0"

do_install() {
	install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/mksdcard ${D}${bindir}
}

inherit allarch

