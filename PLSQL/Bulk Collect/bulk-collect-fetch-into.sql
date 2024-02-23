set serveroutput on;

declare
    cursor my_cursor is select pname from product;
    
    type product_name is table of product.pname%type;
    v_pname product_name;
begin
    open my_cursor;
    
    loop
        fetch my_cursor bulk collect into v_pname;
        exit when v_pname.count = 0;
        
        for i in v_pname.first .. v_pname.last
        loop
            dbms_output.put_line(i || '. ' || v_pname(i));
        end loop;
    end loop;
    
    close my_cursor;
end;