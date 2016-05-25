

ALTER TABLE ast_City_M ADD CONSTRAINT fk_c162797a7 FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_City_M ADD CONSTRAINT fk_59a71045b FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;