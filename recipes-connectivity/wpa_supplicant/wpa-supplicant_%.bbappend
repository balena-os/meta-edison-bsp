do_install_append_edison () {
	install -d ${D}${sysconfdir}/wpa_supplicant
	install -m 600 ${WORKDIR}/wpa_supplicant.conf-sane ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf
}
