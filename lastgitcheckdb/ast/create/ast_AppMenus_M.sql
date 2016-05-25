CREATE TABLE ast_AppMenus_M ( menuId VARCHAR2(64)  NOT NULL, menuTreeId VARCHAR2(256)  NOT NULL, menuIcon VARCHAR2(256)  DEFAULT NULL, menuAction VARCHAR2(256)  DEFAULT NULL, menuCommands VARCHAR2(64)  DEFAULT NULL, menuDisplay CHAR CHECK (menuDisplay in (0,1)), menuHead CHAR CHECK (menuHead in (0,1)), menuLabel VARCHAR2(256)  NOT NULL, uiType VARCHAR2(3)  DEFAULT NULL, refObjectId VARCHAR2(256)  DEFAULT NULL, menuAccessRights NUMBER(11)  NOT NULL, appType NUMBER(1)  DEFAULT NULL, appId VARCHAR2(256)  DEFAULT NULL, autoSave CHAR CHECK (autoSave in (0,1)), createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', versionId NUMBER(10)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER(10)  DEFAULT NULL, PRIMARY KEY (menuId));

exit;