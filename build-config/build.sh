#!/bin/sh

sdkroot=/Users/bjones/Development/Applications/eclipse/currentSDK
workspace_directory=/Users/bjones/Development/Projects/edairy_desktop
baseLocation=../edairy_desktop_lib/exported_target

tag=`date "+%Y%m%d%H%M"`
if test ${BUILD_TAG} 
then
	echo "IN HUDSON ENV - BUILD # {BUILD_TAG}"
	workspace_directory=${WORKSPACE}
	baseLocation=../../edairy_desktop_target_build/lastSuccessful/archive/targetPlatform
	sdkroot=${baseLocation}
	tag=${BUILD_TAG}
fi

launcher=${sdkroot}/plugins/org.eclipse.equinox.launcher_1.1.0.v20100507.jar
buildfile=${sdkroot}/plugins/org.eclipse.pde.build_3.6.1.R36x_v20100823/scripts/productBuild/productBuild.xml

java -jar ${launcher} \
	 -application org.eclipse.ant.core.antRunner \
	 -buildfile ${buildfile} \
	 -Dbuilder=${workspace_directory}/build-config \
	 -DbaseLocation=${baseLocation} \
	 -Dbuild.compiler=javac1.6 \
     -DbuildId=dairymgr-${tag}

