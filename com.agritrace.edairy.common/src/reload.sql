--
-- This command file reloads a database that was unloaded using "dbunload".
--
-- (Version:  11.0.1.2045)
--


-- Database file: /Users/oraclebill/var/db/sqlanywhere/dairy.db
-- Database CHAR collation: UTF8BIN, NCHAR collation: UCA
-- Connection Character Set: UTF-8
--
-- CREATE DATABASE command: CREATE DATABASE '/Users/oraclebill/var/db/sqlanywhere/dairy.db' LOG ON '/Users/oraclebill/var/db/sqlanywhere/dairy.log' CASE RESPECT ACCENT IGNORE PAGE SIZE 2048 COLLATION 'UTF8BIN' NCHAR COLLATION 'UCA' BLANK PADDING ON JCONNECT ON ASE COMPATIBLE CHECKSUM OFF
--


SET OPTION date_order          = 'YMD'
go

SET OPTION PUBLIC.preserve_source_format = 'OFF'
go

SET TEMPORARY OPTION tsql_outer_joins = 'ON'
go


-------------------------------------------------
--   Create dbspaces
-------------------------------------------------

CREATE DBSPACE "userspace" AS '/Users/oraclebill/var/db/sqlanywhere/dairy_data.db'
go


-------------------------------------------------
--   Create login policies
-------------------------------------------------


-------------------------------------------------
--   Create users
-------------------------------------------------

GRANT CONNECT,DBA,RESOURCE TO "DBA" IDENTIFIED BY sql
go

GRANT CONNECT,DBA,GROUP,RESOURCE TO "dbo"
go

GRANT CONNECT,DBA,RESOURCE TO "sa" IDENTIFIED BY ENCRYPTED '\x01\x5e\x2b\xaa\xae\xbb\xd5\x3c\x73\x78\x58\x71\x2a\xc6\x11\x2f\xfa\x5e\x72\xcb\xda\xb9\xb3\x77\x90\x74\xd3\x2b\x51\x8e\x0c\xba\x15\x4b\x07\xe3\x14'
go

GRANT CONNECT,RESOURCE,DBA TO "dairy" IDENTIFIED BY ENCRYPTED '\x01\x93\xef\x33\x53\x22\x63\x9f\x01\xd5\x01\x53\x2f\xcd\x95\x05\xe5\x83\x5f\xca\x21\x2e\x7b\xcc\x57\x8b\xb1\x71\x87\x79\x3c\x8c\x7d\x7d\xec\xef\xa7'
go


-------------------------------------------------
--   Create user types
-------------------------------------------------


-------------------------------------------------
--   Create group memberships
-------------------------------------------------


-------------------------------------------------
--   Create remote servers
-------------------------------------------------


-------------------------------------------------
--   Create dbspace permissions
-------------------------------------------------

begin
    for dbspaces as dbcurs cursor for 
	select privilege_type, dbspace_name, user_name 
		from SYS.SYSDBSPACEPERM p 
		join SYS.SYSDBSPACE d on p.dbspace_id = d.dbspace_id
		join SYS.SYSUSER u on u.user_id = p.grantee
    do
	execute immediate 'revoke ' + if privilege_type = 1 then 'CREATE' else 'UNKNOWN' endif + ' on "' + dbspace_name + '" from "' + user_name + '"'
    end for;
end

go

grant CREATE on "system" to "PUBLIC"
go

grant CREATE on "temporary" to "PUBLIC"
go

grant CREATE on "userspace" to "dairy"
go


-------------------------------------------------
--   Create external environments
-------------------------------------------------

IF EXISTS( SELECT * FROM SYS.SYSEXTERNENV WHERE name = 'java' ) THEN 
    ALTER EXTERNAL ENVIRONMENT "java"
        LOCATION '' 
END IF 
go

IF EXISTS( SELECT * FROM SYS.SYSEXTERNENV WHERE name = 'perl' ) THEN 
    ALTER EXTERNAL ENVIRONMENT "perl"
        LOCATION 'perl' 
END IF 
go

IF EXISTS( SELECT * FROM SYS.SYSEXTERNENV WHERE name = 'clr' ) THEN 
    ALTER EXTERNAL ENVIRONMENT "clr"
        LOCATION 'dbextclr11' 
END IF 
go

IF EXISTS( SELECT * FROM SYS.SYSEXTERNENV WHERE name = 'php' ) THEN 
    ALTER EXTERNAL ENVIRONMENT "php"
        LOCATION 'php' 
