

ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_187b98c8f FOREIGN KEY (questionId) REFERENCES ast_Question_M(questionId);



ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_77fd9b1fe FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;