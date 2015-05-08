require ../../../meta/recipes-core/images/core-image-base.bb

DESCRIPTION = "Openjdk test image"

IMAGE_FEATURES += "x11-base"

IMAGE_INSTALL += " \
	openjdk-7-jre \
	classpath \
	classpath-common \
	classpath-examples \
	classpath-tools \
	"

require ../../conf/machine/include/edison-image-config.inc