END IF 
go

IF EXISTS( SELECT * FROM SYS.SYSEXTERNENV WHERE name = 'c_esql32' ) THEN 
    ALTER EXTERNAL ENVIRONMENT "c_esql32"
        LOCATION 'bin32[SLASH]dbexternc11' 
END IF 
go

IF EXISTS( SELECT * FROM SYS.SYSEXTERNENV WHERE name = 'c_odbc32' ) THEN 
    ALTER EXTERNAL ENVIRONMENT "c_odbc32"
        LOCATION 'bin32[SLASH]dbexternc11' 
END IF 
go

IF EXISTS( SELECT * FROM SYS.SYSEXTERNENV WHERE name = 'c_esql64' ) THEN 
    ALTER EXTERNAL ENVIRONMENT "c_esql64"
        LOCATION 'bin64[SLASH]dbexternc11' 
END IF 
go

IF EXISTS( SELECT * FROM SYS.SYSEXTERNENV WHERE name = 'c_odbc64' ) THEN 
    ALTER EXTERNAL ENVIRONMENT "c_odbc64"
        LOCATION 'bin64[SLASH]dbexternc11' 
END IF 
go


-------------------------------------------------
--   Create external environment objects
-------------------------------------------------


-------------------------------------------------
--   Create tables
-------------------------------------------------

CREATE TABLE "dairy"."SEQUENCE" (
    "SEQ_NAME"                       varchar(50) NOT NULL
   ,"SEQ_COUNT"                      numeric(38,0) NULL
   ,PRIMARY KEY ("SEQ_NAME") 
)
go

CREATE TABLE "dairy"."DAIRY_EMPLOYMENTRELATIONSHIP" (
    "Dairy_DAIRYID"                  numeric(19,0) NOT NULL
   ,"staff_EMPLOYMENTRELATIONSHIPID" numeric(19,0) NOT NULL
   ,PRIMARY KEY ("Dairy_DAIRYID","staff_EMPLOYMENTRELATIONSHIPID") 
)
go

CREATE TABLE "dairy"."EMPLOYMENTRELATIONSHIP" (
    "EMPLOYMENTRELATIONSHIPID"       numeric(19,0) NOT NULL
   ,"STARTDATE"                      "datetime" NULL
   ,"PREVIOUSEMPID"                  numeric(19,0) NULL
   ,"ENDDATE"                        "datetime" NULL
   ,"JOBFUNCTION"                    varchar(255) NULL
   ,"EMPLOYEE_PERSONID"              numeric(19,0) NULL
   ,PRIMARY KEY ("EMPLOYMENTRELATIONSHIPID") 
)
go

CREATE TABLE "dairy"."DAIRY" (
    "DAIRYID"                        numeric(19,0) NOT NULL
   ,"KDBLICENSENUM"                  varchar(255) NULL
   ,"PUBLICDESCRIPTION"              varchar(255) NULL
   ,"KDBLICENSEEXPIRATIONDATE"       "datetime" NULL
   ,"NAME"                           varchar(255) NULL
   ,"KDBLICENSEEFFECTIVEDATE"        "datetime" NULL
   ,"MANAGER_EMPLOYMENTRELATIONSHIPID" numeric(19,0) NULL
   ,"LOCATION"                       varchar(255) NULL
   ,"TAG"                            varchar(255) NULL
   ,"SUBLOCATION"                    varchar(255) NULL
   ,"SECTION"                        varchar(255) NULL
   ,"POSTALCODE"                     varchar(255) NULL
   ,"DIVISION"                       varchar(255) NULL
   ,"VILLAGE"                        varchar(255) NULL
   ,"ADDRESS"                        varchar(255) NULL
   ,"LANDREFERENCENUMBER"            varchar(255) NULL
   ,"LONGITUDE"                      double NULL
   ,"LATITUDE"                       double NULL
   ,"DISTRICT"                       varchar(255) NULL
   ,"ESTATE"                         varchar(255) NULL
   ,PRIMARY KEY ("DAIRYID") 
)
go

CREATE TABLE "dairy"."PERSON_SECURITYROLE" (
    "SystemUser_PERSONID"            numeric(19,0) NOT NULL
   ,"securityRoles_SECURITYROLEID"   numeric(19,0) NOT NULL
   ,PRIMARY KEY ("SystemUser_PERSONID","securityRoles_SECURITYROLEID") 
)
go

