load data infile '/tmp/applifire/db/PQDARA1GRKHTD9AOCRDQ/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/art/data/art_chart_template.csv' "str '#appfirenewline#'" into table art_chart_template FIELDS TERMINATED BY '#appfire#' (template_id,template_name,template_json,created_by,created_date DATE 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date DATE 'yyyy-mm-dd hh24:mi:ss',version_id,project_id,project_version_id,active_status,app_creator_id)

