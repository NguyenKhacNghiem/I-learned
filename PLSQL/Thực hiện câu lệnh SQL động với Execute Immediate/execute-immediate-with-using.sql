set serveroutput on;

declare
    ddl_qry varchar2(200);
begin
    ddl_qry := 'insert into fraction values(:numerator, :denominator)';
    
    -- Using cho phép pass giá trị vào bind variable theo thứ tự từ trái sang phải
    execute immediate ddl_qry using 1, 2;
end;
/

select * from fraction;