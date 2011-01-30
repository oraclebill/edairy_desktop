#!/bin/sh

MYSQL=mysql
AWK=awk

DBNAME=dairymgr
DBUSER=root
DBPASS=

${MYSQL} -u ${DBUSER} -B -N -e 'show tables ' ${DBNAME} \
  | ${AWK} '{ print "alter table " $1 " add column tstamp TIMESTAMP; " }' \
  | ${MYSQL} -v -v -v -u ${DBUSER} ${DBNAME}
