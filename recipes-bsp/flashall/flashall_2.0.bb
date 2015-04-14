DESCRIPTION = "flashall scripts and supporting files"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ea398a763463b76b18da15f013c0c531"

inherit deploy

PR = "r1"

SRC_URI = " \
	   file://LICENSE \
	   file://filter-dfu-out.js \
	   file://flashall.bat \
	   file://flashall.sh \
	   file://ota_update.cmd \
	   file://FlashEdison.json \
	  "

S="${WORKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_deploy () {

	# remove any prior deployments
	rm -rf ${DEPLOYDIR}/flashall

	install -d ${DEPLOYDIR}/flashall

	install ${S}/filter-dfu-out.js		${DEPLOYDIR}/flashall
	install ${S}/flashall.*			${DEPLOYDIR}/flashall
	install ${S}/ota_update.cmd		${DEPLOYDIR}/flashall
	install ${S}/FlashEdison.json		${DEPLOYDIR}/flashall

}

addtask deploy before do_build after do_compile
