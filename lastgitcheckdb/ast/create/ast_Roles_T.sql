CREATE TABLE ast_Roles_T ( roleId VARCHAR2(64)  NOT NULL, roleName VARCHAR2(256)  NOT NULL, roleDescription VARCHAR2(256)  NOT NULL, roleIcon VARCHAR2(64)  DEFAULT NULL, roleHelp VARCHAR2(256)  DEFAULT NULL, createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', versionId NUMBER(10)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER(10)  DEFAULT NULL, PRIMARY KEY (roleId));

exit;