create table Administrator(
id varchar primary key,
pin number(4) );


create table Cust(
cid varchar primary key,
name varchar not null,
password varchar not null,
contact number(10) not null,
location varchar not null);

CREATE TABLE BOOKSBIKE(
CID VARCHAR(10) not null,
BID VARCHAR(10) NOT NULL,
TEST_DRIVE NUMBER(1) NULL,
bookingdate varchar(20) not null,
advance number(1) not null,
FOREIGN KEY (cid) REFERENCES Cust(cid),
FOREIGN KEY (bid) REFERENCES bikes(bid));



create table bikes(
bid varchar(15) primary key,
name varchar(25) not null,
price varchar(10) not null,
specification varchar(100) not null,
availablity varchar(10) not null,
model_type varchar(10) not null);

CREATE TABLE DEL_HISTORY(
CID VARCHAR(10) PRIMARY KEY,
NAME VARCHAR(30) NOT NULL,
PASSWORD VARCHAR(16) NOT NULL,
CONTACT VARCHAR(10) NOT NULL,
LOCATION VARCHAR(25) NOT NULL,
REASON VARCHAR(50) NOT NULL,
 ACTION VARCHAR(20));
 
 CREATE TABLE CANCEL_HISTORY(
 CID VARCHAR(10) PRIMARY KEY,
BID VARCHAR(10) NOT NULL,
TEST_DRIVE NUMBER(1) NULL,
bookingdate varchar(20) not null,
advance number(1) not null,
REASON VARCHAR(100) NOT NULL,
ACTION VARCHAR(25) NOT NULL);

CREATE OR REPLACE TRIGGER CANCEL_HISTORY
BEFORE DELETE
ON BOOKSBIKE
FOR EACH ROW
BEGIN
	INSERT INTO CANCEL_HISTORY VALUES(:OLD.CID,:OLD.BID,:OLD.TEST_DRIVE,:OLD.bookingdate,:OLD.advance,'As I was not satisfied with the design','CANCELED');
END;

CREATE OR REPLACE TRIGGER DELT_HISTORY
BEFORE DELETE
ON CUST
FOR EACH ROW
BEGIN
	INSERT INTO DEL_HISTORY VALUES(:OLD.CID,:OLD.NAME,:OLD.PASSWORD,:OLD.CONTACT,:OLD.LOCATION,'SPAM','DELETED');
END;


CREATE OR REPLACE TRIGGER add_again
BEFORE DELETE
ON del_history
FOR EACH ROW
BEGIN
	INSERT INTO cust VALUES(:OLD.CID,:OLD.NAME,:OLD.PASSWORD,:OLD.CONTACT,:OLD.LOCATION);
END;
