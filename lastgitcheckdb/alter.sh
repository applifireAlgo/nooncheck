









ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe
ORACLE_SID=XE
PATH=$PATH:$ORACLE_HOME/bin:$ORACLE_SID
export ORACLE_HOME
export ORACLE_SID
export PATH
DB_PATH=/tmp/applifire/db/PQDARA1GRKHTD9AOCRDQ/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C
ART_CREATE_PATH=/tmp/applifire/db/PQDARA1GRKHTD9AOCRDQ/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/art/create
AST_CREATE_PATH=/tmp/applifire/db/PQDARA1GRKHTD9AOCRDQ/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/ast/create
MYSQL=/usr/bin
APPLFIREUSER=root
APPLFIREPASSWORD=root
APPLFIREHOST=localhost



DB_NAME=lastgitcheck
USER=lastgitcheck
PASSWORD=lastgit
PORT=1521
HOST=localhost


sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Timezone_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Language_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Country_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_State_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_City_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_AddressType_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Address_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_ContactType_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_CommunicationGroup_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_CommunicationType_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Gender_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Title_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_CoreContacts_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_AddressMap_B.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_CommunicationData_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_CommunicationMap_B.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_PasswordAlgo_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_PasswordPolicy_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Question_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_UserAccessLevel_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_UserAccessDomain_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_User_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Login_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_LoginSession_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_UserAppState_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_PassRecovery_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_UserData_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_SessionData_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_Roles_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_AppMenus_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_RoleMenuBridge_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/alter_ast_UserRoleBridge_T.sql; 

