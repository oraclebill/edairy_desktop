
    create table "account" (
        "accountid" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "accountnumber" varchar(60) not null,
        "established" timestamp,
        "status" varchar(255) not null,
        "type" varchar(60),
        primary key ("accountid"),
        unique ("accountnumber")
    );

    create table "animalhealthrequest" (
        "requestid" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "membership_requestingmember_memberid" int8 not null,
        "animalhealthrequest_dairy_companyid" int8,
        "date" timestamp,
        "type" varchar(255),
        "reportedproblem" varchar(60),
        "registeredanimal_reportedanimal_registrationid" int8,
        "dateheatdetected" timestamp,
        "firsttreatment" timestamp,
        "secondtreatment" timestamp,
        "thirdtreatment" timestamp,
        "farm_farm_farmid" int8 not null,
        "supplier_referredto_companyid" int8,
        primary key ("requestid")
    );

    create table "animalidentifier" (
        id int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "issuer" varchar(60),
        "value" varchar(60),
        "registeredanimal_identifiers_registrationid" int8,
        primary key (id)
    );

    create table "balancepoint" (
        "accountbalanceid" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "balancepoint_account_accountid" int8,
        "asof" timestamp,
        "amount" numeric(19, 2),
        primary key ("accountbalanceid")
    );

    create table "collectiongroup" (
        "journalid" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "referencenumber" varchar(60) not null,
        "journaldate" timestamp not null,
        "status" varchar(255) not null,
        "employee_driver_personid" int8 not null,
        "vehicle_vehicle_vehicleid" int8,
        "drivertotal" numeric(19, 2),
        "recordtotal" numeric(19, 2),
        "suspended" bool,
        "entrycount" int4,
        "suspendedcount" int4,
        "rejectedcount" int4,
        "journalnumber" varchar(60),
        "collectionsession_session_e_id" int8,
        "dairylocation_collectioncenter_id" int8,
        "type" varchar(255) not null,
        "dairy_collectionjournals_companyid" int8,
        primary key ("journalid")
    );

    create table "collectionjournalline" (
        id int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "linenumber" int4,
        "recordedmember" varchar(60) not null,
        "quantity" numeric(19, 2) not null,
        "flagged" bool,
        "unitofmeasure" varchar(255) not null,
        "notrecorded" bool,
        "membership_validatedmember_e_id" int8,
        "offroute" bool,
        "farm_from_farmid" int8,
        "container_farmcontainer_containerid" int8,
        "dairycontainer_dairycontainer_containerid" int8,
        "collectionjournalline_collectionjournal_e_id" int8,
        "rejected" bool,
        "rejectionreason" varchar(60),
        "milkfatpercentage" numeric(19, 2),
        "alcoholpercentage" numeric(19, 2),
        "wateradded" bool,
        "scaleserial" varchar(60),
        "collectiontime" timestamp,
        "centernumber" varchar(60),
        "numcans" varchar(60),
        "tripnumber" varchar(60),
        "operatorcode" varchar(60),
        "validated" bool,
        primary key (id)
    );

    create table "collectionsession" (
        "id" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "code" varchar(60) unique,
        "description" varchar(60),
        "timeofday" timestamp,
        primary key ("id")
    );

    create table "contactmethod" (
        id int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "cmtype" varchar(255),
        "cmvalue" varchar(60),
        "person_contactmethods_e_id" int8,
        "dairy_contactmethods_e_id" int8,
        "supplier_contactmethods_e_id" int8,
        "customer_contactmethods_e_id" int8,
        primary key (id)
    );

    create table "container" (
        "containerid" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "trackingnumber" varchar(60) not null,
        "farm_owner_farmid" int8,
        "capacity" float8 not null,
        "measuretype" varchar(255),
        "status" varchar(60),
        "route_zone_id" int8,
        "tagtype" varchar(60),
        "tagvalue" varchar(60),
        "dateacquired" timestamp,
        "damagedate" timestamp,
        "damagedescription" varchar(60),
        "datedisposed" timestamp,
        "disposalreason" varchar(60),
        "disposalwitness" varchar(60),
        "farm_cans_farmid" int8,
        "dairy_dairybins_companyid" int8,
        primary key ("containerid"),
        unique ("trackingnumber")
    );

    create table "customer" (
        "customerid" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "customernumber" varchar(60) not null,
        "legalname" varchar(60),
        "customername" varchar(60) not null,
        "location_location_e_id" int8 not null,
        "phonenumber" varchar(60) not null,
        "description" varchar(60),
        "profilephoto" varchar(60),
        "customertype" varchar(60),
        "status" varchar(60),
        "dairy_customers_companyid" int8,
        primary key ("customerid"),
        unique ("customernumber")
    );

    create table "dairy" (
        "dairyid" int8 not null,
        dtype varchar(255) not null,
        "version" int8 not null,
        "legalname" varchar(60),
        "dairyname" varchar(60) not null,
        "location_location_e_id" int8 not null,
        "phonenumber" varchar(60) not null,
        "description" varchar(60),
        "profilephoto" varchar(60),
        "registrationnumber" varchar(60) not null,
        "establisheddate" timestamp,
        "managername" varchar(60),
        "nssfnumber" varchar(60),
        "nhifnumber" varchar(60),
        "federalpin" varchar(60),
        "licenseeffectivedate" timestamp,
        "licenseexpirationdate" timestamp,
        primary key ("dairyid")
    );

    create table "dairylocation_functions" (
        "dairylocation_functions_id" int8 not null,
        elt varchar(255),
        "dairylocation_functions_idx" int4 not null,
        primary key ("dairylocation_functions_id", "dairylocation_functions_idx")
    );

    create table "dairylocation" (
        "id" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "code" varchar(60),
        "name" varchar(60) not null,
        "dateopened" timestamp,
        "phone" varchar(60),
        "description" varchar(60),
        "location_location_e_id" int8 not null,
        "dairycontainer_containers_containerid" int8,
        "dairy_branchlocations_companyid" int8,
        primary key ("id"),
        unique ("code")
    );

    create table "deliveryjournal" (
        id int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "referencenumber" varchar(60) not null,
        "date" timestamp not null,
        "route_route_id" int8 not null,
        "customer_customer_e_id" int8 not null,
        "employee_driver_personid" int8,
        "vehicle_vehicle_vehicleid" int8,
        "total" numeric(19, 2) not null,
        "collectionsession_session_e_id" int8,
        "dairy_deliveryjournals_companyid" int8,
        primary key (id)
    );

    create table "farm" (
        "farmid" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "name" varchar(60),
        "location_location_e_id" int8,
        "farm_owner_e_id" int8,
        "profilephoto" varchar(60),
        primary key ("farmid")
    );

    create table "imageentry" (
        "imageid" varchar(60) not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "mimetype" varchar(60) not null,
        "imagedata" bytea,
        primary key ("imageid")
    );

    create table "location" (
        "locationid" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "address" varchar(60),
        "section" varchar(60),
        "estate" varchar(60),
        "village" varchar(60),
        "sublocation" varchar(60),
        "location" varchar(60),
        "district" varchar(60),
        "division" varchar(60),
        "province" varchar(60),
        "postalcode" varchar(60),
        "longitude" float8,
        "latitude" float8,
        "landreferencenumber" varchar(60),
        "directions" varchar(60),
        "landmarks" varchar(60),
        primary key ("locationid")
    );

    create table "memberpayment" (
        "id" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "year" int4 not null,
        "month" int4 not null,
        "paymentrate" numeric(19, 2) not null,
        "paymentstotal" numeric(19, 2),
        "paymentscount" int4,
        "employee_enteredby_personid" int8 not null,
        "entrydate" timestamp not null,
        "dairy_pricehistory_companyid" int8,
        primary key ("id")
    );

    create table "membership" (
        "memberid" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "membernumber" varchar(60) not null,
        "applicationdate" timestamp not null,
        "effectivedate" timestamp,
        "status" varchar(255) not null,
        "dairylocation_defaultroute_id" int8,
        "farmer_member_personid" int8 not null,
        account int8 not null unique,
        "membership_dairy_companyid" int8,
        primary key ("memberid"),
        unique ("membernumber")
    );

    create table "milkgrade" (
        id int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "code" varchar(60) not null,
        "name" varchar(60) not null,
        "description" varchar(60),
        primary key (id),
        unique ("code")
    );

    create table "milkgradechange" (
        id int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "date" timestamp not null,
        "milkgrade_startinggrade_e_id" int8 not null,
        "milkgrade_endinggrade_e_id" int8 not null,
        "employee_changedby_personid" int8,
        "reason" varchar(60),
        primary key (id)
    );

    create table "milksale" (
        id int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "linenumber" int4,
        "referencenumber" varchar(60),
        "saledate" timestamp not null,
        "dairycontainer_bin_containerid" int8,
        "saletype" varchar(255) not null,
        "quantity" numeric(19, 2) not null,
        "milkgrade_grade_e_id" int8,
        "unitprice" numeric(19, 2),
        "description" varchar(60),
        "rejected" bool not null,
        "dairylocation_storeorroute_id" int8 not null,
        "customer_customer_e_id" int8,
        "employee_soldby_personid" int8,
        "saleamount" numeric(19, 2) not null,
        "contractsale" bool not null,
        "employee_salesclerk_personid" int8,
        "deliveryjournal_lines_e_id" int8,
        primary key (id)
    );

    create table "permission" (
        "id" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "permissionnamespace_namespace_id" int8,
        "name" varchar(60),
        "displayname" varchar(60),
        primary key ("id")
    );

    create table "permissionnamespace" (
        "id" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "name" varchar(60) unique,
        primary key ("id")
    );

    create table "person" (
        "personid" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "photo" varchar(60),
        "honorific" varchar(60),
        "familyname" varchar(60) not null,
        "givenname" varchar(60) not null,
        "middlename" varchar(60),
        "additionalnames" varchar(60),
        "suffix" varchar(60),
        "nickname" varchar(60),
        "phonenumber" varchar(60),
        location int8,
        "nssfnumber" varchar(60),
        "nhifnumber" varchar(60),
        "nationalid" varchar(60) unique,
        "employeenumber" varchar(60) unique,
        "operatorcode" varchar(60),
        "startdate" timestamp,
        "jobfunction" varchar(60),
        "department" varchar(60),
        "licenseno" varchar(60),
        "dairy_contacts_e_id" int8,
        "dairy_employees_companyid" int8,
        "supplier_contacts_e_id" int8,
        "customer_contacts_e_id" int8,
        primary key ("personid")
    );

    create table "preference" (
        "id" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "preferencekey_key_e_id" int8,
        "value" varchar(60),
        primary key ("id")
    );

    create table "preferencekey" (
        "id" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "name" varchar(60),
        "defaultvalue" varchar(60),
        "type" varchar(255),
        primary key ("id")
    );

    create table "referenceanimaltype" (
        id int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "species" varchar(60),
        "breed" varchar(60),
        primary key (id)
    );

    create table "registeredanimal_pastowners" (
        "registeredanimal_pastowners_registrationid" int8 not null,
        elt varchar(255),
        "registeredanimal_pastowners_idx" int4 not null,
        primary key ("registeredanimal_pastowners_registrationid", "registeredanimal_pastowners_idx")
    );

    create table "registeredanimal" (
        "registrationid" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "givenname" varchar(60) not null,
        "photo" varchar(60),
        "farm_location_farmid" int8 not null,
        "gender" varchar(255) not null,
        "referenceanimaltype_animaltype_e_id" int8,
        "referenceanimaltype_siretype_e_id" int8,
        "purpose" varchar(255) not null,
        "dateofacquisition" timestamp,
        "acquisitiontype" varchar(255),
        "identifyingfeatures" varchar(60),
        "rearingmode" varchar(255) not null,
        "insurancenumber" varchar(60),
        "dateofbirth" timestamp not null,
        "birthcertificatenumber" varchar(60),
        "veterinarycertificatenumber" varchar(60),
        "ministryid" varchar(60),
        "insurancecompany" varchar(60),
        "feedinghabit" varchar(60),
        "feedtype" varchar(60),
        "feedbrand" varchar(60),
        "supplements" varchar(60),
        "antibiotics" varchar(60),
        "veterinary" varchar(60),
        "awards" varchar(60),
        "notes" varchar(60),
        "farm_animals_farmid" int8,
        primary key ("registrationid")
    );

    create table "role_permissions" (
        "role_permissions_id" int8 not null,
        elt varchar(255),
        "role_permissions_idx" int4 not null,
        primary key ("role_permissions_id", "role_permissions_idx")
    );

    create table "role" (
        "id" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "name" varchar(60) unique,
        "description" varchar(60),
        primary key ("id")
    );

    create table "route_stops" (
        "dairylocation_id" int8 not null,
        "route_id" int8,
        primary key ("dairylocation_id")
    );

    create table "route" (
        "id" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "name" varchar(60),
        "description" varchar(60),
        "vehicle_vehicle_vehicleid" int8,
        "dairy_routes_companyid" int8,
        primary key ("id"),
        unique ("name")
    );

    create table "supplier_categories" (
        "supplier_categories_companyid" int8 not null,
        elt varchar(255),
        "supplier_categories_idx" int4 not null,
        primary key ("supplier_categories_companyid", "supplier_categories_idx")
    );

    create table "supplier" (
        "supplierid" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "legalname" varchar(60),
        "suppliername" varchar(60) not null,
        "location_location_e_id" int8 not null,
        "phonenumber" varchar(60) not null,
        "description" varchar(60),
        "profilephoto" varchar(60),
        "id" varchar(60) not null,
        "publicdescription" varchar(60) not null,
        "status" varchar(255) not null,
        "registrationdate" timestamp not null,
        "expirationdate" timestamp,
        "notes" varchar(60),
        "rating" int4,
        "dairy_suppliers_companyid" int8,
        primary key ("supplierid")
    );

    create table "systemuser" (
        id int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "username" varchar(60) unique,
        "password" varchar(64),
        relatedEmployee int8,
        "localenabled" bool,
        "role_role_e_id" int8,
        "passwordhashed" bool not null,
        primary key (id)
    );

    create table "transaction" (
        "transactionid" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "transaction_account_accountid" int8,
        "transactiondate" timestamp not null,
        "transactiontype" varchar(255) not null,
        "amount" numeric(19, 2) not null,
        "description" varchar(60),
        "referencenumber" varchar(60),
        "source" varchar(255),
        "dairylocation_relatedlocation_id" int8,
        "checknumber" varchar(60),
        "signedby" varchar(60),
        "employee_signedoffby_personid" int8,
        primary key ("transactionid")
    );

    create table "trip_collections" (
        "trip_tripid" int8 not null,
        "collectiongroup_journalid" int8 not null
    );

    create table "trip_deliveries" (
        "trip_tripid" int8 not null,
        "deliveryjournal_e_id" int8 not null
    );

    create table "trip" (
        "tripid" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "started" timestamp not null,
        "ended" timestamp not null,
        primary key ("tripid")
    );

    create table "vehicle" (
        "vehicleid" int8 not null,
        dtype varchar(255) not null,
        opver int4 not null,
        "registrationnumber" varchar(60) not null,
        "type" varchar(60) not null,
        "make" varchar(60) not null,
        "model" varchar(60),
        "enginenumber" varchar(60) not null,
        "chassisnumber" varchar(60) not null,
        "logbooknumber" varchar(60) unique,
        "insurancepolicynumber" varchar(60),
        "insuranceexpirationdate" timestamp,
        "dominantcolour" varchar(60),
        "capacityintonnes" float8,
        "year" int4,
        "employee_driver_personid" int8,
        "tagtype" varchar(60),
        "tagvalue" varchar(60),
        "dateacquired" timestamp,
        "damagedate" timestamp,
        "damagedescription" varchar(60),
        "datedisposed" timestamp,
        "disposalreason" varchar(60),
        "disposalwitness" varchar(60),
        "dairy_vehicles_companyid" int8,
        primary key ("vehicleid"),
        unique ("registrationnumber")
    );

    create index accountdtype on "account" (dtype);

    create index animalhealthrequestdtype on "animalhealthrequest" (dtype);

    alter table "animalhealthrequest" 
        add constraint FKE679DC37E86E5701 
        foreign key ("registeredanimal_reportedanimal_registrationid") 
        references "registeredanimal";

    alter table "animalhealthrequest" 
        add constraint FKE679DC372148C6B4 
        foreign key ("membership_requestingmember_memberid") 
        references "membership";

    alter table "animalhealthrequest" 
        add constraint FKE679DC3763342DC7 
        foreign key ("farm_farm_farmid") 
        references "farm";

    alter table "animalhealthrequest" 
        add constraint FKE679DC377F899E97 
        foreign key ("animalhealthrequest_dairy_companyid") 
        references "dairy";

    alter table "animalhealthrequest" 
        add constraint FKE679DC37A90F4AA4 
        foreign key ("supplier_referredto_companyid") 
        references "supplier";

    create index animalidentifierdtype on "animalidentifier" (dtype);

    alter table "animalidentifier" 
        add constraint FKA0A1EFA597FE78A8 
        foreign key ("registeredanimal_identifiers_registrationid") 
        references "registeredanimal";

    create index balancepointdtype on "balancepoint" (dtype);

    alter table "balancepoint" 
        add constraint FK6414D034C948E738 
        foreign key ("balancepoint_account_accountid") 
        references "account";

    create index collectiongroupdtype on "collectiongroup" (dtype);

    alter table "collectiongroup" 
        add constraint FK3FA5BAA1E901D8A4 
        foreign key ("employee_driver_personid") 
        references "person";

    alter table "collectiongroup" 
        add constraint FK3FA5BAA1C0E2B0B8 
        foreign key ("dairylocation_collectioncenter_id") 
        references "dairylocation";

    alter table "collectiongroup" 
        add constraint FK3FA5BAA18E0EB0AD 
        foreign key ("vehicle_vehicle_vehicleid") 
        references "vehicle";

    alter table "collectiongroup" 
        add constraint FK3FA5BAA1527171B2 
        foreign key ("dairy_collectionjournals_companyid") 
        references "dairy";

    alter table "collectiongroup" 
        add constraint FK3FA5BAA166A3DBDD 
        foreign key ("collectionsession_session_e_id") 
        references "collectionsession";

    create index collectionjournallinedtype on "collectionjournalline" (dtype);

    alter table "collectionjournalline" 
        add constraint FK21648E4DBDCBB64B 
        foreign key ("container_farmcontainer_containerid") 
        references "container";

    alter table "collectionjournalline" 
        add constraint FK21648E4DCD250D6E 
        foreign key ("collectionjournalline_collectionjournal_e_id") 
        references "collectiongroup";

    alter table "collectionjournalline" 
        add constraint FK21648E4D40348C8A 
        foreign key ("dairycontainer_dairycontainer_containerid") 
        references "container";

    alter table "collectionjournalline" 
        add constraint FK21648E4DDF4763D3 
        foreign key ("farm_from_farmid") 
        references "farm";

    alter table "collectionjournalline" 
        add constraint FK21648E4DE57433AB 
        foreign key ("membership_validatedmember_e_id") 
        references "membership";

    create index collectionsessiondtype on "collectionsession" (dtype);

    create index contactmethoddtype on "contactmethod" (dtype);

    alter table "contactmethod" 
        add constraint FK50595D014FD5EF4D 
        foreign key ("person_contactmethods_e_id") 
        references "person";

    alter table "contactmethod" 
        add constraint FK50595D0140C891DF 
        foreign key ("customer_contactmethods_e_id") 
        references "customer";

    alter table "contactmethod" 
        add constraint FK50595D01937B42BB 
        foreign key ("supplier_contactmethods_e_id") 
        references "supplier";

    alter table "contactmethod" 
        add constraint FK50595D01EE4DEF09 
        foreign key ("dairy_contactmethods_e_id") 
        references "dairy";

    create index containerdtype on "container" (dtype);

    alter table "container" 
        add constraint FKE7814C81C2BB66BA 
        foreign key ("farm_cans_farmid") 
        references "farm";

    alter table "container" 
        add constraint FKE7814C81E80D409C 
        foreign key ("farm_owner_farmid") 
        references "farm";

    alter table "container" 
        add constraint FKE7814C8153D360C1 
        foreign key ("route_zone_id") 
        references "route";

    alter table "container" 
        add constraint FKE7814C8148CF2FF 
        foreign key ("dairy_dairybins_companyid") 
        references "dairy";

    create index customerdtype on "customer" (dtype);

    alter table "customer" 
        add constraint FK24217FDE258A524A 
        foreign key ("location_location_e_id") 
        references "location";

    alter table "customer" 
        add constraint FK24217FDE12BEA235 
        foreign key ("dairy_customers_companyid") 
        references "dairy";

    create index dairydtype on "dairy" (dtype);

    alter table "dairy" 
        add constraint FK5AEDED3258A524A 
        foreign key ("location_location_e_id") 
        references "location";

    alter table "dairylocation_functions" 
        add constraint FKC48933A4C3737B1E 
        foreign key ("dairylocation_functions_id") 
        references "dairylocation";

    create index dairylocationdtype on "dairylocation" (dtype);

    alter table "dairylocation" 
        add constraint FK75A7FB883F53900E 
        foreign key ("dairycontainer_containers_containerid") 
        references "container";

    alter table "dairylocation" 
        add constraint FK75A7FB88258A524A 
        foreign key ("location_location_e_id") 
        references "location";

    alter table "dairylocation" 
        add constraint FK75A7FB88FD6AA1C 
        foreign key ("dairy_branchlocations_companyid") 
        references "dairy";

    create index deliveryjournaldtype on "deliveryjournal" (dtype);

    alter table "deliveryjournal" 
        add constraint FKCB09F8C3E901D8A4 
        foreign key ("employee_driver_personid") 
        references "person";

    alter table "deliveryjournal" 
        add constraint FKCB09F8C315DAE853 
        foreign key ("customer_customer_e_id") 
        references "customer";

    alter table "deliveryjournal" 
        add constraint FKCB09F8C336E40088 
        foreign key ("dairy_deliveryjournals_companyid") 
        references "dairy";

    alter table "deliveryjournal" 
        add constraint FKCB09F8C366CE7230 
        foreign key ("route_route_id") 
        references "route";

    alter table "deliveryjournal" 
        add constraint FKCB09F8C38E0EB0AD 
        foreign key ("vehicle_vehicle_vehicleid") 
        references "vehicle";

    alter table "deliveryjournal" 
        add constraint FKCB09F8C366A3DBDD 
        foreign key ("collectionsession_session_e_id") 
        references "collectionsession";

    create index farmdtype on "farm" (dtype);

    alter table "farm" 
        add constraint FK2FD836258A524A 
        foreign key ("location_location_e_id") 
        references "location";

    alter table "farm" 
        add constraint FK2FD836BE80D46D 
        foreign key ("farm_owner_e_id") 
        references "person";

    create index imageentrydtype on "imageentry" (dtype);

    create index locationdtype on "location" (dtype);

    create index memberpaymentdtype on "memberpayment" (dtype);

    alter table "memberpayment" 
        add constraint FK12BF662C6B8FE040 
        foreign key ("employee_enteredby_personid") 
        references "person";

    alter table "memberpayment" 
        add constraint FK12BF662C2B7B2FE3 
        foreign key ("dairy_pricehistory_companyid") 
        references "dairy";

    create index membershipdtype on "membership" (dtype);

    alter table "membership" 
        add constraint FKB01D87D6806384E3 
        foreign key ("dairylocation_defaultroute_id") 
        references "dairylocation";

    alter table "membership" 
        add constraint FKB01D87D633F82C36 
        foreign key ("membership_dairy_companyid") 
        references "dairy";

    alter table "membership" 
        add constraint FKB01D87D647A495DC 
        foreign key ("farmer_member_personid") 
        references "person";

    alter table "membership" 
        add constraint FKB01D87D6D6DFAC3A 
        foreign key (account) 
        references "account";

    create index milkgradedtype on "milkgrade" (dtype);

    create index milkgradechangedtype on "milkgradechange" (dtype);

    alter table "milkgradechange" 
        add constraint FKBD33234C1C37CBBC 
        foreign key ("milkgrade_startinggrade_e_id") 
        references "milkgrade";

    alter table "milkgradechange" 
        add constraint FKBD33234CCF7D18A3 
        foreign key ("milkgrade_endinggrade_e_id") 
        references "milkgrade";

    alter table "milkgradechange" 
        add constraint FKBD33234CB4CC82E3 
        foreign key ("employee_changedby_personid") 
        references "person";

    create index milksaledtype on "milksale" (dtype);

    alter table "milksale" 
        add constraint FKABB35EE277DAE9F4 
        foreign key ("deliveryjournal_lines_e_id") 
        references "deliveryjournal";

    alter table "milksale" 
        add constraint FKABB35EE215DAE853 
        foreign key ("customer_customer_e_id") 
        references "customer";

    alter table "milksale" 
        add constraint FKABB35EE2BBE70201 
        foreign key ("dairycontainer_bin_containerid") 
        references "container";

    alter table "milksale" 
        add constraint FKABB35EE26AC94FA3 
        foreign key ("employee_salesclerk_personid") 
        references "person";

    alter table "milksale" 
        add constraint FKABB35EE2B7A32801 
        foreign key ("employee_soldby_personid") 
        references "person";

    alter table "milksale" 
        add constraint FKABB35EE24BAD0E26 
        foreign key ("dairylocation_storeorroute_id") 
        references "dairylocation";

    alter table "milksale" 
        add constraint FKABB35EE2B6B86E7C 
        foreign key ("milkgrade_grade_e_id") 
        references "milkgrade";

    create index permissiondtype on "permission" (dtype);

    alter table "permission" 
        add constraint FKE125C5CF9D12BB9E 
        foreign key ("permissionnamespace_namespace_id") 
        references "permissionnamespace";

    create index permissionnamespacedtype on "permissionnamespace" (dtype);

    create index persondtype on "person" (dtype);

    alter table "person" 
        add constraint FKC4E39B55EFE208FE 
        foreign key ("customer_contacts_e_id") 
        references "customer";

    alter table "person" 
        add constraint FKC4E39B5529FA1E8 
        foreign key ("dairy_contacts_e_id") 
        references "dairy";

    alter table "person" 
        add constraint FKC4E39B55E679A38A 
        foreign key (location) 
        references "location";

    alter table "person" 
        add constraint FKC4E39B55BD57D965 
        foreign key ("dairy_employees_companyid") 
        references "dairy";

    alter table "person" 
        add constraint FKC4E39B55530C045A 
        foreign key ("supplier_contacts_e_id") 
        references "supplier";

    create index preferencedtype on "preference" (dtype);

    alter table "preference" 
        add constraint FKA8FCBCDB4C44DAB4 
        foreign key ("preferencekey_key_e_id") 
        references "preferencekey";

    create index preferencekeydtype on "preferencekey" (dtype);

    create index referenceanimaltypedtype on "referenceanimaltype" (dtype);

    alter table "registeredanimal_pastowners" 
        add constraint FKF90ADA935D16D9FE 
        foreign key ("registeredanimal_pastowners_registrationid") 
        references "registeredanimal";

    create index registeredanimaldtype on "registeredanimal" (dtype);

    alter table "registeredanimal" 
        add constraint FK3FEC42FE76EF5698 
        foreign key ("farm_animals_farmid") 
        references "farm";

    alter table "registeredanimal" 
        add constraint FK3FEC42FEB88635E8 
        foreign key ("farm_location_farmid") 
        references "farm";

    alter table "registeredanimal" 
        add constraint FK3FEC42FE851E6C01 
        foreign key ("referenceanimaltype_animaltype_e_id") 
        references "referenceanimaltype";

    alter table "registeredanimal" 
        add constraint FK3FEC42FE64723214 
        foreign key ("referenceanimaltype_siretype_e_id") 
        references "referenceanimaltype";

    alter table "role_permissions" 
        add constraint FKEAD9D23BDA402635 
        foreign key ("role_permissions_id") 
        references "role";

    create index roledtype on "role" (dtype);

    alter table "route_stops" 
        add constraint FK967B733B7072F8BA 
        foreign key ("dairylocation_id") 
        references "dairylocation";

    alter table "route_stops" 
        add constraint FK967B733B50A70FA 
        foreign key ("route_id") 
        references "route";

    create index routedtype on "route" (dtype);

    alter table "route" 
        add constraint FK67AB2498E0EB0AD 
        foreign key ("vehicle_vehicle_vehicleid") 
        references "vehicle";

    alter table "route" 
        add constraint FK67AB249BB0D2E42 
        foreign key ("dairy_routes_companyid") 
        references "dairy";

    alter table "supplier_categories" 
        add constraint FKD5D3CA6FE20A4274 
        foreign key ("supplier_categories_companyid") 
        references "supplier";

    create index supplierdtype on "supplier" (dtype);

    alter table "supplier" 
        add constraint FK9CDBF9CCE0164787 
        foreign key ("dairy_suppliers_companyid") 
        references "dairy";

    alter table "supplier" 
        add constraint FK9CDBF9CC258A524A 
        foreign key ("location_location_e_id") 
        references "location";

    create index systemuserdtype on "systemuser" (dtype);

    alter table "systemuser" 
        add constraint FK2660AE7AFF4272A7 
        foreign key (relatedEmployee) 
        references "person";

    alter table "systemuser" 
        add constraint FK2660AE7AB828416B 
        foreign key ("role_role_e_id") 
        references "role";

    create index transactiondtype on "transaction" (dtype);

    alter table "transaction" 
        add constraint FK7FA0D2DE81BD5362 
        foreign key ("transaction_account_accountid") 
        references "account";

    alter table "transaction" 
        add constraint FK7FA0D2DE1FA74279 
        foreign key ("dairylocation_relatedlocation_id") 
        references "dairylocation";

    alter table "transaction" 
        add constraint FK7FA0D2DE4D2E0B24 
        foreign key ("employee_signedoffby_personid") 
        references "person";

    alter table "trip_collections" 
        add constraint FK8084E87BF0EC799F 
        foreign key ("trip_tripid") 
        references "trip";

    alter table "trip_collections" 
        add constraint FK8084E87B91C5ECD5 
        foreign key ("collectiongroup_journalid") 
        references "collectiongroup";

    alter table "trip_deliveries" 
        add constraint FKFEC207ECF0EC799F 
        foreign key ("trip_tripid") 
        references "trip";

    alter table "trip_deliveries" 
        add constraint FKFEC207EC297165B4 
        foreign key ("deliveryjournal_e_id") 
        references "deliveryjournal";

    create index tripdtype on "trip" (dtype);

    create index vehicledtype on "vehicle" (dtype);

    alter table "vehicle" 
        add constraint FK14638F2C4B6F2A7F 
        foreign key ("dairy_vehicles_companyid") 
        references "dairy";

    alter table "vehicle" 
        add constraint FK14638F2CE901D8A4 
        foreign key ("employee_driver_personid") 
        references "person";

    create sequence hibernate_sequence;
