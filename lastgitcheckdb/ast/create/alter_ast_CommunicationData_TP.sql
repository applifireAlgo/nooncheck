

ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_c7dfcb71b FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_fda7adb33 FOREIGN KEY (commType) REFERENCES ast_CommunicationType_M(commType);



exit;