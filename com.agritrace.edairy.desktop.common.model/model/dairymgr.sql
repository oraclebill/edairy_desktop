



-- -----------------------------------------------------
-- Table BREED_REFERENCE
-- -----------------------------------------------------



CREATE  TABLE  BREED_REFERENCE (
  BREED_REFERENCEID INT  PRIMARY KEY,
  COMMON_NAME VARCHAR(45) NOT NULL ,
  SPECIES VARCHAR(45) NOT NULL ,
  BREED VARCHAR(45) NOT NULL  )
;





-- -----------------------------------------------------
-- Table IDTAG
-- -----------------------------------------------------



CREATE  TABLE  IDTAG (
  IDTAGID BIGINT PRIMARY KEY ,
  TAG_TYPE VARCHAR(15) NOT NULL DEFAULT 'BARCODE' ,
  TAG_VALUE VARCHAR(255) NOT NULL,
  DATE_ISSUED DATE NULL,
  DATE_EXPIRED DATE NULL )


;




-- -----------------------------------------------------
-- Table LOCATION
-- -----------------------------------------------------



CREATE  TABLE  LOCATION (
  LOCATIONID BIGINT PRIMARY KEY ,
  TAG VARCHAR(45) NULL ,
  ADDRESS VARCHAR(45) NULL ,
  SECTION VARCHAR(45) NULL ,
  ESTATE VARCHAR(45) NULL ,
  VILLAGE VARCHAR(45) NULL ,
  SUBLOCATION VARCHAR(45) NULL ,
  LOCATION VARCHAR(45) NULL ,
  DIVISION VARCHAR(45) NULL ,
  DISTRICT VARCHAR(45) NULL ,
  PROVINCE VARCHAR(45) NULL ,
  POSTALCODE VARCHAR(45) NULL ,
  POSTBOX  VARCHAR(45) NULL ,
  LATITUDE DOUBLE NULL ,
  LONGITUDE DOUBLE NULL ,
  LANDMARKS TEXT NULL ,
  DIRECTIONS TEXT NULL ,
  LANDREFERENCENUMBER VARCHAR(45) NULL ,)


;



-- -----------------------------------------------------
-- Table PERSON
-- -----------------------------------------------------



CREATE  TABLE  PERSON (
  PERSONID BIGINT PRIMARY KEY ,
  HONORIFIC VARCHAR(45) NULL ,
  FAMILYNAME VARCHAR(45) NULL ,
  GIVEN_NAME VARCHAR(45) NULL ,
  MIDDLENAME VARCHAR(45) NULL ,
  ADDITIONALNAMES TEXT NULL ,
  SUFFIX VARCHAR(45) NULL ,
  GENDER CHAR(1) NULL ,
  PHOTOCTYPE VARCHAR(45) NULL,
  PHOTO IMAGE NULL )


;




-- -----------------------------------------------------
-- Table CONTACT_METHOD
-- -----------------------------------------------------



CREATE  TABLE CONTACT_METHOD (
  CONTACT_METHODID BIGINT PRIMARY KEY ,
  CONTACT_INFO_TYPE CHAR(4) NULL ,
  CONTACT_INFO VARCHAR(45) NULL ,
  PERSONID BIGINT NOT NULL REFERENCES PERSON ,
  CONSTRAINT fk_CONTACT_METHOD_PERSON1
    FOREIGN KEY (PERSONID )
    REFERENCES PERSON (PERSONID )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)


;



-- -----------------------------------------------------
-- Table FARM
-- -----------------------------------------------------



CREATE  TABLE  FARM (
  FARMID BIGINT PRIMARY KEY ,
  LOCATIONID BIGINT NOT NULL REFERENCES LOCATION,
  OWNER_PERSONID BIGINT NOT NULL REFERENCES PERSON ,
  LICENSE_NUMBER VARCHAR(45) NOT NULL ,
  NAME VARCHAR(45) NOT NULL ,
  -- DEFAULT_COLLECTION_CENTER BIGINT  NULL REFERENCES DAIRYLOCATION 
  )

;



-- -----------------------------------------------------
-- Table FARM_CONTAINER
-- -----------------------------------------------------



