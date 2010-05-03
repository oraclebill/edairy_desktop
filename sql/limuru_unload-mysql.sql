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
	 PRIMARY KEY (trxn_id, member_number, txn_date, sessions),
	
)
;

ALTER TABLE collections ADD  UNIQUE 
(
	trxn_id
)
;
CREATE TABLE farmer
(
	id_number     		varchar(25) NULL ,
	member_num    		varchar(10) NOT NULL ,
	account_number        	varchar(15) NOT NULL ,
	route_number  		varchar(15) NULL ,
	farmer_code   		char(1) NULL ,
	middle_name   		varchar(40) NULL ,
	first_name    		varchar(40) NULL ,
	last_name     		varchar(40) NULL , 
	 PRIMARY KEY (member_num, account_number)
	
)
;

ALTER TABLE farmer ADD  UNIQUE 
(
	member_num
)
;
CREATE TABLE reject
(
	reject_id     		bigint NOT NULL AUTO_INCREMENT ,
	can_number    		varchar(6) NULL ,
	member_number 		varchar(10) NOT NULL ,
	quantity      		decimal(2,0) NOT NULL ,
	route_number  		varchar(6) NOT NULL ,
	reject_date   		date NOT NULL ,
	sessions      		varchar(5) NOT NULL ,
	reject_reason 		varchar(20) NOT NULL ,
	bin_number    		varchar(10) NULL , 
	 PRIMARY KEY (reject_id, member_number)
	
)
;
CREATE TABLE route
(
	route_num     		varchar(8) NOT NULL ,
	route_name    		varchar(15) NULL ,
	opr_code      		varchar(8) NULL ,
	desc  			varchar(45) NULL ,
	scale_serial  		varchar(10) NULL ,
	route_desc    		varchar(45) NULL , 
	 PRIMARY KEY (route_num)
	
)
;

ALTER TABLE route ADD  UNIQUE 
(
	route_num
)
;
CREATE TABLE scale_user
(
	user_id       		integer NOT NULL AUTO_INCREMENT ,
	user_name     		varchar(10) NOT NULL ,
	first_name    		varchar(15) NULL ,
	last_name     		varchar(15) NULL ,
	passwrd       		varchar(10) NOT NULL ,
	user_type     		varchar(5) NOT NULL , 
	 PRIMARY KEY (user_id)
	
)
;

ALTER TABLE scale_user ADD  UNIQUE 
(
	user_id
)
;
COMMENT ON TABLE scale_user IS 
	'Dont worry about the choice of name, it''s just system users and their roles.'
;
CREATE TABLE truck
(
	reg_number    		varchar(10) NOT NULL ,
	truck_make    		varchar(25) NULL ,
	truck_model   		varchar(25) NULL ,
	driver_id     		varchar(10) NULL , 
	 PRIMARY KEY (reg_number)
	
)
;

