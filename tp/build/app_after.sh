#!/bin/bash

log="/data/appversion.log"

mylog() {
	dat=`date`
	echo "[${dat}] ${1}" >> $log
}
# after tar

mylog "exec app_after.sh success."
