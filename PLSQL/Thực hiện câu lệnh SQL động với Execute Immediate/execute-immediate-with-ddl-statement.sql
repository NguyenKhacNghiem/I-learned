set serveroutput on;

declare
    ddl_qry varchar2(200);
begin
    ddl_qry := 'create table fraction(
                  numerator number,
                  denominator number
                )';
    
    execute immediate ddl_qry;
end;
/

desc fraction;