CREATE TABLE "dairy"."CONTAINER" (
    "CONTAINERID"                    numeric(19,0) NOT NULL
   ,"CAPACITY"                       double NULL
   ,"UNITS"                          double NULL
   ,PRIMARY KEY ("CONTAINERID") 
)
go

CREATE TABLE "dairy"."ROUTE" (
    "ROUTEID"                        numeric(19,0) NOT NULL
   ,"DESCRIPTION"                    varchar(255) NULL
   ,"NAME"                           varchar(255) NULL
   ,PRIMARY KEY ("ROUTEID") 
)
go

CREATE TABLE "dairy"."DAIRY_MEMBERSHIP" (
    "Dairy_DAIRYID"                  numeric(19,0) NOT NULL
   ,"members_MEMBERSHIPID"           integer NOT NULL
   ,PRIMARY KEY ("Dairy_DAIRYID","members_MEMBERSHIPID") 
)
go

CREATE TABLE "dairy"."CONTACTMETHOD" (
    "CONTACTTYPE"                    integer NOT NULL
   ,"CONTACTMETHODID"                numeric(19,0) NULL
   ,"CONTACTINFO"                    varchar(255) NULL
   ,PRIMARY KEY ("CONTACTTYPE") 
)
go

CREATE TABLE "dairy"."DAIRY_VEHICLE" (
    "Dairy_DAIRYID"                  numeric(19,0) NOT NULL
   ,"vehicles_VEHICLEID"             numeric(19,0) NOT NULL
   ,PRIMARY KEY ("Dairy_DAIRYID","vehicles_VEHICLEID") 
)
go

CREATE TABLE "dairy"."DAIRY_EMPLOYEE" (
    "Dairy_DAIRYID"                  numeric(19,0) NOT NULL
   ,"staff_EMPLOYMENTRELATIONSHIPID" numeric(19,0) NOT NULL
   ,PRIMARY KEY ("Dairy_DAIRYID","staff_EMPLOYMENTRELATIONSHIPID") 
)
go

CREATE TABLE "dairy"."EMPLOYEE" (
    "EMPLOYMENTRELATIONSHIPID"       numeric(19,0) NOT NULL
   ,"STARTDATE"                      "datetime" NULL
   ,"PREVIOUSEMPID"                  numeric(19,0) NULL
   ,"ENDDATE"                        "datetime" NULL
   ,"JOBFUNCTION"                    varchar(255) NULL
   ,"EMPLOYEE_PERSONID"              numeric(19,0) NULL
   ,PRIMARY KEY ("EMPLOYMENTRELATIONSHIPID") 
)
go

CREATE TABLE "dairy"."DAIRY_CONTAINER" (
    "Dairy_DAIRYID"                  numeric(19,0) NOT NULL
   ,"bins_CONTAINERID"               numeric(19,0) NOT NULL
   ,PRIMARY KEY ("Dairy_DAIRYID","bins_CONTAINERID") 
)
go

CREATE TABLE "dairy"."PERSON" (
    "PERSONID"                       numeric(19,0) NOT NULL
   ,"DTYPE"                          varchar(31) NULL
   ,"MIDDLENAME"                     varchar(255) NULL
   ,"ADDITIONALNAMES"                "image" NULL
   ,"HONORIFIC"                      varchar(255) NULL
   ,"FAMILYNAME"                     varchar(255) NULL
   ,"GIVEN_NAME"                     varchar(255) NULL
   ,"SUFFIX"                         varchar(255) NULL
   ,"USERNAME"                       varchar(255) NULL
   ,"SYSTEMUSERID"                   numeric(19,0) NULL
   ,"PASSWORD"                       varchar(255) NULL
   ,PRIMARY KEY ("PERSONID") 
)
go

CREATE TABLE "dairy"."DAIRY_ROUTE" (
    "Dairy_DAIRYID"                  numeric(19,0) NOT NULL
   ,"routes_ROUTEID"                 numeric(19,0) NOT NULL
   ,PRIMARY KEY ("Dairy_DAIRYID","routes_ROUTEID") 
)
go

CREATE TABLE "dairy"."SECURITYROLE" (
    "SECURITYROLEID"                 numeric(19,0) NOT NULL
   ,"DESCRIPTION"                    varchar(255) NULL
   ,"SYSTEMDEFINED"                  bit NULL
   ,"NAME"                           varchar(255) NULL
   ,PRIMARY KEY ("SECURITYROLEID") 
)
go

