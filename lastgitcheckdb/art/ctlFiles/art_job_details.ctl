load data infile '/tmp/applifire/db/PQDARA1GRKHTD9AOCRDQ/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/art/data/art_job_details.csv' "str '#appfirenewline#'" into table art_job_details FIELDS TERMINATED BY '#appfire#' (jobId,jobName,uiJson char(20000),processJson char(20000),project_id,app_creator_id,project_version_id,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',version_id,active_status,beanName,currentStatus,statusTime TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"')
