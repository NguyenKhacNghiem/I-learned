set serveroutput on;

create table add_table
(
    val number
);
/

declare
    type associative_array is table of number;
    v_arr associative_array := associative_array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
begin
    v_arr.delete(3, 6); -- sau khi xóa: 1, 2, 7, 8, 9, 10
    
    -- Khi index của associative array không liền nhau thì dùng câu lệnh này sẽ gặp lỗi
--    forall i in 1..v_arr.count 
--        insert into add_table values(10 + v_arr(i));
    
    -- Giải pháp: dùng indices of
    forall i in indices of v_arr
        insert into add_table values(10 + v_arr(i));
end;
/

select * from add_table;