CREATE TABLE "dairy"."VEHICLE" (
    "VEHICLEID"                      numeric(19,0) NOT NULL
   ,"REGISTRATIONNUMBER"             varchar(255) NULL
   ,"MODEL"                          varchar(255) NULL
   ,"COLOR"                          varchar(255) NULL
   ,"MODELYEAR"                      integer NULL
   ,"VEHICLEIDENTIFICATIONNUMBER"    varchar(255) NULL
   ,"MAKE"                           varchar(255) NULL
   ,PRIMARY KEY ("VEHICLEID") 
)
go

CREATE TABLE "dairy"."DAIRY_SECURITYROLE" (
    "Dairy_DAIRYID"                  numeric(19,0) NOT NULL
   ,"roles_SECURITYROLEID"           numeric(19,0) NOT NULL
   ,PRIMARY KEY ("Dairy_DAIRYID","roles_SECURITYROLEID") 
)
go

create temporary procedure sa_unload_display_table_status( 
    msgid int, ord int, numtabs int, user_name char(128), table_name char(128) )
begin 
  declare @fullmsg long varchar; 
  set @fullmsg = lang_message( msgid ) ||
      ' (' || ord || '/' || numtabs || ') ' ||
      '"' || user_name || '"."' || table_name || '"'; 
  message @fullmsg to client; 
end
go


-------------------------------------------------
--   Reload column statistics
-------------------------------------------------


-------------------------------------------------
--   Reload data
-------------------------------------------------

call sa_unload_display_table_status( 17737, 1, 18, 'dairy', 'SEQUENCE' )
go

LOAD TABLE "dairy"."SEQUENCE" ("SEQ_NAME","SEQ_COUNT")
    FROM '/Users/oraclebill/tmp/unload/725.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 2, 18, 'dairy', 'DAIRY_EMPLOYMENTRELATIONSHIP' )
go

LOAD TABLE "dairy"."DAIRY_EMPLOYMENTRELATIONSHIP" ("Dairy_DAIRYID","staff_EMPLOYMENTRELATIONSHIPID")
    FROM '/Users/oraclebill/tmp/unload/743.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 3, 18, 'dairy', 'EMPLOYMENTRELATIONSHIP' )
go

LOAD TABLE "dairy"."EMPLOYMENTRELATIONSHIP" ("EMPLOYMENTRELATIONSHIPID","STARTDATE","PREVIOUSEMPID","ENDDATE","JOBFUNCTION","EMPLOYEE_PERSONID")
    FROM '/Users/oraclebill/tmp/unload/745.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 4, 18, 'dairy', 'DAIRY' )
go

LOAD TABLE "dairy"."DAIRY" ("DAIRYID","KDBLICENSENUM","PUBLICDESCRIPTION","KDBLICENSEEXPIRATIONDATE","NAME","KDBLICENSEEFFECTIVEDATE","MANAGER_EMPLOYMENTRELATIONSHIPID","LOCATION","TAG","SUBLOCATION","SECTION","POSTALCODE","DIVISION","VILLAGE","ADDRESS","LANDREFERENCENUMBER","LONGITUDE","LATITUDE","DISTRICT","ESTATE")
    FROM '/Users/oraclebill/tmp/unload/755.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 5, 18, 'dairy', 'PERSON_SECURITYROLE' )
go

LOAD TABLE "dairy"."PERSON_SECURITYROLE" ("SystemUser_PERSONID","securityRoles_SECURITYROLEID")
    FROM '/Users/oraclebill/tmp/unload/756.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 6, 18, 'dairy', 'CONTAINER' )
go

LOAD TABLE "dairy"."CONTAINER" ("CONTAINERID","CAPACITY","UNITS")
    FROM '/Users/oraclebill/tmp/unload/757.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 7, 18, 'dairy', 'ROUTE' )
go

LOAD TABLE "dairy"."ROUTE" ("ROUTEID","DESCRIPTION","NAME")
    FROM '/Users/oraclebill/tmp/unload/758.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 8, 18, 'dairy', 'DAIRY_MEMBERSHIP' )
go

LOAD TABLE "dairy"."DAIRY_MEMBERSHIP" ("Dairy_DAIRYID","members_MEMBERSHIPID")
    FROM '/Users/oraclebill/tmp/unload/759.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 9, 18, 'dairy', 'CONTACTMETHOD' )
