EXTRA_OECONF = " \
        --disable-tests \
	--disable-hotspot-tests \
	--disable-langtools-tests \
	--disable-jdk-tests \
	--disable-pulse-java \
	--disable-docs \
	--disable-nss \
	--disable-system-lcms \
	--disable-bootstrap \
	\
	--with-jdk-home=${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native \
	--with-rhino=${STAGING_DATADIR_JAVA}/rhino.jar \
	\
        --with-openjdk-src-zip=${WORKDIR}/${OPENJDK_FILE} \
	--with-hotspot-src-zip=${WORKDIR}/${HOTSPOT_FILE} \
	--with-corba-src-zip=${WORKDIR}/${CORBA_FILE} \
	--with-jaxp-src-zip=${WORKDIR}/${JAXP_FILE} \
	--with-jaxws-src-zip=${WORKDIR}/${JAXWS_FILE} \
	--with-jdk-src-zip=${WORKDIR}/${JDK_FILE} \
	--with-langtools-src-zip=${WORKDIR}/${LANGTOOLS_FILE} \
	\
	--with-parallel-jobs=${JDK_JOBS} \
	\
	--with-pkgversion=${PV} \
	--with-cc-for-build=${BUILD_CC} \
       "

HOTSPOT_CHANGESET = "37b254871acb"
SRC_URI[hotspot.md5sum] = "57f2077c4d4237de44b788e0a8456c83"
SRC_URI[hotspot.sha256sum] = "60268f9d792575ec26b8796753246aca70282937327c2fa855b3f0010638605e"
