

ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_9d1e27776 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_80b8f2f0f FOREIGN KEY (commDataId) REFERENCES ast_CommunicationData_TP(commDataId);



exit;