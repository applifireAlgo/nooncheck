

ALTER TABLE ast_User_T ADD CONSTRAINT fk_7f048a00e FOREIGN KEY (userAccessLevelId) REFERENCES ast_UserAccessLevel_M(userAccessLevelId);



ALTER TABLE ast_User_T ADD CONSTRAINT fk_856f532d7 FOREIGN KEY (userAccessDomainId) REFERENCES ast_UserAccessDomain_M(userAccessDomainId);



exit;