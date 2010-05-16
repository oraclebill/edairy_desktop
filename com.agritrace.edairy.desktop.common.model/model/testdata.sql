
-- 
--
--
insert into role (dairyid, roleid, name, description)
	values (1, 1, "Administrator", "System Admin");
insert into role (dairyid, roleid, name, description)
	values (1, 100, "Manager", "Dairy Manager");
insert into role (dairyid, roleid, name, description)
	values (1, 101, "Staff", "Dairy Staff");
insert into role (dairyid, roleid, name, description)
	values (1, 1000, "Guest", "Guest User");
	
-- locations
insert into location(locationid, address, section, estate, village, district, province, postalcode, postbox) 
	values (1, '10 street road', '', '', '', 'karuri', 'kiambu', 'central', '1');
insert into location(locationid, address, section, estate, village, district, province, postalcode, postbox) 
	values (2, '20 street road', 'c', '', '', 'karuri', 'kiambu', 'central', '2');
insert into location(locationid, address, section, estate, village, district, province, postalcode, postbox) 
	values (3, '30 street road', '', 'c', '', 'karuri', 'kiambu', 'central', '5');
insert into location(locationid, address, section, estate, village, district, province, postalcode, postbox) 
	values (4, '40 street road', '', '', 'c', 'karuri', 'kiambu', 'central', '');
insert into location(locationid, address, section, estate, village, district, province, postalcode, postbox) 
	values (5, '50 street road', '', 'c', 'v', 'karuri', 'kiambu', 'central', '');
	
	
-- persons	
insert into person(personid, familyname, given_name)
	values (1, 'smith', 'steven');
	
	insert into contact_method(contact_methodid, personid, contact_info, contact_info_type)
		values (1, 1, 'PHON', '+1 215-878-6947');
	
insert into person(personid, familyname, given_name)
	values (2, 'jones', 'steven');
	
	insert into contact_method(contact_methodid, personid, contact_info, contact_info_type)
		values (2, 2, 'PHON', '+1 215-878-6947');
	insert into contact_method(contact_methodid, personid, contact_info, contact_info_type)
		values (5, 2, 'FAX', '+1 215-878-6947');
	
insert into person(personid, familyname, given_name)
	values (3, 'smith', 'bill');
	
	insert into contact_method(contact_methodid, personid, contact_info, contact_info_type)
		values (3, 3, 'PHON', '+1 215-878-6947');
	insert into contact_method(contact_methodid, personid, contact_info, contact_info_type)
		values (6, 3, 'IM', 'aim:stickybill');
	insert into contact_method(contact_methodid, personid, contact_info, contact_info_type)
		values (7, 3, 'EMAI', 'stickybill@gmail.com');
	
insert into person(personid, familyname, given_name)
	values (4, 'jones', 'bill');
	
	insert into contact_method(contact_methodid, personid, contact_info, contact_info_type)
		values (4, 4, 'EMAI', '+1 215-878-6947');
	
insert into person(personid, familyname, given_name)
	values (5, 'person5', '5person');
	
-- farms tbd
insert into farm(farmid, locationid, owner_personid, name, license_number )
	values (1, 2, 2, 'steven jones farm', '12345457');
insert into farm(farmid, locationid, owner_personid, name, license_number )
	values (2, 3, 3, 'bill smiths first farm', '123454257');
insert into farm(farmid, locationid, owner_personid, name, license_number )
	values (3, 4, 3, 'bill smiths second farm', '123245457');
insert into farm(farmid, locationid, owner_personid, name, license_number )
	values (4, 5, 4, 'bill jones farm', '123425457');
	
-- dairy 
insert into dairy(dairyid, locationid, legal_name)
	values(1, 1, 'First Dairies');

	insert into role(dairyid, roleid, name)
		values (1, 0, 'MANAGER')	;
	
	insert into employee(dairyid, employeeid, personid, startdate, jobfunction, roleid)
		values (1, 1, 1, '01/01/2008', 'MANAGER', 0);
		
	insert into dairy_route(dairyid, routeid, name, description)
		values (1, 1, 'first route (green)', 'my first route');
		
	insert into dairy_route(dairyid, routeid, name, description)
		values (1, 2, 'second route (red)', 'my second route');
				
	insert into dairy_location(dairyid, dairy_locationid, locationid, name)
		values (1, 1, 1, 'branch location #1');
		
	insert into dairy_member(dairyid, memberid, personid, application_date, effective_date, status)
		values (1, 1, 2, '10/12/2003', '11/10/2003', 'ACTI');
	insert into dairy_member(dairyid, memberid, personid, application_date, effective_date, status)
		values (1, 2, 3, '10/12/2003', null, null);
	insert into dairy_member(dairyid, memberid, personid, application_date, effective_date, status)
		values (1, 3, 4, '10/12/2003', null, 'VOID');
	insert into dairy_member(dairyid, memberid, personid, application_date, effective_date, status)
		values (1, 4, 5, '10/12/2003', null, 'VOID');
		
		
	insert into supplier (dairyid, supplierid, supplier_name, status, description, contact_personid )
		values (1, 1, 'keystone supply and feed', 'active', 'keystone is your premier supply house. Count on us for everything.', 3);
		
	-- health requests 
	insert into health_request(dairyid, memberid, requestid, farmid, request_date, request_type, request_description )
	 	values (1, 1, 1, 1, '2008/10/12', 'VET', 'this is a test vet request');
	insert into health_request(dairyid, memberid, requestid, farmid, request_date, request_type, request_description )
	 	values (1, 2, 2, 2, '2008/10/12', 'VET', 'this is a test vet request');
	insert into health_request(dairyid, memberid, requestid, farmid, request_date, request_type, request_description )
	 	values (1, 3, 3, 2, '2008/10/12', 'VET', 'this is a test vet request');
	insert into health_request(dairyid, memberid, requestid, farmid, request_date, request_type, request_description )
	 	values (1, 1, 4, 1, '2008/10/12', 'VET', 'this is a test vet request');
	insert into health_request(dairyid, memberid, requestid, farmid, request_date, request_type, request_description )
	 	values (1, 4, 5, 4, '2008/10/12', 'VET', 'this is a test vet request');
	insert into health_request(dairyid, memberid, requestid, farmid, request_date, request_type, request_description )
	 	values (1, 4, 6, 4, '2008/10/12', 'VET', 'this is a test vet request');

		
		
		