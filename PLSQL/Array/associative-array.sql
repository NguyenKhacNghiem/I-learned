set serveroutput on;

declare 
    -- Tạo 1 Associative Array có key là varchar2(20) và value là number. Nếu có chỉ định index by datatype thì mảng sẽ có kích thước động -> ko cần extend
    type associative_array is table of number index by varchar2(20);

    arr associative_array;
    current_key varchar2(20);

    -- Tạo 1 Associative Array có key mặc định là number và value là number
    -- type associative_array is table of number;
    -- arr associative_array(1 to 10); 
    -- Do ko chỉ định index by datatype nên phải khai báo kích thước tĩnh cho mảng

    -- Tạo 1 Associative Array đồng thời khởi tạo các giá trị cho nó: index bắt đầu từ 1 và kích thước cố định là 3. Muốn thêm vào index 4 thì phải dùng hàm extend để tăng kích thước lên 1.
    -- type associative_array is table of number;
    -- arr associative_array := associative_array(1000, 2000, 3000);
begin
    arr('item 1') := 1000;
    arr('item 2') := 2000;
    arr('item 3') := 3000;
    arr('item 4') := 4000;
    arr('item 5') := 5000;
    
    -- Lấy value của 1 phần tử dựa vào 1 key bất kỳ
    dbms_output.put_line('Value of item 1 is: ' || arr('item 1'));
    
    -- Lấy tất cả value bằng cách lặp qua tất cả các key
    current_key := arr.first;
    while current_key is not null
    loop
        dbms_output.put_line('Key ' || current_key || ' has value is ' || arr(current_key));
        current_key := arr.next(current_key);
    end loop;
end;