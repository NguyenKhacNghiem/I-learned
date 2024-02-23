set serveroutput on;

create table mul_table
(
    val number
);
/

declare
    type associative_array is table of number index by pls_integer;
    v_arr associative_array;
begin
    for i in 1..10 loop
        v_arr(i) := i ;
    end loop;
    
    forall i in 1..10
        insert into mul_table values(10 * v_arr(i));
end;
/

select * from mul_table;