CREATE  TABLE  FARM_CONTAINER (
  FARM_CONTAINERID BIGINT PRIMARY KEY ,
  FARMID BIGINT NOT NULL REFERENCES FARM ,
  UNIT_OF_MEASURE VARCHAR(15) NOT NULL DEFAULT 'KILOGRAM' ,
  CAPACITY DOUBLE NULL ,
  IDTAGID BIGINT REFERENCES IDTAG 
)
;



-- -----------------------------------------------------
-- Table FARMANIMAL
-- -----------------------------------------------------



CREATE  TABLE  FARMANIMAL (
  FARMANIMALID BIGINT PRIMARY KEY ,
  OWNER_PERSONID BIGINT NOT NULL REFERENCES PERSON ,
  FARMID BIGINT NOT NULL REFERENCES FARM ,
  GIVEN_NAME VARCHAR(45) NOT NULL ,
  GENDER CHAR(1) NOT NULL ,
  BIRTHDATE DATE NOT NULL ,
  PURPOSE_CODE CHAR(4) NOT NULL ,
  REARING_MODE_CODE CHAR(4) NOT NULL ,
  BREED VARCHAR(45) NOT NULL ,
  SIRE_BREED VARCHAR(45) NOT NULL ,
  DATE_ACQUIRED DATE NULL ,
  ACQUISITION_METHOD VARCHAR(45) NULL ,
  PAST_OWNERS TEXT NULL ,
  INSURANCE_NUMBER VARCHAR(45) NULL ,
  PHOTO IMAGE NULL ,
  IDENTIFYING_FEATURES TEXT NULL )


;



-- -----------------------------------------------------
-- Table FARMANIMAL_HISTORY
-- -----------------------------------------------------



CREATE  TABLE  FARMANIMAL_HISTORY (
  FARMANIMAL_HISTORYID BIGINT  PRIMARY KEY  ,
  FARMANIMALID BIGINT NOT NULL REFERENCES FARMANIMAL ,
  DATE_RECORDED DATE NOT NULL ,
  UPDATE_DESCRIPTION VARCHAR(80) NOT NULL )


;




-- -----------------------------------------------------
--                DAIRY-RELATIVE DATA
-- -----------------------------------------------------



-- -----------------------------------------------------
-- Table DAIRY
-- -----------------------------------------------------



CREATE  TABLE  DAIRY (
  DAIRYID BIGINT  PRIMARY KEY  ,
  LOCATIONID BIGINT NOT NULL REFERENCES LOCATION ,
  LEGAL_NAME VARCHAR(80) NOT NULL ,
  NHIFNUMBER VARCHAR(45) NULL ,
  KDBLICENSENUM VARCHAR(45) NULL ,
  NSSFNUMBER VARCHAR(45) NULL ,
  PUBLICDESCRIPTION VARCHAR(45) NULL ,
  PIN VARCHAR(45) NULL ,
  KDBLICENSEEXPIRATIONDATE DATE NULL ,
  KDBLICENSEEFFECTIVEDATE DATE NULL )


;



-- -----------------------------------------------------
-- Table ROLE
-- -----------------------------------------------------



CREATE  TABLE  ROLE (
  ROLEID BIGINT  PRIMARY KEY  ,
  NAME VARCHAR(45) NULL ,
  SYSTEMDEFINED TINYINT NULL DEFAULT 0 ,
  DESCRIPTION TEXT NULL )


;



-- -----------------------------------------------------
-- Table EMPLOYEE
-- -----------------------------------------------------



CREATE  TABLE  EMPLOYEE (
  EMPLOYEEID BIGINT PRIMARY KEY ,
  ISA_PERSONID BIGINT NOT NULL REFERENCES PERSON ,
  STARTDATE DATE NOT NULL ,
  ENDDATE DATE NULL ,
  JOBFUNCTION VARCHAR(15) NOT NULL ,
  SYSTEMUSERID BIGINT NULL ,
  USERNAME VARCHAR(45) NULL ,
  ENCRYPTEDPASSWORD VARCHAR(45) NULL ,
  ROLEID BIGINT  NULL ,
  PREVIOUS_EMPLOYEEID BIGINT  REFERENCES EMPLOYEE )
