#!/bin/bash
cd `dirname $0`
cd ..
DEPLOY_DIR=`pwd`
CONFIG_FILE=$DEPLOY_DIR/conf/application.properties

JAR_FILE=adc-boot-*.jar
JAR_PATH=$DEPLOY_DIR/$JAR_FILE
PID=$(ps -ef | grep $JAR_FILE | grep java | grep -v grep | awk '{ print $2 }')
if [ -n "$PID" ]
then
    echo "ERROR: $JAR_FILE already started!"
    echo "PID: $PID"
    exit 1
fi

JMX_PORT=`cat ${CONFIG_FILE} | grep jmx | awk -F'=' '{print $2}'`

if [ "$JMX_PORT" = "" ]
then
        nohup java -Xmx512m -Xms512m -jar $JAR_PATH --spring.config.location=$CONFIG_FILE  > /dev/null 2>&1 &
else
        JAVA_OPTS=" -XX:+DisableAttachMechanism -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.local.only=true -Djava.rmi.server.useLocalHostname=true -Djava.rmi.server.useCodebaseOnly=true -Dcom.sun.management.jmxremote.port=${JMX_PORT} -Dcom.sun.management.jmxremote.rmi.port=${JMX_PORT}"
        nohup java $JAVA_OPTS -Xmx512m -Xms512m -jar $JAR_PATH --spring.config.location=$CONFIG_FILE  > /dev/null 2>&1 &
fi
