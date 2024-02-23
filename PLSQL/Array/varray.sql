set serveroutput on;

-- Sử dụng varray để làm kiểu dữ liệu (datatype) cho một cột trong table
create type obj_varray is varray(5) of number;
/

create table person
(
    id number not null primary key,
    name varchar2(30),
    favorite_number obj_varray
);
/

insert into person values(1, 'David', obj_varray(88, 72, 99, 12, 3));
insert into person values(2, 'John', obj_varray(25, 8));
insert into person values(3, 'Anna', obj_varray(46, 87, 61));

select * from person;

select p.id, p.name, temp.column_value as favorite_number
from person p, table (p.favorite_number) temp;
/ 

-- Sử dụng procedure extend để cấp phát thêm vùng nhớ cho varray
declare
    type my_varray is varray(5) of number;
    numbers my_varray := my_varray();
begin
    numbers.extend;
    numbers(1) := 10;
    dbms_output.put_line('Maximum size: ' || numbers.limit);
end;
/