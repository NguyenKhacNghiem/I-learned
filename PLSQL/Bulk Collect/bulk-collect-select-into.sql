set serveroutput on;

declare
    type fullname is table of person.name%type;
    v_name fullname;
begin
    select name bulk collect into v_name
    from person;
    
    for i in 1..v_name.count
    loop
        dbms_output.put_line('Name ' || i || ': ' || v_name(i));
    end loop;
end;