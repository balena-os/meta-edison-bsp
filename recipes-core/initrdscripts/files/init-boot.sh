#!/bin/sh

PATH=/sbin:/bin:/usr/sbin:/usr/bin

mkdir /proc
mkdir /sys
mount -t proc proc /proc
mount -t sysfs sysfs /sys
mount -t devtmpfs none /dev

mkdir -p /run
mkdir -p /var/run
mkdir -p /var/log
mkdir -p /boot

syslogd

udevd --daemon
udevadm trigger --action=add

mount -t vfat /dev/mmcblk0p7 /boot

if [ -e /boot/fota.sh ]; then
	/boot/fota.sh
fi

exec sh