go

LOAD TABLE "dairy"."CONTACTMETHOD" ("CONTACTTYPE","CONTACTMETHODID","CONTACTINFO")
    FROM '/Users/oraclebill/tmp/unload/760.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 10, 18, 'dairy', 'DAIRY_VEHICLE' )
go

LOAD TABLE "dairy"."DAIRY_VEHICLE" ("Dairy_DAIRYID","vehicles_VEHICLEID")
    FROM '/Users/oraclebill/tmp/unload/761.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 11, 18, 'dairy', 'DAIRY_EMPLOYEE' )
go

LOAD TABLE "dairy"."DAIRY_EMPLOYEE" ("Dairy_DAIRYID","staff_EMPLOYMENTRELATIONSHIPID")
    FROM '/Users/oraclebill/tmp/unload/762.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 12, 18, 'dairy', 'EMPLOYEE' )
go

LOAD TABLE "dairy"."EMPLOYEE" ("EMPLOYMENTRELATIONSHIPID","STARTDATE","PREVIOUSEMPID","ENDDATE","JOBFUNCTION","EMPLOYEE_PERSONID")
    FROM '/Users/oraclebill/tmp/unload/763.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 13, 18, 'dairy', 'DAIRY_CONTAINER' )
go

LOAD TABLE "dairy"."DAIRY_CONTAINER" ("Dairy_DAIRYID","bins_CONTAINERID")
    FROM '/Users/oraclebill/tmp/unload/764.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 14, 18, 'dairy', 'PERSON' )
go

LOAD TABLE "dairy"."PERSON" ("PERSONID","DTYPE","MIDDLENAME","ADDITIONALNAMES","HONORIFIC","FAMILYNAME","GIVEN_NAME","SUFFIX","USERNAME","SYSTEMUSERID","PASSWORD")
    FROM '/Users/oraclebill/tmp/unload/765.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 15, 18, 'dairy', 'DAIRY_ROUTE' )
go

LOAD TABLE "dairy"."DAIRY_ROUTE" ("Dairy_DAIRYID","routes_ROUTEID")
    FROM '/Users/oraclebill/tmp/unload/766.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 16, 18, 'dairy', 'SECURITYROLE' )
go

LOAD TABLE "dairy"."SECURITYROLE" ("SECURITYROLEID","DESCRIPTION","SYSTEMDEFINED","NAME")
    FROM '/Users/oraclebill/tmp/unload/767.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 17, 18, 'dairy', 'VEHICLE' )
go

LOAD TABLE "dairy"."VEHICLE" ("VEHICLEID","REGISTRATIONNUMBER","MODEL","COLOR","MODELYEAR","VEHICLEIDENTIFICATIONNUMBER","MAKE")
    FROM '/Users/oraclebill/tmp/unload/768.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

call sa_unload_display_table_status( 17737, 18, 18, 'dairy', 'DAIRY_SECURITYROLE' )
go

LOAD TABLE "dairy"."DAIRY_SECURITYROLE" ("Dairy_DAIRYID","roles_SECURITYROLEID")
    FROM '/Users/oraclebill/tmp/unload/769.dat'
    FORMAT 'TEXT' QUOTES ON
    ORDER OFF ESCAPES ON
    CHECK CONSTRAINTS OFF COMPUTES OFF
    STRIP OFF DELIMITED BY ','
    ENCODING 'UTF-8'
go

commit work
go


-------------------------------------------------
--   Create text configurations
-------------------------------------------------


-------------------------------------------------
--   Create materialized views
-------------------------------------------------

commit
go



-------------------------------------------------
--   Create indexes
-------------------------------------------------

call sa_unload_display_table_status( 17738, 1, 18, 'dairy', 'SEQUENCE' )
go

call sa_unload_display_table_status( 17738, 2, 18, 'dairy', 'DAIRY_EMPLOYMENTRELATIONSHIP' )
go

ALTER TABLE "dairy"."DAIRY_EMPLOYMENTRELATIONSHIP"
    ADD FOREIGN KEY "FK_DAIRY_EMPLOYMENTRELATIONSHIP_staff_EMPLOYMENTRELATIONSHIPID" ("staff_EMPLOYMENTRELATIONSHIPID")
    REFERENCES "dairy"."EMPLOYMENTRELATIONSHIP" ("EMPLOYMENTRELATIONSHIPID")
    
