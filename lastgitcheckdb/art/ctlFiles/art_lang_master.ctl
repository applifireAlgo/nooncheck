load data infile '/tmp/applifire/db/PQDARA1GRKHTD9AOCRDQ/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/art/data/art_lang_master.csv' "str '#appfirenewline#'" into table art_lang_master FIELDS TERMINATED BY '#appfire#' (lang_id,lang_name,country_code,country_name,updated_by,updated_date DATE 'yyyy-mm-dd hh24:mi:ss',created_by,created_date DATE 'yyyy-mm-dd hh24:mi:ss',version_id,active_status)

