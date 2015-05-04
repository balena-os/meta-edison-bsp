require ../../../meta/recipes-core/images/core-image-base.bb

DESCRIPTION = "Basic xfce image"

IMAGE_FEATURES += "x11-base"

IMAGE_INSTALL += " \
	packagegroup-xfce-base \
	x11vnc \
	"

require ../../conf/machine/include/edison-image-config.inc

