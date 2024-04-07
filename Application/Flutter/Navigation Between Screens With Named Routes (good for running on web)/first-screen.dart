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
        // Truy cập màn hình thứ 2. Gửi 1 dữ liệu qua (dùng arguments).
        onPressed: () {
          Navigator.pushNamed(
            context,
            '/second',
            arguments: "Hello! I am from First Screen"
          );
        },
        child: Icon(Icons.arrow_forward),
      ),
    );
  }
}
