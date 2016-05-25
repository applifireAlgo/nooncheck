

ALTER TABLE ast_Address_T ADD CONSTRAINT fk_ea6da125c FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_a09178912 FOREIGN KEY (addressTypeId) REFERENCES ast_AddressType_M(addressTypeId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_64470530e FOREIGN KEY (cityId) REFERENCES ast_City_M(cityId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_81e81314f FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;