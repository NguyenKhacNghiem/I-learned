// tham số role có giá trị mặc định là user nếu nó không được truyền
void f1(String name, String gender, [String role = "user"]) {
  print("f1: Hello $role $name, your gender is $gender");
}

// tham số name có giá trị mặc định là Anna và gender có giá trị mặc định là Female nếu nó không được truyền
void f2({String name = "Anna", String gender = "Female"}) {
  print("f2: Hello $name, your gender is $gender");
}

// giống f2() nhưng không cần giá trị mặc định vì đã có required (bắt buộc truyền)
void f3({required String name, required String gender}) {
  print("f3: Hello $name, your gender is $gender");
}

void main() {
  f1("Peter", "Male");
  f1("Peter", "Male", "admin");

  // các tham số đặt trong dấu {} nên bắt buộc phải chỉ định tên khi truyền (không cần đúng thứ tự)
  f2(name: "Peter", gender: "Male"); 
  f2();

  // các tham số đặt trong dấu {} nên bắt buộc phải chỉ định tên khi truyền (không cần đúng thứ tự)
  f3(name: "Peter", gender: "Male"); 
  // f3(); // báo lỗi do có required
}