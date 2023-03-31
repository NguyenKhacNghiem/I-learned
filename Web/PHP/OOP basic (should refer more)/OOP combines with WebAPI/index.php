<?php
    class SinhVienController 
    {
        private $db;

        // Hàm khởi tạo
        public function __construct()
        {
            $this->db = new mysqli("localhost", "root", "", "studentmanagement");

            if ($this->db->connect_errno) 
                die ("Lỗi: ".$this->db->connect_error);
        }

        // Hàm hủy
        public function __destruct()
        {
            $this->db->close();
        }

        // Hàm lấy dssv
        public function get_list() 
        {
            // Không dùng PreparedStatement vì không có truyền tham số
            $res = $this->db->query("select s.*, c.name as class_name from student s inner join class c on s.class_id=c.id");
            $rows = [];

            while($row = mysqli_fetch_assoc($res)) 
                $rows[] = $row;

            return $rows; // Trả về 1 mảng chứa dssv đã query được
        }

        // Hàm tìm kiếm sv
        public function get_one($mssv)
        {
            // Dùng PreparedStatement do có truyền tham số
            $res = $this->db->prepare("select s.*, c.name as class_name from student s inner join class c on s.class_id=c.id where s.id = ?");
            $res->bind_param("i", $mssv);
            $res->execute();

            $rows = [];
            $result = $res->get_result(); 

            while($row = $result->fetch_assoc()) 
                $rows[] = $row;

            return $rows; // Trả về 1 mảng chứa dssv đã query được
        }

        // Hàm thêm
        public function add()
        {
            // Đọc dữ liệu được client gửi dưới dạng JSON
            $json = file_get_contents('php://input');
            $data = json_decode($json);

            $res = $this->db->prepare("insert into student(name, age, class_id) values(?,?,?)");
            $res->bind_param("sii", $data->name, $data->age, $data->class_id);
            $res->execute();

            return mysqli_affected_rows($this->db); // Trả về số dòng bị ảnh hưởng (>0: success, <=0: fail)
        }

        // Hàm chỉnh sửa
        public function edit()
        {
            // Đọc dữ liệu được client gửi dưới dạng JSON
            $json = file_get_contents('php://input');
            $data = json_decode($json);

            $res = $this->db->prepare("update student set name = ?, age = ?, class_id = ? where id = ?");
            $res->bind_param("siii", $data->name, $data->age, $data->class_id, $data->id);
            $res->execute();

            return mysqli_affected_rows($this->db); // Trả về số dòng bị ảnh hưởng (>0: success, <=0: fail)
        }

        // Hàm xóa
        public function delete($mssv)
        {
            // Dùng PreparedStatement do có truyền tham số
            $res = $this->db->prepare("delete from student where id = ?");
            $res->bind_param("i", $mssv);
            $res->execute();

            return mysqli_affected_rows($this->db); // Trả về số dòng bị ảnh hưởng (>0: success, <=0: fail)
        }
    }

    // Main
    header("Content-Type: application/json; charset=utf-8");
    $sv = new SinhVienController();

    // thêm
    if ($_SERVER["REQUEST_METHOD"] == "POST") 
    {
        $rows_affected = $sv->add();
    
        if ($rows_affected > 0) 
            echo '{"success": true, "message": "Thêm thành công"}';
        else 
            echo '{"success": false, "message": "Thêm thất bại"}';
    }
    //sửa
    else if ($_SERVER["REQUEST_METHOD"] == "PUT") 
    {
        $rows_affected = $sv->edit();
    
        if ($rows_affected > 0) 
            echo '{"success": true, "message": "Cập nhật thành công"}';
        else 
            echo '{"success": false, "message": "Cập nhật thất bại"}';
    }
    // xem ds và tìm kiếm
    else if ($_SERVER["REQUEST_METHOD"] == "GET") 
    {
        // Tìm kiếm
        if (isset($_GET['id']) && !empty($_GET['id']))
        {
            $kq = $sv->get_one($_GET['id']);

            if(count($kq) > 0)    
                echo '{"success": true, "data": ' . json_encode($kq) . '}';
            else
                echo '{"success": false, "data": "Không tìm thấy sinh viên"}';
        }
        // lấy ds toàn bộ sv
        else
        {
            $kq = $sv->get_list();

            if(count($kq) > 0)    
                echo '{"success": true, "data": ' . json_encode($kq) . '}';
            else
                echo '{"success": true, "data": "Danh sách sinh viên hiện đang trống"}';
        }
    }
    //xoá
    else if ($_SERVER["REQUEST_METHOD"] == "DELETE") 
    {
        // Phương thức DELETE dùng $_GET vẫn được
        if (isset($_GET['id']) && !empty($_GET['id']))
        {
            $rows_affected = $sv->delete($_GET['id']);

            if($rows_affected > 0)    
                echo '{"success": true, "data": "Xóa thành công"}';
            else
                echo '{"success": false, "data": "Không tìm thấy sinh viên"}';
        }
        else
            echo '{"success": false, "data": "Dữ liệu bị gửi thiếu"}';
    }
    // Các phương thức khác GET, POST, PUT, DELETE -> không hỗ trợ
    else 
    {
        echo '{"success": false, "message": "Method không hỗ trợ"}';
    }
?>