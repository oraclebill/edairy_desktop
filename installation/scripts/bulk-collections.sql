

drop table collections;

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
	account_number      varchar(15) NULL ,
	isCleared     		bit NULL , 
	 PRIMARY KEY (trxn_id)	
)
;

load data infile '/Users/bjones/tmp/database2/436.dat' into table collections fields terminated by ',' enclosed by '\'' ;


alter table collections 
  add column memberid bigint(20) ,
  add column dairylocationid bigint(20) ,
  add column session_id bigint(20),
  add column driverid bigint(20),
  add column vehicleid bigint(20),
  add column groupid bigint(20)
;

alter table dairylocation 
    add index (code)
;

alter table membership 
    add index (membernumber)
;

alter table collections 
    add index (txn_date, session_id, dairylocationid)
;
  
update collections 
    set member_number = substring(member_number from 2)
;

update collections c, membership m
    set c.memberid = m.memberid 
    where c.member_number = m.membernumber
;
    
update collections c, dairylocation d
    set c.dairylocationid = d.id
    where c.route_num = d.code
;

select id into @unkcode from dairylocation where code = 'UNK';
update collections set dairylocationid = @unkcode where dairylocationid is null;
    
update collections c, person p 
  set driverid = p.personid 
  where c.operator_code = p.operatorcode
;

select personid into @person 
    from person 
    where operatorcode ='XXX'
;

update collections set driverid = @person 
    where driverid is null
;
    
update collections c, vehicle v 
    set c.vehicleid = v.vehicleid 
    where c.vehicle_num = v.registrationnumber
;

-- INSERT INTO `collectionsession` 
-- VALUES 
--     (1,'CollectionSession',0,'AM','Morning Session','1970-01-01 06:00:00','2010-10-17 02:44:16'),
--     (2,'CollectionSession',0,'PM','Evening Session','1970-01-01 14:00:00','2010-10-17 02:44:29');
--     (3,'CollectionSession',0,'XX','Unknown Session','1970-01-01 14:00:00','2010-10-17 02:44:29');

update collections c, collectionsession cs 
    set session_id = cs.id 
    where sessions = cs.code
;

select id into @unksess from collectionsession where code = 'XX';
update collections 
    set session_id = @unksess
    where session_id is null;

insert into collectiongroup 
        (status, type, journaldate, collectionsession_session_e_id, dairylocation_collectioncenter_id, recordtotal, employee_driver_personid, vehicle_vehicle_vehicleid)
    select 'NEW', 'ScaleGroup', txn_date, session_id, dairylocationid, sum(quantity), driverid, vehicleid
  from collections 
group by txn_date, session_id, dairylocationid 
;

update 
	collections c, collectiongroup g
set    
	c.groupid = g.journalid
where 
	c.txn_date = g.journaldate
	and c.session_id = collectionsession_session_e_id
	and c.dairylocationid = dairylocation_collectioncenter_id
    -- and c.driverid = employee_driver_personid
    -- and c.vehicleid = vehicle_vehicle_vehicleid 
;

insert into collectionjournalline
    (dtype, e_version, collectionjournalline_collectionjournal_e_id, recordedmember, quantity, unitofmeasure, membership_validatedmember_e_id, collectiontime, scaleserial, operatorcode, numcans, tripnumber, centernumber)
select 'ScaleImportRecord', 0, groupid, member_number, quantity, 'KILOGRAM', memberid, txn_time, scale_serial, operator_code, num_cans, trip_number, center_num
from collections;    

-- drop table collections;