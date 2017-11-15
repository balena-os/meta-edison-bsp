FILESEXTRAPATHS_append := ":${THISDIR}/gcc-6.3/"

SRC_URI_remove = "file://0041-ssp_nonshared.patch"
SRC_URI_append = " file://0041-Add-ssp_nonshared-to-link-commandline-for-musl-targe.patch"
