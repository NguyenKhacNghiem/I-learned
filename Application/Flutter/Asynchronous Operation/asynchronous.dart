// Dùng Future để biến hàm này thành một hàm bất đồng bộ
Future<String> asynchronous() {
  return Future.delayed(Duration(seconds: 3), () => "Hello");
}

void main() async {
  print(asynchronous());  // uncompleted state: Instance of 'Future<String>’
  
  // Dùng await để chờ hàm bất đồng bộ hoàn thành
  print(await asynchronous());  // completed state: Hello
}
