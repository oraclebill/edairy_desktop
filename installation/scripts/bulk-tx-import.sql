drop table tximport;

CREATE TABLE `tximport` (
  `type` varchar(40) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `reference` varchar(10) DEFAULT NULL,
  `member_num` varchar(8) DEFAULT NULL,
  `class` varchar(60) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL
) ENGINE=InnoDB ;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/01-2010-Clinical-CreditSales-xlsx.csv' 
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/01-2010-Stores-CreditSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/02-2010-A-I-CrediSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/02-2010-Clinical-CreditSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/02-2010-Stores-CreditSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/03-2010-A-I-CrediSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/03-2010-Clinical-CreditSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/03-2010-Stores-CreditSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/04-2010-A-I-CrediSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/04-2010-Clinical-CreditSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/04-2010-Stores-CreditSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/05-2010-A-I-CrediSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/05-2010-Clinical-CreditSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/05-2010-Stores-CreditSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/06-2010-A-I-CrediSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/06-2010-Clinical-CreditSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;

load data infile '/Users/bjones/Development/Projects/edairy_desktop/test-data/transaction-csv/06-2010-Stores-CreditSales-xlsx.csv'
	into table tximport 
	fields terminated by ',' 
	ignore 1 lines
	( type, @date, reference, member_num, class, amount )
	set `date` = str_to_date(@date, '%d.%m.%Y')
;


alter table tximport 
  add column accountid bigint(20),
  add column transactiontype varchar(60),
  add column source varchar(60),
  add column storeid bigint(20)
;

-- add account id
update tximport t, membership m
	set t.accountid = m.account
	where t.member_num = m.membernumber 
;


-- delete non-credit sale transactions (all null in sammpel data)
delete from tximport where type != 'Credit Sale'
;

update tximport
	set transactiontype = 'CREDIT' 
;

-- convert class --> source
update tximport
	set source = 'AIServices'
	where class = 'Vet Services:Clinical Services' 
;
update tximport
	set source = 'Clinical Svcs'
	where class = 'Vet Services:A.I' 
;
update tximport
	set source = 'Store Credit'
	where class like 'Stores:%' 
;
update tximport 
	set class = concat('R',substr(class, 9))
	where source = 'Store Credit'
;

-- lookup store codes
update tximport t, dairylocation s
	set t.storeid = s.id
	where t.class = s.code
;


insert into transaction 
	(dtype, e_version, transaction_account_accountid, transactiontype, source, transactiondate, referencenumber, amount, dairylocation_relatedlocation_id)
	select 'AccountTransaction', 0, accountid, transactiontype, source, `date`, reference, amount, storeid
	from tximport
;
	
-- set active member status
	