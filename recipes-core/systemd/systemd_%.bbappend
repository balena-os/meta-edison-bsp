FILESEXTRAPATHS_prepend_edison := "${THISDIR}/files:"

SRC_URI_append_edison = "file://wlan0.network"

FILES_${PN} += "${sysconfdir}/systemd/network/*"

do_install_append_edison () {
	install -d ${D}${sysconfdir}/systemd/network/
	install -m 0644 ${WORKDIR}/*.network ${D}${sysconfdir}/systemd/network/

	sed -i -e 's/#RuntimeWatchdogSec=0/RuntimeWatchdogSec=90/' ${D}${sysconfdir}/systemd/system.conf
}
