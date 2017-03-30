FILESEXTRAPATHS_prepend_edison := "${THISDIR}/base-files:"

do_install_append () {
    install -m 755 -d ${D}/factory
}
