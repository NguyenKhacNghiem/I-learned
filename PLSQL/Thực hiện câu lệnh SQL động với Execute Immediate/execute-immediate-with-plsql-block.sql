set serveroutput on;

declare
    plsql varchar2(300);
begin
    plsql := '  declare
                    v_current_user varchar2(20);
                begin
                    select user into v_current_user from dual;
                    dbms_output.put_line(''Current user is: '' || v_current_user);
                end;';
                
    execute immediate plsql;
end;
/