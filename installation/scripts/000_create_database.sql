
    create table `account` (
        `accountid` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `accountnumber` varchar(60) not null,
        `established` datetime,
        `status` varchar(255) not null,
        `type` varchar(60),
        primary key (`accountid`),
        unique (`accountnumber`)
    ) type=InnoDB;

    create table `animalhealthrequest` (
        `requestid` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `membership_requestingmember_memberid` bigint not null,
        `animalhealthrequest_dairy_companyid` bigint,
        `date` datetime,
        `type` varchar(255),
        `reportedproblem` varchar(60),
        `registeredanimal_reportedanimal_registrationid` bigint,
        `dateheatdetected` datetime,
        `firsttreatment` datetime,
        `secondtreatment` datetime,
        `thirdtreatment` datetime,
        `farm_farm_farmid` bigint not null,
        `supplier_referredto_companyid` bigint,
        primary key (`requestid`)
    ) type=InnoDB;

    create table `animalidentifier` (
        id bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `issuer` varchar(60),
        `value` varchar(60),
        `registeredanimal_identifiers_registrationid` bigint,
        primary key (id)
    ) type=InnoDB;

    create table `balancepoint` (
        `accountbalanceid` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `balancepoint_account_accountid` bigint,
        `asof` datetime,
        `amount` decimal(19,2),
        primary key (`accountbalanceid`)
    ) type=InnoDB;

    create table `collectiongroup` (
        `journalid` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `referencenumber` varchar(60) not null,
        `journaldate` datetime not null,
        `status` varchar(255) not null,
        `employee_driver_personid` bigint not null,
        `vehicle_vehicle_vehicleid` bigint,
        `drivertotal` decimal(19,2),
        `recordtotal` decimal(19,2),
        `suspended` bit,
        `entrycount` integer,
        `suspendedcount` integer,
        `rejectedcount` integer,
        `journalnumber` varchar(60),
        `collectionsession_session_e_id` bigint,
        `dairylocation_collectioncenter_id` bigint,
        `type` varchar(255) not null,
        `dairy_collectionjournals_companyid` bigint,
        primary key (`journalid`)
    ) type=InnoDB;

    create table `collectionjournalline` (
        id bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `linenumber` integer,
        `recordedmember` varchar(60) not null,
        `quantity` decimal(19,2) not null,
        `flagged` bit,
        `unitofmeasure` varchar(255) not null,
        `notrecorded` bit,
        `membership_validatedmember_e_id` bigint,
        `offroute` bit,
        `farm_from_farmid` bigint,
        `container_farmcontainer_containerid` bigint,
        `dairycontainer_dairycontainer_containerid` bigint,
        `collectionjournalline_collectionjournal_e_id` bigint,
        `rejected` bit,
        `rejectionreason` varchar(60),
        `milkfatpercentage` decimal(19,2),
        `alcoholpercentage` decimal(19,2),
        `wateradded` bit,
        `scaleserial` varchar(60),
        `collectiontime` datetime,
        `centernumber` varchar(60),
        `numcans` varchar(60),
        `tripnumber` varchar(60),
        `operatorcode` varchar(60),
        `validated` bit,
        primary key (id)
    ) type=InnoDB;

    create table `collectionsession` (
        `id` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `code` varchar(60) unique,
        `description` varchar(60),
        `timeofday` datetime,
        primary key (`id`)
    ) type=InnoDB;

    create table `contactmethod` (
        id bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `cmtype` varchar(255),
        `cmvalue` varchar(60),
        `person_contactmethods_e_id` bigint,
        `dairy_contactmethods_e_id` bigint,
        `supplier_contactmethods_e_id` bigint,
        `customer_contactmethods_e_id` bigint,
        primary key (id)
    ) type=InnoDB;

    create table `container` (
        `containerid` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `trackingnumber` varchar(60) not null,
        `farm_owner_farmid` bigint,
        `capacity` double precision not null,
        `measuretype` varchar(255),
        `status` varchar(60),
        `route_zone_id` bigint,
        `tagtype` varchar(60),
        `tagvalue` varchar(60),
        `dateacquired` datetime,
        `damagedate` datetime,
        `damagedescription` varchar(60),
        `datedisposed` datetime,
        `disposalreason` varchar(60),
        `disposalwitness` varchar(60),
        `farm_cans_farmid` bigint,
        `dairy_dairybins_companyid` bigint,
        primary key (`containerid`),
        unique (`trackingnumber`)
    ) type=InnoDB;

    create table `customer` (
        `customerid` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `customernumber` varchar(60) not null,
        `legalname` varchar(60),
        `customername` varchar(60) not null,
        `location_location_e_id` bigint not null,
        `phonenumber` varchar(60) not null,
        `description` varchar(60),
        `profilephoto` varchar(60),
        `customertype` varchar(60),
        `status` varchar(60),
        `dairy_customers_companyid` bigint,
        primary key (`customerid`),
        unique (`customernumber`)
    ) type=InnoDB;

    create table `dairy` (
        `dairyid` bigint not null auto_increment,
        dtype varchar(255) not null,
        `version` bigint not null,
        `legalname` varchar(60),
        `dairyname` varchar(60) not null,
        `location_location_e_id` bigint not null,
        `phonenumber` varchar(60) not null,
        `description` varchar(60),
        `profilephoto` varchar(60),
        `registrationnumber` varchar(60) not null,
        `establisheddate` datetime,
        `managername` varchar(60),
        `nssfnumber` varchar(60),
        `nhifnumber` varchar(60),
        `federalpin` varchar(60),
        `licenseeffectivedate` datetime,
        `licenseexpirationdate` datetime,
        primary key (`dairyid`)
    ) type=InnoDB;

    create table `dairylocation_functions` (
        `dairylocation_functions_id` bigint not null,
        elt varchar(255),
        `dairylocation_functions_idx` integer not null,
        primary key (`dairylocation_functions_id`, `dairylocation_functions_idx`)
    ) type=InnoDB;

    create table `dairylocation` (
        `id` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `code` varchar(60),
        `name` varchar(60) not null,
        `dateopened` datetime,
        `phone` varchar(60),
        `description` varchar(60),
        `location_location_e_id` bigint not null,
        `dairycontainer_containers_containerid` bigint,
        `dairy_branchlocations_companyid` bigint,
        primary key (`id`),
        unique (`code`)
    ) type=InnoDB;

    create table `deliveryjournal` (
        id bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `referencenumber` varchar(60) not null,
        `date` datetime not null,
        `route_route_id` bigint not null,
        `customer_customer_e_id` bigint not null,
        `employee_driver_personid` bigint,
        `vehicle_vehicle_vehicleid` bigint,
        `total` decimal(19,2) not null,
        `collectionsession_session_e_id` bigint,
        `dairy_deliveryjournals_companyid` bigint,
        primary key (id)
    ) type=InnoDB;

    create table `farm` (
        `farmid` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `name` varchar(60),
        `location_location_e_id` bigint,
        `farm_owner_e_id` bigint,
        `profilephoto` varchar(60),
        primary key (`farmid`)
    ) type=InnoDB;

    create table `imageentry` (
        `imageid` varchar(60) not null,
        dtype varchar(255) not null,
        opver integer not null,
        `mimetype` varchar(60) not null,
        `imagedata` mediumblob,
        primary key (`imageid`)
    ) type=InnoDB;

    create table `location` (
        `locationid` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `address` varchar(60),
        `section` varchar(60),
        `estate` varchar(60),
        `village` varchar(60),
        `sublocation` varchar(60),
        `location` varchar(60),
        `district` varchar(60),
        `division` varchar(60),
        `province` varchar(60),
        `postalcode` varchar(60),
        `longitude` double precision,
        `latitude` double precision,
        `landreferencenumber` varchar(60),
        `directions` varchar(60),
        `landmarks` varchar(60),
        primary key (`locationid`)
    ) type=InnoDB;

    create table `memberpayment` (
        `id` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `year` integer not null,
        `month` integer not null,
        `paymentrate` decimal(19,2) not null,
        `paymentstotal` decimal(19,2),
        `paymentscount` integer,
        `employee_enteredby_personid` bigint not null,
        `entrydate` datetime not null,
        `dairy_pricehistory_companyid` bigint,
        primary key (`id`)
    ) type=InnoDB;

    create table `membership` (
        `memberid` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `membernumber` varchar(60) not null,
        `applicationdate` datetime not null,
        `effectivedate` datetime,
        `status` varchar(255) not null,
        `dairylocation_defaultroute_id` bigint,
        `farmer_member_personid` bigint not null,
        account bigint not null unique,
        `membership_dairy_companyid` bigint,
        `maziwacardnumber` varchar(60),
        `maziwacardissuedate` datetime,
        primary key (`memberid`),
        unique (`membernumber`)
    ) type=InnoDB;

    create table `milkgrade` (
        id bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `code` varchar(60) not null,
        `name` varchar(60) not null,
        `description` varchar(60),
        primary key (id),
        unique (`code`)
    ) type=InnoDB;

    create table `milkgradechange` (
        id bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `date` datetime not null,
        `milkgrade_startinggrade_e_id` bigint not null,
        `milkgrade_endinggrade_e_id` bigint not null,
        `employee_changedby_personid` bigint,
        `reason` varchar(60),
        primary key (id)
    ) type=InnoDB;

    create table `milksale` (
        `id` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `linenumber` integer,
        `referencenumber` varchar(60),
        `saledate` datetime not null,
        `dairycontainer_bin_containerid` bigint,
        `saletype` varchar(255) not null,
        `quantity` decimal(19,2) not null,
        `milkgrade_grade_e_id` bigint not null,
        `unitprice` decimal(19,2) not null,
        `description` varchar(60),
        `rejected` bit not null,
        `dairylocation_storeorroute_id` bigint not null,
        `customer_customer_e_id` bigint,
        `employee_soldby_personid` bigint,
        `saleamount` decimal(19,2) not null,
        `contractsale` bit not null,
        `employee_salesclerk_personid` bigint,
        `deliveryjournal_lines_e_id` bigint,
        primary key (`id`)
    ) type=InnoDB;

    create table `permission` (
        `id` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `permissionnamespace_namespace_id` bigint,
        `name` varchar(60),
        `displayname` varchar(60),
        primary key (`id`)
    ) type=InnoDB;

    create table `permissionnamespace` (
        `id` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `name` varchar(60) unique,
        primary key (`id`)
    ) type=InnoDB;

    create table `person` (
        `personid` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `photo` varchar(60),
        `honorific` varchar(60),
        `familyname` varchar(60) not null,
        `givenname` varchar(60) not null,
        `middlename` varchar(60),
        `additionalnames` varchar(60),
        `suffix` varchar(60),
        `nickname` varchar(60),
        `phonenumber` varchar(60),
        location bigint,
        `nssfnumber` varchar(60),
        `nhifnumber` varchar(60),
        `nationalid` varchar(60) unique,
        `employeenumber` varchar(60) unique,
        `operatorcode` varchar(60),
        `startdate` datetime,
        `jobfunction` varchar(60),
        `department` varchar(60),
        `licenseno` varchar(60),
        `dairy_contacts_e_id` bigint,
        `dairy_employees_companyid` bigint,
        `supplier_contacts_e_id` bigint,
        `customer_contacts_e_id` bigint,
        primary key (`personid`)
    ) type=InnoDB;

    create table `preference` (
        `id` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `preferencekey_key_e_id` bigint,
        `value` varchar(60),
        primary key (`id`)
    ) type=InnoDB;

    create table `preferencekey` (
        `id` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `name` varchar(60),
        `defaultvalue` varchar(60),
        `type` varchar(255),
        primary key (`id`)
    ) type=InnoDB;

    create table `referenceanimaltype` (
        id bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `species` varchar(60),
        `breed` varchar(60),
        primary key (id)
    ) type=InnoDB;

    create table `registeredanimal_pastowners` (
        `registeredanimal_pastowners_registrationid` bigint not null,
        elt varchar(255),
        `registeredanimal_pastowners_idx` integer not null,
        primary key (`registeredanimal_pastowners_registrationid`, `registeredanimal_pastowners_idx`)
    ) type=InnoDB;

    create table `registeredanimal` (
        `registrationid` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `givenname` varchar(60) not null,
        `photo` varchar(60),
        `farm_location_farmid` bigint not null,
        `gender` varchar(255) not null,
        `referenceanimaltype_animaltype_e_id` bigint,
        `referenceanimaltype_siretype_e_id` bigint,
        `purpose` varchar(255) not null,
        `dateofacquisition` datetime,
        `acquisitiontype` varchar(255),
        `identifyingfeatures` varchar(60),
        `rearingmode` varchar(255) not null,
        `insurancenumber` varchar(60),
        `dateofbirth` datetime not null,
        `birthcertificatenumber` varchar(60),
        `veterinarycertificatenumber` varchar(60),
        `ministryid` varchar(60),
        `insurancecompany` varchar(60),
        `feedinghabit` varchar(60),
        `feedtype` varchar(60),
        `feedbrand` varchar(60),
        `supplements` varchar(60),
        `antibiotics` varchar(60),
        `veterinary` varchar(60),
        `awards` varchar(60),
        `notes` varchar(60),
        `farm_animals_farmid` bigint,
        primary key (`registrationid`)
    ) type=InnoDB;

    create table `role_permissions` (
        `role_permissions_id` bigint not null,
        elt varchar(255),
        `role_permissions_idx` integer not null,
        primary key (`role_permissions_id`, `role_permissions_idx`)
    ) type=InnoDB;

    create table `role` (
        `id` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `name` varchar(60) unique,
        `description` varchar(60),
        primary key (`id`)
    ) type=InnoDB;

    create table `route_stops` (
        `dairylocation_id` bigint not null,
        `route_id` bigint,
        primary key (`dairylocation_id`)
    ) type=InnoDB;

    create table `route` (
        `id` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `name` varchar(60),
        `description` varchar(60),
        `vehicle_vehicle_vehicleid` bigint,
        `dairy_routes_companyid` bigint,
        primary key (`id`),
        unique (`name`)
    ) type=InnoDB;

    create table `supplier_categories` (
        `supplier_categories_companyid` bigint not null,
        elt varchar(255),
        `supplier_categories_idx` integer not null,
        primary key (`supplier_categories_companyid`, `supplier_categories_idx`)
    ) type=InnoDB;

    create table `supplier` (
        `supplierid` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `legalname` varchar(60),
        `suppliername` varchar(60) not null,
        `location_location_e_id` bigint not null,
        `phonenumber` varchar(60) not null,
        `description` varchar(60),
        `profilephoto` varchar(60),
        `id` varchar(60) not null,
        `publicdescription` varchar(60) not null,
        `status` varchar(255) not null,
        `registrationdate` datetime not null,
        `expirationdate` datetime,
        `notes` varchar(60),
        `rating` integer,
        `dairy_suppliers_companyid` bigint,
        primary key (`supplierid`)
    ) type=InnoDB;

    create table `systemuser` (
        id bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `username` varchar(60) unique,
        `password` varchar(64),
        relatedEmployee bigint,
        `localenabled` bit,
        `role_role_e_id` bigint,
        `passwordhashed` bit not null,
        primary key (id)
    ) type=InnoDB;

    create table `transaction` (
        `transactionid` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `transaction_account_accountid` bigint,
        `transactiondate` datetime not null,
        `transactiontype` varchar(255) not null,
        `amount` decimal(19,2) not null,
        `description` varchar(60),
        `referencenumber` varchar(60),
        `source` varchar(255),
        `dairylocation_relatedlocation_id` bigint,
        `checknumber` varchar(60),
        `signedby` varchar(60),
        `employee_signedoffby_personid` bigint,
        primary key (`transactionid`)
    ) type=InnoDB;

    create table `trip_collections` (
        `trip_tripid` bigint not null,
        `collectiongroup_journalid` bigint not null
    ) type=InnoDB;

    create table `trip_deliveries` (
        `trip_tripid` bigint not null,
        `deliveryjournal_e_id` bigint not null
    ) type=InnoDB;

    create table `trip` (
        `tripid` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `started` datetime not null,
        `ended` datetime not null,
        primary key (`tripid`)
    ) type=InnoDB;

    create table `vehicle` (
        `vehicleid` bigint not null auto_increment,
        dtype varchar(255) not null,
        opver integer not null,
        `registrationnumber` varchar(60) not null,
        `type` varchar(60) not null,
        `make` varchar(60) not null,
        `model` varchar(60),
        `enginenumber` varchar(60) not null,
        `chassisnumber` varchar(60) not null,
        `logbooknumber` varchar(60) unique,
        `insurancepolicynumber` varchar(60),
        `insuranceexpirationdate` datetime,
        `dominantcolour` varchar(60),
        `capacityintonnes` double precision,
        `year` integer,
        `employee_driver_personid` bigint,
        `tagtype` varchar(60),
        `tagvalue` varchar(60),
        `dateacquired` datetime,
        `damagedate` datetime,
        `damagedescription` varchar(60),
        `datedisposed` datetime,
        `disposalreason` varchar(60),
        `disposalwitness` varchar(60),
        `dairy_vehicles_companyid` bigint,
        primary key (`vehicleid`),
        unique (`registrationnumber`)
    ) type=InnoDB;

    create index accountdtype on `account` (dtype);

    create index animalhealthrequestdtype on `animalhealthrequest` (dtype);

    alter table `animalhealthrequest` 
        add index FKE679DC37E86E5701 (`registeredanimal_reportedanimal_registrationid`), 
        add constraint FKE679DC37E86E5701 
        foreign key (`registeredanimal_reportedanimal_registrationid`) 
        references `registeredanimal` (`registrationid`);

    alter table `animalhealthrequest` 
        add index FKE679DC372148C6B4 (`membership_requestingmember_memberid`), 
        add constraint FKE679DC372148C6B4 
        foreign key (`membership_requestingmember_memberid`) 
        references `membership` (`memberid`);

    alter table `animalhealthrequest` 
        add index FKE679DC3763342DC7 (`farm_farm_farmid`), 
        add constraint FKE679DC3763342DC7 
        foreign key (`farm_farm_farmid`) 
        references `farm` (`farmid`);

    alter table `animalhealthrequest` 
        add index FKE679DC377F899E97 (`animalhealthrequest_dairy_companyid`), 
        add constraint FKE679DC377F899E97 
        foreign key (`animalhealthrequest_dairy_companyid`) 
        references `dairy` (`dairyid`);

    alter table `animalhealthrequest` 
        add index FKE679DC37A90F4AA4 (`supplier_referredto_companyid`), 
        add constraint FKE679DC37A90F4AA4 
        foreign key (`supplier_referredto_companyid`) 
        references `supplier` (`supplierid`);

    create index animalidentifierdtype on `animalidentifier` (dtype);

    alter table `animalidentifier` 
        add index FKA0A1EFA597FE78A8 (`registeredanimal_identifiers_registrationid`), 
        add constraint FKA0A1EFA597FE78A8 
        foreign key (`registeredanimal_identifiers_registrationid`) 
        references `registeredanimal` (`registrationid`);

    create index balancepointdtype on `balancepoint` (dtype);

    alter table `balancepoint` 
        add index FK6414D034C948E738 (`balancepoint_account_accountid`), 
        add constraint FK6414D034C948E738 
        foreign key (`balancepoint_account_accountid`) 
        references `account` (`accountid`);

    create index collectiongroupdtype on `collectiongroup` (dtype);

    alter table `collectiongroup` 
        add index FK3FA5BAA1E901D8A4 (`employee_driver_personid`), 
        add constraint FK3FA5BAA1E901D8A4 
        foreign key (`employee_driver_personid`) 
        references `person` (`personid`);

    alter table `collectiongroup` 
        add index FK3FA5BAA1C0E2B0B8 (`dairylocation_collectioncenter_id`), 
        add constraint FK3FA5BAA1C0E2B0B8 
        foreign key (`dairylocation_collectioncenter_id`) 
        references `dairylocation` (`id`);

    alter table `collectiongroup` 
        add index FK3FA5BAA18E0EB0AD (`vehicle_vehicle_vehicleid`), 
        add constraint FK3FA5BAA18E0EB0AD 
        foreign key (`vehicle_vehicle_vehicleid`) 
        references `vehicle` (`vehicleid`);

    alter table `collectiongroup` 
        add index FK3FA5BAA1527171B2 (`dairy_collectionjournals_companyid`), 
        add constraint FK3FA5BAA1527171B2 
        foreign key (`dairy_collectionjournals_companyid`) 
        references `dairy` (`dairyid`);

    alter table `collectiongroup` 
        add index FK3FA5BAA166A3DBDD (`collectionsession_session_e_id`), 
        add constraint FK3FA5BAA166A3DBDD 
        foreign key (`collectionsession_session_e_id`) 
        references `collectionsession` (`id`);

    create index collectionjournallinedtype on `collectionjournalline` (dtype);

    alter table `collectionjournalline` 
        add index FK21648E4DBDCBB64B (`container_farmcontainer_containerid`), 
        add constraint FK21648E4DBDCBB64B 
        foreign key (`container_farmcontainer_containerid`) 
        references `container` (`containerid`);

    alter table `collectionjournalline` 
        add index FK21648E4DCD250D6E (`collectionjournalline_collectionjournal_e_id`), 
        add constraint FK21648E4DCD250D6E 
        foreign key (`collectionjournalline_collectionjournal_e_id`) 
        references `collectiongroup` (`journalid`);

    alter table `collectionjournalline` 
        add index FK21648E4D40348C8A (`dairycontainer_dairycontainer_containerid`), 
        add constraint FK21648E4D40348C8A 
        foreign key (`dairycontainer_dairycontainer_containerid`) 
        references `container` (`containerid`);

    alter table `collectionjournalline` 
        add index FK21648E4DDF4763D3 (`farm_from_farmid`), 
        add constraint FK21648E4DDF4763D3 
        foreign key (`farm_from_farmid`) 
        references `farm` (`farmid`);

    alter table `collectionjournalline` 
        add index FK21648E4DE57433AB (`membership_validatedmember_e_id`), 
        add constraint FK21648E4DE57433AB 
        foreign key (`membership_validatedmember_e_id`) 
        references `membership` (`memberid`);

    create index collectionsessiondtype on `collectionsession` (dtype);

    create index contactmethoddtype on `contactmethod` (dtype);

    alter table `contactmethod` 
        add index FK50595D014FD5EF4D (`person_contactmethods_e_id`), 
        add constraint FK50595D014FD5EF4D 
        foreign key (`person_contactmethods_e_id`) 
        references `person` (`personid`);

    alter table `contactmethod` 
        add index FK50595D0140C891DF (`customer_contactmethods_e_id`), 
        add constraint FK50595D0140C891DF 
        foreign key (`customer_contactmethods_e_id`) 
        references `customer` (`customerid`);

    alter table `contactmethod` 
        add index FK50595D01937B42BB (`supplier_contactmethods_e_id`), 
        add constraint FK50595D01937B42BB 
        foreign key (`supplier_contactmethods_e_id`) 
        references `supplier` (`supplierid`);

    alter table `contactmethod` 
        add index FK50595D01EE4DEF09 (`dairy_contactmethods_e_id`), 
        add constraint FK50595D01EE4DEF09 
        foreign key (`dairy_contactmethods_e_id`) 
        references `dairy` (`dairyid`);

    create index containerdtype on `container` (dtype);

    alter table `container` 
        add index FKE7814C81C2BB66BA (`farm_cans_farmid`), 
        add constraint FKE7814C81C2BB66BA 
        foreign key (`farm_cans_farmid`) 
        references `farm` (`farmid`);

    alter table `container` 
        add index FKE7814C81E80D409C (`farm_owner_farmid`), 
        add constraint FKE7814C81E80D409C 
        foreign key (`farm_owner_farmid`) 
        references `farm` (`farmid`);

    alter table `container` 
        add index FKE7814C8153D360C1 (`route_zone_id`), 
        add constraint FKE7814C8153D360C1 
        foreign key (`route_zone_id`) 
        references `route` (`id`);

    alter table `container` 
        add index FKE7814C8148CF2FF (`dairy_dairybins_companyid`), 
        add constraint FKE7814C8148CF2FF 
        foreign key (`dairy_dairybins_companyid`) 
        references `dairy` (`dairyid`);

    create index customerdtype on `customer` (dtype);

    alter table `customer` 
        add index FK24217FDE258A524A (`location_location_e_id`), 
        add constraint FK24217FDE258A524A 
        foreign key (`location_location_e_id`) 
        references `location` (`locationid`);

    alter table `customer` 
        add index FK24217FDE12BEA235 (`dairy_customers_companyid`), 
        add constraint FK24217FDE12BEA235 
        foreign key (`dairy_customers_companyid`) 
        references `dairy` (`dairyid`);

    create index dairydtype on `dairy` (dtype);

    alter table `dairy` 
        add index FK5AEDED3258A524A (`location_location_e_id`), 
        add constraint FK5AEDED3258A524A 
        foreign key (`location_location_e_id`) 
        references `location` (`locationid`);

    alter table `dairylocation_functions` 
        add index FKC48933A4C3737B1E (`dairylocation_functions_id`), 
        add constraint FKC48933A4C3737B1E 
        foreign key (`dairylocation_functions_id`) 
        references `dairylocation` (`id`);

    create index dairylocationdtype on `dairylocation` (dtype);

    alter table `dairylocation` 
        add index FK75A7FB883F53900E (`dairycontainer_containers_containerid`), 
        add constraint FK75A7FB883F53900E 
        foreign key (`dairycontainer_containers_containerid`) 
        references `container` (`containerid`);

    alter table `dairylocation` 
        add index FK75A7FB88258A524A (`location_location_e_id`), 
        add constraint FK75A7FB88258A524A 
        foreign key (`location_location_e_id`) 
        references `location` (`locationid`);

    alter table `dairylocation` 
        add index FK75A7FB88FD6AA1C (`dairy_branchlocations_companyid`), 
        add constraint FK75A7FB88FD6AA1C 
        foreign key (`dairy_branchlocations_companyid`) 
        references `dairy` (`dairyid`);

    create index deliveryjournaldtype on `deliveryjournal` (dtype);

    alter table `deliveryjournal` 
        add index FKCB09F8C3E901D8A4 (`employee_driver_personid`), 
        add constraint FKCB09F8C3E901D8A4 
        foreign key (`employee_driver_personid`) 
        references `person` (`personid`);

    alter table `deliveryjournal` 
        add index FKCB09F8C315DAE853 (`customer_customer_e_id`), 
        add constraint FKCB09F8C315DAE853 
        foreign key (`customer_customer_e_id`) 
        references `customer` (`customerid`);

    alter table `deliveryjournal` 
        add index FKCB09F8C336E40088 (`dairy_deliveryjournals_companyid`), 
        add constraint FKCB09F8C336E40088 
        foreign key (`dairy_deliveryjournals_companyid`) 
        references `dairy` (`dairyid`);

    alter table `deliveryjournal` 
        add index FKCB09F8C366CE7230 (`route_route_id`), 
        add constraint FKCB09F8C366CE7230 
        foreign key (`route_route_id`) 
        references `route` (`id`);

    alter table `deliveryjournal` 
        add index FKCB09F8C38E0EB0AD (`vehicle_vehicle_vehicleid`), 
        add constraint FKCB09F8C38E0EB0AD 
        foreign key (`vehicle_vehicle_vehicleid`) 
        references `vehicle` (`vehicleid`);

    alter table `deliveryjournal` 
        add index FKCB09F8C366A3DBDD (`collectionsession_session_e_id`), 
        add constraint FKCB09F8C366A3DBDD 
        foreign key (`collectionsession_session_e_id`) 
        references `collectionsession` (`id`);

    create index farmdtype on `farm` (dtype);

    alter table `farm` 
        add index FK2FD836258A524A (`location_location_e_id`), 
        add constraint FK2FD836258A524A 
        foreign key (`location_location_e_id`) 
        references `location` (`locationid`);

    alter table `farm` 
        add index FK2FD836BE80D46D (`farm_owner_e_id`), 
        add constraint FK2FD836BE80D46D 
        foreign key (`farm_owner_e_id`) 
        references `person` (`personid`);

    create index imageentrydtype on `imageentry` (dtype);

    create index locationdtype on `location` (dtype);

    create index memberpaymentdtype on `memberpayment` (dtype);

    alter table `memberpayment` 
        add index FK12BF662C6B8FE040 (`employee_enteredby_personid`), 
        add constraint FK12BF662C6B8FE040 
        foreign key (`employee_enteredby_personid`) 
        references `person` (`personid`);

    alter table `memberpayment` 
        add index FK12BF662C2B7B2FE3 (`dairy_pricehistory_companyid`), 
        add constraint FK12BF662C2B7B2FE3 
        foreign key (`dairy_pricehistory_companyid`) 
        references `dairy` (`dairyid`);

    create index membershipdtype on `membership` (dtype);

    alter table `membership` 
        add index FKB01D87D6806384E3 (`dairylocation_defaultroute_id`), 
        add constraint FKB01D87D6806384E3 
        foreign key (`dairylocation_defaultroute_id`) 
        references `dairylocation` (`id`);

    alter table `membership` 
        add index FKB01D87D633F82C36 (`membership_dairy_companyid`), 
        add constraint FKB01D87D633F82C36 
        foreign key (`membership_dairy_companyid`) 
        references `dairy` (`dairyid`);

    alter table `membership` 
        add index FKB01D87D647A495DC (`farmer_member_personid`), 
        add constraint FKB01D87D647A495DC 
        foreign key (`farmer_member_personid`) 
        references `person` (`personid`);

    alter table `membership` 
        add index FKB01D87D6D6DFAC3A (account), 
        add constraint FKB01D87D6D6DFAC3A 
        foreign key (account) 
        references `account` (`accountid`);

    create index milkgradedtype on `milkgrade` (dtype);

    create index milkgradechangedtype on `milkgradechange` (dtype);

    alter table `milkgradechange` 
        add index FKBD33234C1C37CBBC (`milkgrade_startinggrade_e_id`), 
        add constraint FKBD33234C1C37CBBC 
        foreign key (`milkgrade_startinggrade_e_id`) 
        references `milkgrade` (id);

    alter table `milkgradechange` 
        add index FKBD33234CCF7D18A3 (`milkgrade_endinggrade_e_id`), 
        add constraint FKBD33234CCF7D18A3 
        foreign key (`milkgrade_endinggrade_e_id`) 
        references `milkgrade` (id);

    alter table `milkgradechange` 
        add index FKBD33234CB4CC82E3 (`employee_changedby_personid`), 
        add constraint FKBD33234CB4CC82E3 
        foreign key (`employee_changedby_personid`) 
        references `person` (`personid`);

    create index milksaledtype on `milksale` (dtype);

    alter table `milksale` 
        add index FKABB35EE277DAE9F4 (`deliveryjournal_lines_e_id`), 
        add constraint FKABB35EE277DAE9F4 
        foreign key (`deliveryjournal_lines_e_id`) 
        references `deliveryjournal` (id);

    alter table `milksale` 
        add index FKABB35EE215DAE853 (`customer_customer_e_id`), 
        add constraint FKABB35EE215DAE853 
        foreign key (`customer_customer_e_id`) 
        references `customer` (`customerid`);

    alter table `milksale` 
        add index FKABB35EE2BBE70201 (`dairycontainer_bin_containerid`), 
        add constraint FKABB35EE2BBE70201 
        foreign key (`dairycontainer_bin_containerid`) 
        references `container` (`containerid`);

    alter table `milksale` 
        add index FKABB35EE26AC94FA3 (`employee_salesclerk_personid`), 
        add constraint FKABB35EE26AC94FA3 
        foreign key (`employee_salesclerk_personid`) 
        references `person` (`personid`);

    alter table `milksale` 
        add index FKABB35EE2B7A32801 (`employee_soldby_personid`), 
        add constraint FKABB35EE2B7A32801 
        foreign key (`employee_soldby_personid`) 
        references `person` (`personid`);

    alter table `milksale` 
        add index FKABB35EE24BAD0E26 (`dairylocation_storeorroute_id`), 
        add constraint FKABB35EE24BAD0E26 
        foreign key (`dairylocation_storeorroute_id`) 
        references `dairylocation` (`id`);

    alter table `milksale` 
        add index FKABB35EE2B6B86E7C (`milkgrade_grade_e_id`), 
        add constraint FKABB35EE2B6B86E7C 
        foreign key (`milkgrade_grade_e_id`) 
        references `milkgrade` (id);

    create index permissiondtype on `permission` (dtype);

    alter table `permission` 
        add index FKE125C5CF9D12BB9E (`permissionnamespace_namespace_id`), 
        add constraint FKE125C5CF9D12BB9E 
        foreign key (`permissionnamespace_namespace_id`) 
        references `permissionnamespace` (`id`);

    create index permissionnamespacedtype on `permissionnamespace` (dtype);

    create index persondtype on `person` (dtype);

    alter table `person` 
        add index FKC4E39B55EFE208FE (`customer_contacts_e_id`), 
        add constraint FKC4E39B55EFE208FE 
        foreign key (`customer_contacts_e_id`) 
        references `customer` (`customerid`);

    alter table `person` 
        add index FKC4E39B5529FA1E8 (`dairy_contacts_e_id`), 
        add constraint FKC4E39B5529FA1E8 
        foreign key (`dairy_contacts_e_id`) 
        references `dairy` (`dairyid`);

    alter table `person` 
        add index FKC4E39B55E679A38A (location), 
        add constraint FKC4E39B55E679A38A 
        foreign key (location) 
        references `location` (`locationid`);

    alter table `person` 
        add index FKC4E39B55BD57D965 (`dairy_employees_companyid`), 
        add constraint FKC4E39B55BD57D965 
        foreign key (`dairy_employees_companyid`) 
        references `dairy` (`dairyid`);

    alter table `person` 
        add index FKC4E39B55530C045A (`supplier_contacts_e_id`), 
        add constraint FKC4E39B55530C045A 
        foreign key (`supplier_contacts_e_id`) 
        references `supplier` (`supplierid`);

    create index preferencedtype on `preference` (dtype);

    alter table `preference` 
        add index FKA8FCBCDB4C44DAB4 (`preferencekey_key_e_id`), 
        add constraint FKA8FCBCDB4C44DAB4 
        foreign key (`preferencekey_key_e_id`) 
        references `preferencekey` (`id`);

    create index preferencekeydtype on `preferencekey` (dtype);

    create index referenceanimaltypedtype on `referenceanimaltype` (dtype);

    alter table `registeredanimal_pastowners` 
        add index FKF90ADA935D16D9FE (`registeredanimal_pastowners_registrationid`), 
        add constraint FKF90ADA935D16D9FE 
        foreign key (`registeredanimal_pastowners_registrationid`) 
        references `registeredanimal` (`registrationid`);

    create index registeredanimaldtype on `registeredanimal` (dtype);

    alter table `registeredanimal` 
        add index FK3FEC42FE76EF5698 (`farm_animals_farmid`), 
        add constraint FK3FEC42FE76EF5698 
        foreign key (`farm_animals_farmid`) 
        references `farm` (`farmid`);

    alter table `registeredanimal` 
        add index FK3FEC42FEB88635E8 (`farm_location_farmid`), 
        add constraint FK3FEC42FEB88635E8 
        foreign key (`farm_location_farmid`) 
        references `farm` (`farmid`);

    alter table `registeredanimal` 
        add index FK3FEC42FE851E6C01 (`referenceanimaltype_animaltype_e_id`), 
        add constraint FK3FEC42FE851E6C01 
        foreign key (`referenceanimaltype_animaltype_e_id`) 
        references `referenceanimaltype` (id);

    alter table `registeredanimal` 
        add index FK3FEC42FE64723214 (`referenceanimaltype_siretype_e_id`), 
        add constraint FK3FEC42FE64723214 
        foreign key (`referenceanimaltype_siretype_e_id`) 
        references `referenceanimaltype` (id);

    alter table `role_permissions` 
        add index FKEAD9D23BDA402635 (`role_permissions_id`), 
        add constraint FKEAD9D23BDA402635 
        foreign key (`role_permissions_id`) 
        references `role` (`id`);

    create index roledtype on `role` (dtype);

    alter table `route_stops` 
        add index FK967B733B7072F8BA (`dairylocation_id`), 
        add constraint FK967B733B7072F8BA 
        foreign key (`dairylocation_id`) 
        references `dairylocation` (`id`);

    alter table `route_stops` 
        add index FK967B733B50A70FA (`route_id`), 
        add constraint FK967B733B50A70FA 
        foreign key (`route_id`) 
        references `route` (`id`);

    create index routedtype on `route` (dtype);

    alter table `route` 
        add index FK67AB2498E0EB0AD (`vehicle_vehicle_vehicleid`), 
        add constraint FK67AB2498E0EB0AD 
        foreign key (`vehicle_vehicle_vehicleid`) 
        references `vehicle` (`vehicleid`);

    alter table `route` 
        add index FK67AB249BB0D2E42 (`dairy_routes_companyid`), 
        add constraint FK67AB249BB0D2E42 
        foreign key (`dairy_routes_companyid`) 
        references `dairy` (`dairyid`);

    alter table `supplier_categories` 
        add index FKD5D3CA6FE20A4274 (`supplier_categories_companyid`), 
        add constraint FKD5D3CA6FE20A4274 
        foreign key (`supplier_categories_companyid`) 
        references `supplier` (`supplierid`);

    create index supplierdtype on `supplier` (dtype);

    alter table `supplier` 
        add index FK9CDBF9CCE0164787 (`dairy_suppliers_companyid`), 
        add constraint FK9CDBF9CCE0164787 
        foreign key (`dairy_suppliers_companyid`) 
        references `dairy` (`dairyid`);

    alter table `supplier` 
        add index FK9CDBF9CC258A524A (`location_location_e_id`), 
        add constraint FK9CDBF9CC258A524A 
        foreign key (`location_location_e_id`) 
        references `location` (`locationid`);

    create index systemuserdtype on `systemuser` (dtype);

    alter table `systemuser` 
        add index FK2660AE7AFF4272A7 (relatedEmployee), 
        add constraint FK2660AE7AFF4272A7 
        foreign key (relatedEmployee) 
        references `person` (`personid`);

    alter table `systemuser` 
        add index FK2660AE7AB828416B (`role_role_e_id`), 
        add constraint FK2660AE7AB828416B 
        foreign key (`role_role_e_id`) 
        references `role` (`id`);

    create index transactiondtype on `transaction` (dtype);

    alter table `transaction` 
        add index FK7FA0D2DE81BD5362 (`transaction_account_accountid`), 
        add constraint FK7FA0D2DE81BD5362 
        foreign key (`transaction_account_accountid`) 
        references `account` (`accountid`);

    alter table `transaction` 
        add index FK7FA0D2DE1FA74279 (`dairylocation_relatedlocation_id`), 
        add constraint FK7FA0D2DE1FA74279 
        foreign key (`dairylocation_relatedlocation_id`) 
        references `dairylocation` (`id`);

    alter table `transaction` 
        add index FK7FA0D2DE4D2E0B24 (`employee_signedoffby_personid`), 
        add constraint FK7FA0D2DE4D2E0B24 
        foreign key (`employee_signedoffby_personid`) 
        references `person` (`personid`);

    alter table `trip_collections` 
        add index FK8084E87BF0EC799F (`trip_tripid`), 
        add constraint FK8084E87BF0EC799F 
        foreign key (`trip_tripid`) 
        references `trip` (`tripid`);

    alter table `trip_collections` 
        add index FK8084E87B91C5ECD5 (`collectiongroup_journalid`), 
        add constraint FK8084E87B91C5ECD5 
        foreign key (`collectiongroup_journalid`) 
        references `collectiongroup` (`journalid`);

    alter table `trip_deliveries` 
        add index FKFEC207ECF0EC799F (`trip_tripid`), 
        add constraint FKFEC207ECF0EC799F 
        foreign key (`trip_tripid`) 
        references `trip` (`tripid`);

    alter table `trip_deliveries` 
        add index FKFEC207EC297165B4 (`deliveryjournal_e_id`), 
        add constraint FKFEC207EC297165B4 
        foreign key (`deliveryjournal_e_id`) 
        references `deliveryjournal` (id);

    create index tripdtype on `trip` (dtype);

    create index vehicledtype on `vehicle` (dtype);

    alter table `vehicle` 
        add index FK14638F2C4B6F2A7F (`dairy_vehicles_companyid`), 
        add constraint FK14638F2C4B6F2A7F 
        foreign key (`dairy_vehicles_companyid`) 
        references `dairy` (`dairyid`);

    alter table `vehicle` 
        add index FK14638F2CE901D8A4 (`employee_driver_personid`), 
        add constraint FK14638F2CE901D8A4 
        foreign key (`employee_driver_personid`) 
        references `person` (`personid`);