go

call sa_unload_display_table_status( 17738, 3, 18, 'dairy', 'EMPLOYMENTRELATIONSHIP' )
go

call sa_unload_display_table_status( 17738, 4, 18, 'dairy', 'DAIRY' )
go

ALTER TABLE "dairy"."DAIRY"
    ADD FOREIGN KEY "FK_DAIRY_MANAGER_EMPLOYMENTRELATIONSHIPID" ("MANAGER_EMPLOYMENTRELATIONSHIPID")
    REFERENCES "dairy"."EMPLOYEE" ("EMPLOYMENTRELATIONSHIPID")
    
go

call sa_unload_display_table_status( 17738, 5, 18, 'dairy', 'PERSON_SECURITYROLE' )
go

ALTER TABLE "dairy"."PERSON_SECURITYROLE"
    ADD FOREIGN KEY "FK_PERSON_SECURITYROLE_SystemUser_PERSONID" ("SystemUser_PERSONID")
    REFERENCES "dairy"."PERSON" ("PERSONID")
    
go

ALTER TABLE "dairy"."PERSON_SECURITYROLE"
    ADD FOREIGN KEY "FK_PERSON_SECURITYROLE_securityRoles_SECURITYROLEID" ("securityRoles_SECURITYROLEID")
    REFERENCES "dairy"."SECURITYROLE" ("SECURITYROLEID")
    
go

call sa_unload_display_table_status( 17738, 6, 18, 'dairy', 'CONTAINER' )
go

call sa_unload_display_table_status( 17738, 7, 18, 'dairy', 'ROUTE' )
go

call sa_unload_display_table_status( 17738, 8, 18, 'dairy', 'DAIRY_MEMBERSHIP' )
go

ALTER TABLE "dairy"."DAIRY_MEMBERSHIP"
    ADD FOREIGN KEY "FK_DAIRY_MEMBERSHIP_Dairy_DAIRYID" ("Dairy_DAIRYID")
    REFERENCES "dairy"."DAIRY" ("DAIRYID")
    
go

call sa_unload_display_table_status( 17738, 9, 18, 'dairy', 'CONTACTMETHOD' )
go

call sa_unload_display_table_status( 17738, 10, 18, 'dairy', 'DAIRY_VEHICLE' )
go

ALTER TABLE "dairy"."DAIRY_VEHICLE"
    ADD FOREIGN KEY "FK_DAIRY_VEHICLE_vehicles_VEHICLEID" ("vehicles_VEHICLEID")
    REFERENCES "dairy"."VEHICLE" ("VEHICLEID")
    
go

ALTER TABLE "dairy"."DAIRY_VEHICLE"
    ADD FOREIGN KEY "FK_DAIRY_VEHICLE_Dairy_DAIRYID" ("Dairy_DAIRYID")
    REFERENCES "dairy"."DAIRY" ("DAIRYID")
    
go

call sa_unload_display_table_status( 17738, 11, 18, 'dairy', 'DAIRY_EMPLOYEE' )
go

ALTER TABLE "dairy"."DAIRY_EMPLOYEE"
    ADD FOREIGN KEY "FK_DAIRY_EMPLOYEE_Dairy_DAIRYID" ("Dairy_DAIRYID")
    REFERENCES "dairy"."DAIRY" ("DAIRYID")
    
go

ALTER TABLE "dairy"."DAIRY_EMPLOYEE"
    ADD FOREIGN KEY "FK_DAIRY_EMPLOYEE_staff_EMPLOYMENTRELATIONSHIPID" ("staff_EMPLOYMENTRELATIONSHIPID")
    REFERENCES "dairy"."EMPLOYEE" ("EMPLOYMENTRELATIONSHIPID")
    
go

call sa_unload_display_table_status( 17738, 12, 18, 'dairy', 'EMPLOYEE' )
go

ALTER TABLE "dairy"."EMPLOYEE"
    ADD FOREIGN KEY "FK_EMPLOYEE_EMPLOYEE_PERSONID" ("EMPLOYEE_PERSONID")
    REFERENCES "dairy"."PERSON" ("PERSONID")
    
go

call sa_unload_display_table_status( 17738, 13, 18, 'dairy', 'DAIRY_CONTAINER' )
go

