load data infile '/tmp/applifire/db/PQDARA1GRKHTD9AOCRDQ/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/art/data/art_password_policy.csv' "str '#appfirenewline#'" into table art_password_policy FIELDS TERMINATED BY '#appfire#' (policyId,policyName,policyDescription,minPwdLength,maxPwdLength,minCapitalLetters,minSmallLetters,minNumericValues,minSpecialLetters,allowedSpecialLetters
,version_id,updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"')

