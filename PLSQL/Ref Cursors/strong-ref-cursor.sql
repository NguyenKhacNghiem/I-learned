set serveroutput on;

declare
    type strong_ref_cursor is ref cursor return person%rowtype;
    v_cursor strong_ref_cursor;
    v_row person%rowtype;
begin
    open v_cursor for select * from person where id = 1;
    fetch v_cursor into v_row;
    close v_cursor;
    
    dbms_output.put_line('The name of person with id = ' || v_row.id || ' is ' || v_row.name);
end;
/