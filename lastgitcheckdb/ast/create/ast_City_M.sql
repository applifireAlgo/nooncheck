CREATE TABLE ast_City_M ( cityId VARCHAR2(64)  NOT NULL, countryId VARCHAR2(64)  NOT NULL, stateId VARCHAR2(64)  NOT NULL, cityName VARCHAR2(256)  NOT NULL, cityCodeChar2 VARCHAR2(32)  NOT NULL, cityCode NUMBER(3)  NOT NULL, cityDescription VARCHAR2(128)  DEFAULT NULL, cityFlag VARCHAR2(128)  DEFAULT NULL, cityLatitude NUMBER(11)  DEFAULT NULL, cityLongitude NUMBER(11)  DEFAULT NULL, createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', versionId NUMBER(10)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER(10)  DEFAULT NULL, PRIMARY KEY (cityId));

exit;