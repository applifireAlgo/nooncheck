

ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_6298e03f5 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_af54a52ca FOREIGN KEY (menuId) REFERENCES ast_AppMenus_M(menuId);



exit;