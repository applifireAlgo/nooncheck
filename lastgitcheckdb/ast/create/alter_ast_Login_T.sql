

ALTER TABLE ast_Login_T ADD CONSTRAINT fk_0a17f90ca FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_Login_T ADD CONSTRAINT fk_a99d0650f FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;