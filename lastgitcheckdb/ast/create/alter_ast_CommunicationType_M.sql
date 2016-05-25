

ALTER TABLE ast_CommunicationType_M ADD CONSTRAINT fk_c16e7fe45 FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



exit;