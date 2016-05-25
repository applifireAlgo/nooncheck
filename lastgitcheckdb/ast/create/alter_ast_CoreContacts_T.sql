

ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_a5928a067 FOREIGN KEY (timeZoneId) REFERENCES ast_Timezone_M(timeZoneId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_2d2d37b14 FOREIGN KEY (genderId) REFERENCES ast_Gender_M(genderId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_ef44c3dd1 FOREIGN KEY (titleId) REFERENCES ast_Title_M(titleId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_b77052260 FOREIGN KEY (nativeLanguageCode) REFERENCES ast_Language_M(languageId);



exit;