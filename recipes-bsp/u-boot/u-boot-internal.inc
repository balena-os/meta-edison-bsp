PV = "2014.04-1"
PR = "r1"
S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "git://git.denx.de/u-boot.git;branch=master"
SRC_URI += "file://upstream_to_edison.patch"
SRC_URI += "file://enable_sd.patch"
SRC_URI += "file://${MACHINE}.env"
SRC_URI += "file://target_env/*.env"
SRCREV = "dda0dbfc69f3d560c87f5be85f127ed862ea6721"

do_configure_prepend() {
    sed -i -e 's:-Werror::g' ${S}/arch/x86/cpu/config.mk
}