ALTER TABLE truck ADD  UNIQUE 
(
	reg_number
)
;
CREATE TABLE erroraccount
(
	trxn_id       		integer NOT NULL AUTO_INCREMENT ,
	member_number 		varchar(10) NOT NULL ,
	txn_date      		date NOT NULL ,
	quantity      		double NOT NULL ,
	txn_time      		time NULL ,
	trip_number   		integer NULL ,
	operator_code 		varchar(8) NULL ,
	num_cans      		integer NULL ,
	sessions      		varchar(2) NULL ,
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
CREATE TABLE sales
(
	sales_id      		bigint NOT NULL AUTO_INCREMENT ,
	txn_date      		date NOT NULL ,
	quantity      		double NOT NULL ,
	receipt_number        	varchar(20) NULL ,
	sold_to       		varchar(20) NOT NULL ,
	route_number  		varchar(10) NOT NULL ,
	sessions      		varchar(5) NOT NULL , 
	 PRIMARY KEY (sales_id)
	
)
;

ALTER TABLE sales ADD  UNIQUE 
(
	sales_id
)
;
CREATE TABLE Accounts
(
	AccountID     		bigint NOT NULL AUTO_INCREMENT ,
	AccountNumber 		varchar(10) NOT NULL ,
	VendorAccountNumber   	varchar(10) NULL ,
	CustAccountNumber     	varchar(10) NULL ,
	OpenBalance   		double NULL ,
	OpenBalanceDate       	date NULL , 
	 PRIMARY KEY (AccountID, AccountNumber)
	
)
;

ALTER TABLE Accounts ADD  UNIQUE 
(
	AccountID
)
;
CREATE TABLE AReceivables
(
	ar_id 			bigint NOT NULL AUTO_INCREMENT ,
	member_number 		varchar(8) NOT NULL ,
	begin_date    		date NOT NULL ,
	end_date      		date NULL ,
	invoice_class_ref     	varchar(35) NULL ,
	amount        		double NULL , 
	 PRIMARY KEY (ar_id)
	
)
;

ALTER TABLE AReceivables ADD  UNIQUE 
(
	ar_id
)
;
CREATE TABLE CreditSales
(
	SalesID       		bigint NOT NULL AUTO_INCREMENT ,
	MemberNumber  		varchar(10) NOT NULL ,
	BeginDate     		date NOT NULL ,
	EndDate       		date NOT NULL ,
	SalesClass    		varchar(35) NOT NULL ,
	Amount        		double NOT NULL , 
	 PRIMARY KEY (SalesID)
	
)
;

ALTER TABLE CreditSales ADD  UNIQUE 
(
	SalesID
)
;
CREATE TABLE MemberShare
(
	share_id      		integer NOT NULL AUTO_INCREMENT ,
	code  			integer NOT NULL ,
	SharesName    		varchar(25) NOT NULL ,
	start_value   		double NOT NULL ,
	begin_date    		date NOT NULL ,
	IsFixedDeduction      	bit NOT NULL ,
	Rate  			double NOT NULL ,
	SharePriority 		integer NOT NULL , 
	 PRIMARY KEY (share_id)
	
)
;

ALTER TABLE MemberShare ADD  UNIQUE 
(
	share_id
)
;

ALTER TABLE MemberShare ADD  UNIQUE 
(
	code
)
;

ALTER TABLE MemberShare ADD  UNIQUE 
(
	SharePriority
)
;
CREATE TABLE ShareBalance
(
	ShareBalanceID        	bigint NOT NULL AUTO_INCREMENT ,
	ShareCode     		varchar(10) NOT NULL ,
	BalanceDate   		date NOT NULL ,
	ShareBalanceAmount    	double NOT NULL ,
	MemberNumber  		varchar(25) NOT NULL , 
	 PRIMARY KEY (ShareBalanceID)
	
)
;

ALTER TABLE ShareBalance ADD  UNIQUE 
(
	ShareBalanceID
)
;
CREATE TABLE ShareTransaction
(
	id    			integer NOT NULL AUTO_INCREMENT ,
	ShareCode     		integer NOT NULL ,
	FromDate      		date NOT NULL ,
	ToDate        		date NOT NULL ,
	AmountDeducted        	double NOT NULL ,
	MemberNumber  		varchar(25) NOT NULL , 
	 PRIMARY KEY (id, MemberNumber)
	
)
;

ALTER TABLE ShareTransaction ADD  UNIQUE 
(
	id
)
;
CREATE TABLE Price
(
	PriceCode     		integer NOT NULL AUTO_INCREMENT ,
	FromDate      		date NOT NULL ,
	ToDate        		date NOT NULL ,
	Amount        		double NOT NULL , 
	 PRIMARY KEY (PriceCode)
	
)
;

ALTER TABLE Price ADD  UNIQUE 
(
	PriceCode
)
;

ALTER TABLE Price ADD  UNIQUE 
(
	FromDate
)
;

ALTER TABLE Price ADD  UNIQUE 
(
	ToDate
)
;
CREATE TABLE Payments
(
	AccountNumber 		varchar(10) NULL ,
	vNum  			varchar(10) NULL ,
	cNum  			varchar(10) NULL ,
	FullName      		varchar(81) NULL ,
	rate  			double NULL ,
	Balance       		double NOT NULL ,
	SumQty        		double NOT NULL ,
	amtOwed       		double NULL ,
	sharesDeduction       	double NOT NULL ,
	stores        		double NOT NULL ,
	Vet_AI        		double NOT NULL ,
	Vet_Clinical  		double NOT NULL ,
	TotDeductions 		double NOT NULL ,
	NetPayable    		double NULL 
	
)
;
commit work
;


-- -----------------------------------------------
--   Reload data
-- -----------------------------------------------

load data infile '/Users/oraclebill/var/db/db/sybase/data/accounts.dat' into table accounts fields terminated by ',' enclosed by '\'' ;
load data infile '/Users/oraclebill/var/db/db/sybase/data/areceivables.dat' into table areceivables fields terminated by ',' enclosed by '\'' ;
load data infile '/Users/oraclebill/var/db/db/sybase/data/collections.dat' into table collections fields terminated by ',' enclosed by '\'' ;
load data infile '/Users/oraclebill/var/db/db/sybase/data/creditsales.dat' into table creditsales fields terminated by ',' enclosed by '\'' ;
load data infile '/Users/oraclebill/var/db/db/sybase/data/erroraccount.dat' into table erroraccount fields terminated by ',' enclosed by '\'' ;
load data infile '/Users/oraclebill/var/db/db/sybase/data/farmer.dat' into table farmer fields terminated by ',' enclosed by '\'' ;
load data infile '/Users/oraclebill/var/db/db/sybase/data/membershare.dat' into table membershare fields terminated by ',' enclosed by '\'' ;
load data infile '/Users/oraclebill/var/db/db/sybase/data/payments.dat' into table payments fields terminated by ',' enclosed by '\'' ;
load data infile '/Users/oraclebill/var/db/db/sybase/data/price.dat' into table price fields terminated by ',' enclosed by '\'' ;
load data infile '/Users/oraclebill/var/db/db/sybase/data/reject.dat' into table reject fields terminated by ',' enclosed by '\'' ;
load data infile '/Users/oraclebill/var/db/db/sybase/data/route.dat' into table route fields terminated by ',' enclosed by '\'' ;
load data infile '/Users/oraclebill/var/db/db/sybase/data/sales.dat' into table sales fields terminated by ',' enclosed by '\'' ;
load data infile '/Users/oraclebill/var/db/db/sybase/data/scale_user.dat' into table scale_user fields terminated by ',' enclosed by '\'' ;
load data infile '/Users/oraclebill/var/db/db/sybase/data/sharebalance.dat' into table sharebalance fields terminated by ',' enclosed by '\'' ;
load data infile '/Users/oraclebill/var/db/db/sybase/data/sharetransaction.dat' into table sharetransaction fields terminated by ',' enclosed by '\'' ;
load data infile '/Users/oraclebill/var/db/db/sybase/data/truck.dat' into table truck fields terminated by ',' enclosed by '\'' ;
commit work
;


-- -----------------------------------------------
--   Add foreign key definitions
-- -----------------------------------------------


ALTER TABLE collections
	ADD FOREIGN KEY CONSTRAINTS (member_number) 
	REFERENCES farmer (member_num)
;

CREATE INDEX indx_memNum_txnDate_session ON collections
(
	trxn_id ASC,
	member_number ASC,
	txn_date ASC,
	sessions ASC
)
;

CREATE  INDEX indx_member_number ON farmer
(
	member_num ASC
)
;

ALTER TABLE reject
	ADD FOREIGN KEY CONSTRAINTS (member_number) 
	REFERENCES farmer (member_num)
;

ALTER TABLE route
	ADD FOREIGN KEY CONSTRAINTS (route_num) 
	REFERENCES route (route_num)
;

CREATE INDEX indx_route_num ON route
(
	route_num ASC
)
;

CREATE INDEX indx_account_num ON Accounts
(
	AccountID ASC,
	AccountNumber ASC
)
;
commit work
;

