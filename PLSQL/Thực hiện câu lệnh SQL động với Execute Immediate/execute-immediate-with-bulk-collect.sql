set serveroutput on;

declare
    type associative_array is table of varchar2(100);
    pname associative_array;
    sql_qry varchar2(200);
begin
    -- Gặp lỗi do bulk collect into phải được thực thi trong khối lệnh begin...end
--    sql_qry := 'select pname bulk collect into pname from product';
--    execute immediate sql_qry;
    
    sql_qry := 'select pname from product';
    execute immediate sql_qry bulk collect into pname;
    
    for i in 1..pname.count loop
        dbms_output.put_line(i || '. ' || pname(i));
    end loop;
end;
/