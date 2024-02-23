set serveroutput on;

declare
    v_cursor sys_refcursor;
    v_id person.id%type;
    v_name person.name%type;
begin
    open v_cursor for select id, name from person where id = 1;
    fetch v_cursor into v_id, v_name;
    close v_cursor;
    
    dbms_output.put_line('The name of person with id = ' || v_id || ' is ' || v_name);
end;
/