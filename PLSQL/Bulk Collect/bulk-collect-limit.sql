set serveroutput on;

declare
    cursor my_cursor is select pname from product;
    
    type product_name is table of product.pname%type;
    v_pname product_name;
begin
    open my_cursor;
    fetch my_cursor bulk collect into v_pname limit 3;
    close my_cursor;
    
    for i in 1 .. v_pname.count
    loop
        dbms_output.put_line(i || '. ' || v_pname(i));
    end loop;
end;