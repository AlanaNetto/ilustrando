#!/bin/bash

cwd=$(pwd)

export CLASSPATH="$cwd/tomcat/lib/servlet-api.jar:$cwd/src:$cwd/tomcat/webapps/back/WEB-INF/classes"

rm -rf $cwd/classes
mkdir $cwd/classes

find $cwd/source/ -name "*.java" > $cwd/filesToCompile.txt
javac -cp $CLASSPATH @filesToCompile.txt -d $cwd/classes

rm -v $cwd/filesToCompile.txt

rm -v $cwd/tomcat/webapps/back/WEB-INF/web.xml
cp -v $cwd/dd/web.xml $cwd/tomcat/webapps/back/WEB-INF

rm -v -R -f $cwd/tomcat/webapps/back/WEB-INF/classes
cp -v -R $cwd/classes $cwd/tomcat/webapps/back/WEB-INF

./tomcat/bin/shutdown.sh
./tomcat/bin/startup.sh