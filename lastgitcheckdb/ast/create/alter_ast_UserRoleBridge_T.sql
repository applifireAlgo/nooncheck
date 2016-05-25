

ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_c99b09668 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_1a6e9b5de FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;