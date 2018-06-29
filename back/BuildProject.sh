#!/bin/bash

cwd=$(pwd)

export CLASSPATH="$cwd/tomcat/lib/servlet-api.jar:$cwd/src:$cwd/tomcat/webapps/back/WEB-INF/classes"

javac -cp $CLASSPATH $cwd/source/*.java -d $cwd/classes

rm -v $cwd/tomcat/webapps/back/WEB-INF/web.xml
cp -v $cwd/dd/web.xml $cwd/tomcat/webapps/back/WEB-INF

rm -v -R -f $cwd/tomcat/webapps/back/WEB-INF/classes
cp -v -R $cwd/classes $cwd/tomcat/webapps/back/WEB-INF

./tomcat/bin/shutdown.sh
./tomcat/bin/startup.sh