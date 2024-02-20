void main() {
  int a = 12;
  int b = 0;
  int res;

  // Đoạn code nghi ngờ có lỗi
  try {
    res = a ~/ b;
  }
  // Nếu exception là UnsupportedError
  on UnsupportedError {
    print('Cannot divide by zero');
  } 
  // Nếu exception khác UnsupportedError
  catch (ex) {
    print(ex);
  } 
  // Luôn chạy
  finally {
    print('Finally block always executed');
  }
}
