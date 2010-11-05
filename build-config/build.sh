#!/bin/sh

sdkroot=/Users/bjones/Development/Applications/eclipse/currentSDK
launcher=${sdkroot}/plugins/org.eclipse.equinox.launcher_1.1.0.v20100507.jar
buildfile=${sdkroot}/plugins/org.eclipse.pde.build_3.6.1.R36x_v20100823/scripts/productBuild/productBuild.xml
tag=`date "+%Y%m%d%H%M"`
if [ ${BUILD_TAG} ]
then
	tag=${BUILD_TAG}
fi

java -jar ${launcher} \
	 -application org.eclipse.ant.core.antRunner \
	 -buildfile ${buildfile} \
	 -Dbuilder=/Users/bjones/Development/Projects/edairy_desktop/build-config \
	 -Dbuild.compiler=javac1.6 \
     -DbuildId=dairymgr-${tag}

