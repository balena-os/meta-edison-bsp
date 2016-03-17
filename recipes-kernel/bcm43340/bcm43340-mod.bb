DESCRIPTION = "Broadcom wifi driver for the 43340"
LICENSE = "GPLv2"

SRC_URI = "git://github.com/01org/edison-bcm43340.git;branch=edison-3.19;protocol=git;rev=1eefda147030a887847f286ad4a587d03edcb22b"

LIC_FILES_CHKSUM = "file://COPYING;md5=f9986853fb3b3403700e7535a392d014"

inherit module

PV = "1.141"
PR = "r49"

S = "${WORKDIR}/git/"

