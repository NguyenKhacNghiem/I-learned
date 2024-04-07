import 'package:demo/second-screen.dart';
import 'package:flutter/material.dart';

class FirstScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // Mỗi 1 màn hình được đại diện bởi 1 Scaffold
    return Scaffold(
      appBar: AppBar(
        title: Text("First Screen"),
        centerTitle: true,
      ),
      body: Container(
        color: Colors.blue,
        child: Center(
          child: Text(
            "First Screen",
            style: TextStyle(fontSize: 50),
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        // Truy cập màn hình thứ 2. Gửi 1 dữ liệu qua (dùng constructor). Do bên màn hình thứ 2 có trả về dữ liệu cho màn hình thứ 1 (màn hình đã gọi nó) nên màn hình thứ 1 phải nhận về dữ liệu
        onPressed: () async {
          String? message = await Navigator.push(
            context,
            MaterialPageRoute(
              builder: (ctx) => SecondScreen("Hello! I am from First Screen"),
            ),
          );

          print("Dữ liệu được trả về từ màn hình đã gọi là: $message");
        },
        child: Icon(Icons.arrow_forward),
      ),
    );
  }
}
