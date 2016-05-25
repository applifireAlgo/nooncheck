CREATE TABLE art_log_severity_m ( severityId NUMBER(11) NOT NULL, severity varchar2(64) NOT NULL, versionId NUMBER(10) DEFAULT NULL, createdBy NUMBER(10) DEFAULT NULL, createdDate TIMESTAMP(0) DEFAULT NULL NULL, updatedBy NUMBER(10) DEFAULT NULL, updatedDate TIMESTAMP(0) DEFAULT NULL, activeStatus NUMBER(3) DEFAULT NULL, PRIMARY KEY (severityId) ) ;

exit

