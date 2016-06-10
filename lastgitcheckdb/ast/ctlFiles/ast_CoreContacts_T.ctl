load data infile '/tmp/applifire/db/PQDARA1GRKHTD9AOCRDQ/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/ast/data/CoreContacts.csv' into table ast_CoreContacts_T FIELDS TERMINATED BY '#appfire#' (contactId,titleId,firstName,middleName CHAR(1000) "decode(:middleName, '\\N', null, :middleName)",lastName,nativeLanguageCode CHAR(1000) "decode(:nativeLanguageCode, '\\N', null, :nativeLanguageCode)",nativeTitle CHAR(1000) "decode(:nativeTitle, '\\N', null, :nativeTitle)",nativeFirstName CHAR(1000) "decode(:nativeFirstName, '\\N', null, :nativeFirstName)",nativeMiddleName CHAR(1000) "decode(:nativeMiddleName, '\\N', null, :nativeMiddleName)",nativeLastName CHAR(1000) "decode(:nativeLastName, '\\N', null, :nativeLastName)",genderId,dateofbirth TIMESTAMP 'yyyy-mm-dd hh24:mi:ss' "decode(:dateofbirth, '\\N', null, :dateofbirth)",age CHAR(1000) "decode(:age, '\\N', null, :age)",approximateDOB TIMESTAMP 'yyyy-mm-dd hh24:mi:ss' "decode(:approximateDOB, '\\N', null, :approximateDOB)",emailId,phoneNumber,timeZoneId CHAR(1000) "decode(:timeZoneId, '\\N', null, :timeZoneId)",createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")
