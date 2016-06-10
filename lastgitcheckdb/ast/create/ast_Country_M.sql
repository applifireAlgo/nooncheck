CREATE TABLE ast_Country_M ( countryId VARCHAR2(64)  NOT NULL, countryName VARCHAR2(128)  NOT NULL, countryCode1 VARCHAR2(3)  DEFAULT NULL, countryCode2 VARCHAR2(3)  DEFAULT NULL, countryFlag VARCHAR2(64)  DEFAULT NULL, capital VARCHAR2(32)  DEFAULT NULL, currencyCode VARCHAR2(3)  DEFAULT NULL, currencyName VARCHAR2(128)  DEFAULT NULL, currencySymbol VARCHAR2(32)  DEFAULT NULL, capitalLatitude NUMBER(11)  DEFAULT NULL, capitalLongitude NUMBER(11)  DEFAULT NULL, isoNumeric NUMBER(11)  DEFAULT NULL, createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', versionId NUMBER(10)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER(10)  DEFAULT NULL, PRIMARY KEY (countryId));

exit;