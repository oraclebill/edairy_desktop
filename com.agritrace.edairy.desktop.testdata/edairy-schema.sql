
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
