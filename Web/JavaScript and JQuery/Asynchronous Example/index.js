// Định nghĩa một hàm sử dụng callback
function fetchData(callback) {
    // Giả sử chúng ta có một công việc bất đồng bộ ở đây, ví dụ lấy dữ liệu từ máy chủ.
    // Giả sử rằng thời gian lấy dữ liệu từ máy chủ là 2s
    setTimeout(function () {
        let data = 'Dữ liệu từ máy chủ'; // Giả sử dữ liệu đã được trả về từ máy chủ
        callback(data); // Gọi lại hàm callback và truyền dữ liệu vào nó. callback ở đây chính là handleData()
    }, 2000); // Đợi 2 giây trước khi gọi lại hàm callback
}

// Định nghĩa một hàm callback
function handleData(data) {
    console.log('Dữ liệu đã được xử lý xong: ' + data);
}

// Lấy dữ liệu từ máy chủ. Gọi fetchData và truyền handleData làm callback
fetchData(handleData);

// Trong khi chờ 2s để lấy dữ liệu từ máy chủ thì chúng ta sẽ thực hiện các công việc khác
console.log('Đang thực hiện các công việc khác trong khi chờ 2s để lấy dữ liệu từ máy chủ...');

