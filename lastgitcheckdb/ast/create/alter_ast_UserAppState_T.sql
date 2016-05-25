

ALTER TABLE ast_UserAppState_T ADD CONSTRAINT fk_030cea35a FOREIGN KEY (appSessionId) REFERENCES ast_LoginSession_T(AppSessionId);



exit;