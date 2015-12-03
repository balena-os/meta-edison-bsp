COMPATIBLE_MACHINE = "edison"

PV = "2015.10"
S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "git://github.com/01org/edison-u-boot.git;branch=edison-v2015.10;protocol=git" 
SRC_URI += "file://${MACHINE}.env"
SRC_URI += "file://target_env/*.env"
SRCREV = "f2f247ff0385fb4954b8c0671ef029bb25499ae2"
