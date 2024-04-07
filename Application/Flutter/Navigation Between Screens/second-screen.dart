import 'package:demo/third-screen.dart';
import 'package:flutter/material.dart';

class SecondScreen extends StatelessWidget {
  late String message;

  SecondScreen(this.message);

  @override
  Widget build(BuildContext context) {
    print("Dữ liệu được gửi từ màn hình trước đó là: $message");

    // Mỗi 1 màn hình được đại diện bởi 1 Scaffold
    return Scaffold(
      appBar: AppBar(
        title: Text("Second Screen"),
        centerTitle: true,
        // Mặc định khi màn hình số 2 được gọi từ màn hình số 1 thì nó sẽ sinh ra 1 nút back tự động. Dùng thuộc tính này nếu như chúng ta không muốn nó tự sinh nút back
        automaticallyImplyLeading: false,
      ),
      body: Container(
        color: Colors.yellow,
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                "Second Screen",
                style: TextStyle(fontSize: 50),
              ),
              ElevatedButton(
                // Quay về màn hình trước đó. Trả 1 dữ liệu về (tất cả dữ liệu trả về phải gói gọn trong 1 tham số thứ 2)
                onPressed: () => Navigator.pop(context, "Hello! I am returned to Second Screen"),
                child: Text("Go to first screen"),
              ),
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        // Truy cập màn hình thứ 3
        onPressed: () => Navigator.push(
          context,
          MaterialPageRoute(
            builder: (ctx) => ThirdScreen(),
          ),
        ),
        child: Icon(Icons.arrow_forward),
      ),
    );
  }
}
