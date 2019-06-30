#!/bin/bash
echo '开始dump jvm内存信息'
PIDS=`ps -ef |grep cable |grep java |awk '{print $2}'`
jmap -dump:live,format=b,file=../logs/cable-$PIDS.hprof $PIDS
echo 'dump 完成'