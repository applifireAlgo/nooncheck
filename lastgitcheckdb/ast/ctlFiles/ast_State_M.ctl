load data infile '/tmp/applifire/db/PQDARA1GRKHTD9AOCRDQ/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/ast/data/State.csv' into table ast_State_M FIELDS TERMINATED BY '#appfire#' (stateId,countryId,stateName,stateCode CHAR(1000) "decode(:stateCode, '\\N', null, :stateCode)",stateCodeChar2,stateCodeChar3 CHAR(1000) "decode(:stateCodeChar3, '\\N', null, :stateCodeChar3)",stateDescription CHAR(1000) "decode(:stateDescription, '\\N', null, :stateDescription)",stateFlag CHAR(1000) "decode(:stateFlag, '\\N', null, :stateFlag)",stateCapital CHAR(1000) "decode(:stateCapital, '\\N', null, :stateCapital)",stateCapitalLatitude CHAR(1000) "decode(:stateCapitalLatitude, '\\N', null, :stateCapitalLatitude)",stateCapitalLongitude CHAR(1000) "decode(:stateCapitalLongitude, '\\N', null, :stateCapitalLongitude)",createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")

