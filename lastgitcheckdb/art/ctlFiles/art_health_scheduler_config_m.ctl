load data infile '/tmp/applifire/db/PQDARA1GRKHTD9AOCRDQ/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/art/data/art_health_scheduler_config_m.csv' "str '#appfirenewline#'" into table art_health_scheduler_config_m FIELDS TERMINATED BY '#appfire#' (schedulerId,schedulerkey,refreshTime,refreshUnit,batchSize,enabled,connectorClass,dataModel,schedulerName,threadPoolSize,version_id,created_by,
created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',active_status)

