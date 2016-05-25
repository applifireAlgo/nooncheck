
connect sys/oracle as sysdba
create tablespace lastgitcheck DATAFILE '/u01/app/oracle/oradata/lastgitcheck.dbf' SIZE 100M EXTENT MANAGEMENT LOCAL AUTOALLOCATE;
declare
userexist integer;
begin
select count(*) into userexist from dba_users where username='LASTGITCHECK';
if (userexist = 0) then
execute immediate 'create user lastgitcheck identified by lastgit default tablespace lastgitcheck';
end if;
end;
/
ALTER USER "LASTGITCHECK" DEFAULT TABLESPACE "LASTGITCHECK" TEMPORARY TABLESPACE "TEMP" ACCOUNT UNLOCK ;
exit;