

ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_886c66cab FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_41cb4e343 FOREIGN KEY (addressId) REFERENCES ast_Address_T(addressId);



exit;