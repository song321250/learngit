#!/bin/bash

log="/data/appversion.log"

mylog() {
	dat=`date`
	echo "[${dat}] ${1}" >> $log
}
# before tar


mylog "exec app_before.sh success."