;




-- -----------------------------------------------------
-- Table DAIRYMEMBER
-- -----------------------------------------------------



CREATE  TABLE  DAIRYMEMBER (
  MEMBEROF_DAIRYID BIGINT NOT NULL REFERENCES DAIRY ,
  MEMBERID BIGINT PRIMARY KEY ,
  ISA_PERSONID BIGINT NOT NULL REFERENCES PERSON ,
  APPLICATION_DATE DATE NOT NULL ,
  EFFECTIVE_DATE DATE NULL ,
  STATUS CHAR(4) NULL )


;



-- -----------------------------------------------------
-- Table ACCOUNT
-- -----------------------------------------------------



CREATE  TABLE  ACCOUNT (
  MEMBERID BIGINT NOT NULL REFERENCES DAIRYMEMBER ,
  ACCOUNTID BIGINT PRIMARY KEY ,
  TYPE VARCHAR(45) NOT NULL DEFAULT 'CASH' ,
  START_DATE DATE NOT NULL ,
  END_DATE VARCHAR(45) NULL )

;



-- -----------------------------------------------------
-- Table ACCOUNT_TRANSACTION
-- -----------------------------------------------------



CREATE  TABLE  ACCOUNT_TRANSACTION (
  ACCOUNTID BIGINT NOT NULL REFERENCES ACCOUNT ,
  ACCOUNT_TRANSACTIONID BIGINT PRIMARY KEY ,
  TRANSACTION_DATE TIMESTAMP NOT NULL ,
  TYPE INT NOT NULL ,
  SOURCE VARCHAR(45) NOT NULL ,
  AMOUNT DECIMAL(38,0) NOT NULL ,
  DESCRIPTION VARCHAR(80) NOT NULL )


;



-- -----------------------------------------------------
-- Table DAIRYROUTE
-- -----------------------------------------------------



CREATE  TABLE  DAIRYROUTE (
  OPERATED_BY_DAIRYID BIGINT REFERENCES DAIRY,
  ROUTEID BIGINT PRIMARY KEY ,
  NAME VARCHAR(45) NOT NULL ,
  DESCRIPTION VARCHAR(45) NULL )


;



-- -----------------------------------------------------
-- Table DAIRYLOCATION
-- -----------------------------------------------------



CREATE  TABLE  DAIRYLOCATION (
  BRANCH_OF_DAIRYID BIGINT NOT NULL REFERENCES DAIRY ,
  DAIRYLOCATIONID BIGINT PRIMARY KEY ,
  NAME VARCHAR(45) NULL ,
  LOCATIONID BIGINT NOT NULL REFERENCES LOCATION ,
  ROUTEID BIGINT REFERENCES DAIRYROUTE ,
  DATEOPENED DATE NULL ,
  PHONENUMBER VARCHAR(45) NULL ,
  DESCRIPTION VARCHAR(45) NULL ,
  COLORCODE VARCHAR(15) NULL )

 
;





-- -----------------------------------------------------
-- Table ACCOUNTBALANCE
-- -----------------------------------------------------



CREATE  TABLE  ACCOUNTBALANCE (
  ACCOUNTID BIGINT NOT NULL REFERENCES ACCOUNT ,
  ACCOUNTBALANCEID BIGINT PRIMARY KEY ,
  PREVIOUS_ACCOUNTBALANCEID BIGINT NOT NULL REFERENCES ACCOUNTBALANCE ,
  AMOUNT DECIMAL(38,2) NOT NULL ,
  ASOF DATETIME NOT NULL )


;



-- -----------------------------------------------------
-- Table DAIRYASSET
-- -----------------------------------------------------



CREATE  TABLE  DAIRYASSET (
  OWNED_BY_DAIRYID BIGINT NOT NULL REFERENCES DAIRY ,
  ASSETID BIGINT PRIMARY KEY ,
  DATE_ACQUIRED DATE NULL ,
  DATE_DISPOSED DATE NULL ,
  DISPOSAL_REASON VARCHAR(45) NULL ,
  DISPOSAL_METHOD TEXT NULL ,
  WITNESS VARCHAR(45) NULL ,
  DAMAGE_NOTES TEXT NULL )
