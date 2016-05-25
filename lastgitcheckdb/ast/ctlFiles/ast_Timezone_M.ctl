load data infile '/tmp/applifire/db/PQDARA1GRKHTD9AOCRDQ/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/ast/data/Timezone.csv' into table ast_Timezone_M FIELDS TERMINATED BY '#appfire#' (timeZoneId,utcdifference,gmtLabel CHAR(1000) "decode(:gmtLabel, '\\N', null, :gmtLabel)",timeZoneLabel CHAR(1000) "decode(:timeZoneLabel, '\\N', null, :timeZoneLabel)",country CHAR(1000) "decode(:country, '\\N', null, :country)",cities CHAR(1000) "decode(:cities, '\\N', null, :cities)",createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")

