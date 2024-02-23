set serveroutput on;

declare
    sql_qry varchar2(100);
    total number;
begin
    sql_qry := 'select count(*) from product';

    execute immediate sql_qry into total;
    
    dbms_output.put_line('Total products is: ' || total);
end;
/