;



-- -----------------------------------------------------
-- Table DAIRYVEHICLE
-- -----------------------------------------------------



CREATE  TABLE  DAIRYVEHICLE (
  USED_BY_DAIRYID BIGINT NOT NULL REFERENCES DAIRY ,
  VEHICLEID BIGINT PRIMARY KEY ,
  ASSETID BIGINT NOT NULL,
  TYPE VARCHAR(15) NOT NULL DEFAULT 'TRUCK',
  MAKE VARCHAR(45) NULL ,
  MODEL VARCHAR(45) NULL ,
  DOMINANT_COLOUR VARCHAR(45) NULL ,
  INSURANCE_POLICY_NUMBER VARCHAR(45) NULL ,
  CHASSIS_NUMBER VARCHAR(45) NULL ,
  ENGINE_NUMBER VARCHAR(45) NULL ,
  REGISTRATION_NUMBER VARCHAR(45) NULL ,
  LOGBOOK_NUMBER VARCHAR(45) NULL ,
  INSURANCE_PURCHASE_DATE DATE NULL ,
  TONNAGE DOUBLE NULL ,
  MODEL_YEAR DECIMAL(4,0) NULL )


;



-- -----------------------------------------------------
-- Table DAIRY_CONTAINER
-- -----------------------------------------------------



CREATE  TABLE  DAIRY_CONTAINER (
  DAIRYID BIGINT NOT NULL REFERENCES DAIRY ,
  CONTAINERID BIGINT PRIMARY KEY ,
  ROUTEID BIGINT REFERENCES DAIRYROUTE ,
  ASSETID BIGINT NULL REFERENCES DAIRYASSET ,
  UNIT_OF_MEASURE VARCHAR(15) NOT NULL DEFAULT 'KILOGRAM' ,
  CAPACITY DOUBLE NULL ,
  IDTAGID BIGINT REFERENCES IDTAG )
;


-- -----------------------------------------------------
-- Table DAIRY_COLLECTION_JOURNAL
-- -----------------------------------------------------



CREATE  TABLE  COLLECTION_JOURNAL (
  DAIRYID BIGINT NOT NULL REFERENCES DAIRY ,
  JOURNALID BIGINT PRIMARY KEY ,
  REFERENCENUMBER VARCHAR(45) NOT NULL ,
  JOURNALDATE DATE NOT NULL ,
  ROUTEID BIGINT NOT NULL REFERENCES DAIRYROUTE ,
  COLLECTION_SESSION VARCHAR(45) NOT NULL ,
  DRIVER_EMPLOYEEID BIGINT REFERENCES EMPLOYEE ,
  VEHICLEID BIGINT REFERENCES DAIRYVEHICLE ,
  JOURNAL_TOTAL DECIMAL(38,2) NOT NULL ,
  FLAGGED TINYINT NOT NULL DEFAULT 0 )
;





-- -----------------------------------------------------
-- Table DAIRY_COLLECTION_RECORD
-- -----------------------------------------------------



CREATE  TABLE  COLLECTION_RECORD (
  DAIRYID BIGINT NOT NULL REFERENCES DAIRY ,
  COLLECTION_RECORDID BIGINT PRIMARY KEY ,
  COLLECTION_JOURNALID BIGINT NOT NULL REFERENCES COLLECTION_JOURNAL ,
  JOURNAL_LINE_NUMBER INT NOT NULL ,
  RECORDED_MEMBERID VARCHAR(45) NOT NULL ,
  VALID_MEMBERID BIGINT REFERENCES DAIRYMEMBER ,
  MILK_UNIT_OF_MEASURE VARCHAR(15) NULL DEFAULT 'KILOGRAM' ,
  MILK_QUANTITY DECIMAL(38,2) NOT NULL ,
  COLLECTED_FROM_CAN BIGINT NULL ,
  MIXED_INTO_BIN BIGINT NOT NULL ,
  OFFROUTE TINYINT NOT NULL DEFAULT 0 ,
  REJECTED TINYINT NOT NULL DEFAULT 0 ,
  NOTRECORDED TINYINT NOT NULL DEFAULT 0 ,
  FLAGGED TINYINT NOT NULL DEFAULT 0 )


