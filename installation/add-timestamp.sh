#!/bin/sh

MYSQL=mysql
AWK=awk

DBNAME=dairytest
DBUSER=root
DBPASS=

${MYSQL} -u ${DBUSER} -B -N -e 'show tables ' ${DBNAME} \
  | ${AWK} '{ print "alter table " $1 " add column tstamp TIMESTAMP; " }' \
  | ${MYSQL} -u ${DBUSER} ${DBNAME}
