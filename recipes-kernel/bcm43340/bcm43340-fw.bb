DESCRIPTION = "Firmware files for use with Linux kernel"
SECTION = "kernel"

SRC_URI = "file://broadcom_cws.tar.bz2"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENCE.broadcom_bcm43xx;md5=3160c14df7228891b868060e1951dfbc"

PV = "6.20.190"
PR = "r3"

S = "${WORKDIR}/broadcom_cws/wlan/firmware"

inherit allarch update-alternatives

do_install() {
        install -v -d  ${D}/etc/firmware/
        install -m 0755 ${S}/bcmdhd_aob.cal_4334x_b0 ${D}/etc/firmware/bcmdhd_aob.cal
        install -m 0755 ${S}/bcmdhd.cal_4334x_b0 ${D}/etc/firmware/bcmdhd.cal
        install -m 0755 ${S}/fw_bcmdhd_p2p.bin_4334x_b0 ${D}/etc/firmware/fw_bcmdhd.bin
        install -m 0755 ${S}/LICENCE.broadcom_bcm43xx ${D}/etc/firmware/
}