;

-- -----------------------------------------------------
-- Table MILK_PRICE
-- -----------------------------------------------------

CREATE  TABLE  MILK_PRICE (
  DAIRYID BIGINT NOT NULL REFERENCES DAIRY ,
  MILK_PRICEID BIGINT PRIMARY KEY ,
  PRICEDATE DATE NOT NULL ,
  PRICE DECIMAL(38,4) NOT NULL )


;

-- -----------------------------------------------------
-- Table SUPPLIER
-- -----------------------------------------------------

CREATE  TABLE  SUPPLIER (
  SUPPLIERID BIGINT PRIMARY KEY ,
  DAIRYID BIGINT NOT NULL ,
  LOCATIONID BIGINT PRIMARY KEY ,
  SUPPLIER_NAME VARCHAR(45) NOT NULL ,
  STATUS VARCHAR(15) NOT NULL ,
  CATEGORY_LIST VARCHAR(255) NULL ,
  DESCRIPTION VARCHAR(255) NOT NULL ,
  REGISTRATION_DATE DATE NULL ,
  EXPIRATION_DATE DATE NULL ,
  CONTACT_PERSONID BIGINT REFERENCES PERSON 
)


;



-- -----------------------------------------------------
-- Table PERMISSION
-- -----------------------------------------------------



CREATE  TABLE  PERMISSION (
  PERMISSIONID BIGINT PRIMARY KEY ,
  SHORTNAME VARCHAR(45) NULL ,
  DESCRIPTION VARCHAR(254) NULL )

;



-- -----------------------------------------------------
-- Table ROLE_PERMISSIONS
-- -----------------------------------------------------



CREATE  TABLE  ROLE_PERMISSION (
  ROLEID BIGINT NOT NULL REFERENCES ROLE ,
  PERMISSIONID BIGINT NOT NULL REFERENCES PERMISSION,
  PRIMARY KEY (ROLEID, PERMISSIONID) )
;



-- -----------------------------------------------------
-- Table SERVICEOFFERING
-- -----------------------------------------------------



CREATE  TABLE  SERVICEOFFERING (
  SERVICE_OF_DAIRYID BIGINT NOT NULL REFERENCES DAIRY ,
  SERVICEOFFERINGID INT  PRIMARY KEY ,
  SHORTNAME VARCHAR(15) NOT NULL ,
  DISPLAYNAME VARCHAR(45) NOT NULL ,
  DESCRIPTION TEXT NULL )
;



-- -----------------------------------------------------
-- Table DAIRYLOCATION_SERVICEOFFERING
-- -----------------------------------------------------



CREATE  TABLE  DAIRYLOCATION_SERVICEOFFERING (
  DAIRYLOCATIONID BIGINT NOT NULL REFERENCES DAIRYLOCATION ,
  SERVICEOFFERINGID INT  NOT NULL REFERENCES SERVICEOFFERING,
  PRIMARY KEY (DAIRYLOCATIONID, SERVICEOFFERINGID))

;



-- -----------------------------------------------------
-- Table HEALTH_REQUEST
-- -----------------------------------------------------



CREATE  TABLE  HEALTH_REQUEST (
  HEALTH_REQUESTID BIGINT PRIMARY KEY ,
  DAIRYID BIGINT NOT NULL REFERENCES DAIRY ,
  MEMBERID BIGINT NOT NULL REFERENCES DAIRYMEMBER ,
  FARMID BIGINT NOT NULL REFERENCES FARM ,
  REQUEST_DATE VARCHAR(45) NOT NULL ,
  REQUEST_TYPE VARCHAR(15) NOT NULL ,
  FARMANIMALID BIGINT REFERENCES FARMANIMAL ,
  HEAT_OBSERVED DATE NULL ,
  FIRST_APPLICATION DATE NULL ,
  SECOND_APPLICATION DATE NULL ,
  THIRD_APPLICATION DATE NULL ,
  REQUEST_DESCRIPTION TEXT NULL ,
  REFERRED_TO BIGINT NULL REFERENCES SUPPLIER)
;