ALTER TABLE "dairy"."DAIRY_CONTAINER"
    ADD FOREIGN KEY "FK_DAIRY_CONTAINER_bins_CONTAINERID" ("bins_CONTAINERID")
    REFERENCES "dairy"."CONTAINER" ("CONTAINERID")
    
go

ALTER TABLE "dairy"."DAIRY_CONTAINER"
    ADD FOREIGN KEY "FK_DAIRY_CONTAINER_Dairy_DAIRYID" ("Dairy_DAIRYID")
    REFERENCES "dairy"."DAIRY" ("DAIRYID")
    
go

call sa_unload_display_table_status( 17738, 14, 18, 'dairy', 'PERSON' )
go

call sa_unload_display_table_status( 17738, 15, 18, 'dairy', 'DAIRY_ROUTE' )
go

ALTER TABLE "dairy"."DAIRY_ROUTE"
    ADD FOREIGN KEY "FK_DAIRY_ROUTE_Dairy_DAIRYID" ("Dairy_DAIRYID")
    REFERENCES "dairy"."DAIRY" ("DAIRYID")
    
go

ALTER TABLE "dairy"."DAIRY_ROUTE"
    ADD FOREIGN KEY "FK_DAIRY_ROUTE_routes_ROUTEID" ("routes_ROUTEID")
    REFERENCES "dairy"."ROUTE" ("ROUTEID")
    
go

call sa_unload_display_table_status( 17738, 16, 18, 'dairy', 'SECURITYROLE' )
go

call sa_unload_display_table_status( 17738, 17, 18, 'dairy', 'VEHICLE' )
go

call sa_unload_display_table_status( 17738, 18, 18, 'dairy', 'DAIRY_SECURITYROLE' )
go

ALTER TABLE "dairy"."DAIRY_SECURITYROLE"
    ADD FOREIGN KEY "FK_DAIRY_SECURITYROLE_roles_SECURITYROLEID" ("roles_SECURITYROLEID")
    REFERENCES "dairy"."SECURITYROLE" ("SECURITYROLEID")
    
go

ALTER TABLE "dairy"."DAIRY_SECURITYROLE"
    ADD FOREIGN KEY "FK_DAIRY_SECURITYROLE_Dairy_DAIRYID" ("Dairy_DAIRYID")
    REFERENCES "dairy"."DAIRY" ("DAIRYID")
    
go

commit work
go


-------------------------------------------------
--   Create immediate materialized views
-------------------------------------------------

commit
go



-------------------------------------------------
--   Create functions
-------------------------------------------------

commit
go



-------------------------------------------------
--   Create views
-------------------------------------------------

commit
go


SET TEMPORARY OPTION force_view_creation='ON'
go

SET TEMPORARY OPTION force_view_creation='OFF'
go

call dbo.sa_recompile_views(1)
go


-------------------------------------------------
--   Create user messages
-------------------------------------------------


-------------------------------------------------
--   Create procedures
-------------------------------------------------

commit
go


call dbo.sa_recompile_views(0)
go


-------------------------------------------------
--   Create triggers
-------------------------------------------------

commit
go



-------------------------------------------------
--   Create SQL Remote definitions
-------------------------------------------------

GRANT PUBLISH TO "dairy"
go

GRANT CONSOLIDATE TO "sa" TYPE "FILE" ADDRESS 'trenton'
go


-------------------------------------------------
--   Create MobiLink definitions
-------------------------------------------------


-------------------------------------------------
--   Create Synchronization profiles
-------------------------------------------------


-------------------------------------------------
--   Create logins
-------------------------------------------------


-------------------------------------------------
--   Create events
-------------------------------------------------

commit
go



-------------------------------------------------
--   Create services
-------------------------------------------------

commit
go



-------------------------------------------------
--   Set DBA password
-------------------------------------------------

GRANT CONNECT TO DBA IDENTIFIED BY ENCRYPTED '\x01\x3f\x57\x1f\x5d\xf7\x28\x8c\xde\x00\xa5\x61\x2c\xde\x63\xbf\xfd\x9a\xd3\xe0\xe9\x3e\x39\xb3\x4f\x88\x1f\x28\xde\x30\xa3\xee\xee\xe1\x9e\xe2\x87'
go


-------------------------------------------------
--   Create options
-------------------------------------------------

SET OPTION date_order =
go

SET OPTION PUBLIC.preserve_source_format =
go

SET OPTION "PUBLIC"."preserve_source_format"='On'
go
