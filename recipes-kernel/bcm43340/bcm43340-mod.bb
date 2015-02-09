DESCRIPTION = "Broadcom wifi driver for the 43340"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=f9986853fb3b3403700e7535a392d014"

inherit module

PV = "1.141"
PR = "r48"

SRC_URI = "file://broadcom_cws.tar.bz2"

S = "${WORKDIR}/broadcom_cws/wlan/driver_bcm43x"

