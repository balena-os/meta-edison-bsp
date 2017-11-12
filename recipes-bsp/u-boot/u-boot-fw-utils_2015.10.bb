DESCRIPTION = "U-boot bootloader fw_printenv/setenv utils"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"
SECTION = "bootloader"

require u-boot-internal.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += " \
    file://fw_env.config \
    file://default-gcc.patch \
    "

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${CC} ${CFLAGS} ${LDFLAGS}" HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" V=1'

do_compile () {
  oe_runmake ${UBOOT_MACHINE}
  oe_runmake env
}

do_install () {
  install -d ${D}${sbindir}
  install -m 755 ${S}/tools/env/fw_printenv ${D}${sbindir}/fw_printenv
  # This is not a typo, this tool checks the args[0] to change its behavior a-la-busybox
  install -m 755 ${S}/tools/env/fw_printenv ${D}${sbindir}/fw_setenv
}

FILES_${PN} = "${sbindir}/*"
FILES_${PN} += "${sysconfdir}/fw_env.config"

DEPENDS = "u-boot"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INSANE_SKIP_${PN} = "already-stripped"
