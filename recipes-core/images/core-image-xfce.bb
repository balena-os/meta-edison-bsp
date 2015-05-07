require ../../../meta/recipes-core/images/core-image-base.bb

DESCRIPTION = "Basic xfce image"

IMAGE_FEATURES += "x11-base"

IMAGE_INSTALL += " \
	packagegroup-xfce-base \
	x11vnc \
	xfwm4-theme-daloa \
	xfwm4-theme-kokodi \
	xfwm4-theme-moheli \
	\
	xfce4-cpufreq-plugin \
	xfce4-cpugraph-plugin \
	xfce4-datetime-plugin \
	xfce4-eyes-plugin \
	xfce4-clipman-plugin \
	xfce4-diskperf-plugin \
	xfce4-netload-plugin \
	xfce4-genmon-plugin \
	xfce4-xkb-plugin \
	xfce4-wavelan-plugin \
	xfce4-places-plugin \
	xfce4-systemload-plugin \
	xfce4-time-out-plugin \
	xfce4-embed-plugin \
	xfce4-weather-plugin \
	xfce4-fsguard-plugin \
	xfce4-battery-plugin \
	xfce4-mount-plugin \
	xfce4-closebutton-plugin \
	xfce4-equake-plugin \
	xfce4-notes-plugin \
	xfce4-whiskermenu-plugin \
	xfce4-mailwatch-plugin \
	\
	thunar-media-tags-plugin \
	thunar-archive-plugin \
	\
	xfce4-appfinder \
	xfce4-screenshooter \
	xfce4-mixer \
	ristretto \
	xfce4-taskmanager \
	gigolo \
	\
	claws-mail \
	midori \
	"

require ../../conf/machine/include/edison-image-config.inc

