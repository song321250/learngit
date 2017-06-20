#!/bin/bash

log="/data/appversion.log"

mylog() {
	dat=`date`
	echo "[${dat}] ${1}" >> $log
}
echo "" >> $log
echo "" >> $log
echo "" >> $log
mylog "******************** start ********************"
path_pwd=`pwd`
#before tar

if [ -f app_before.sh ];then
	sh app_before.sh
fi

#tar
cd /
tar zxf "$path_pwd/app.tgz"
cd -

#after tar
if [ -f app_after.sh ];then
	sh app_after.sh
fi

find /data/ -name "*.sh" | xargs chmod a+x


dat=`date "+%Y%m%d_%H%M%S"`
echo "install_time = $dat" >> /data/appversion

appv=`cat /data/appversion`
mylog "new appversion is ${appv}"
mylog "******************** end ********************"
echo "app install ok!!"
