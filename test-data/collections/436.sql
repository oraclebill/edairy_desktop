--
-- This command file reloads a database that was unloaded using dbunload.
--
-- ( Version :  9.0.2.3045)
--


-- -----------------------------------------------
--   Create tables
-- -----------------------------------------------

CREATE TABLE collections
(
	trxn_id       		integer NOT NULL AUTO_INCREMENT ,
	member_number 		varchar(10) NOT NULL ,
	txn_date      		date NOT NULL ,
	quantity      		double NOT NULL ,
	txn_time      		time NULL ,
	trip_number   		integer NULL ,
	operator_code 		varchar(8) NULL ,
	num_cans      		integer NULL ,
	sessions      		varchar(2) NOT NULL ,
	center_num    		varchar(10) NULL ,
	route_num     		varchar(8) NULL ,
	dairy_code    		varchar(8) NULL ,
	scale_serial  		varchar(8) NULL ,
	vehicle_num   		varchar(8) NULL ,
	account_number        	varchar(15) NULL ,
	isCleared     		bit NULL , 
	 PRIMARY KEY (trxn_id)
	
)
;

load data infile '/Users/bjones/tmp/database2/436.dat' into table collections fields terminated by ',' enclosed by '\'' ;
