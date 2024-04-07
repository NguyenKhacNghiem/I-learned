import 'package:demo/second-screen.dart';
import 'package:demo/third-screen.dart';
import 'package:flutter/material.dart';
import 'package:demo/first-screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      // Định nghĩa ra các route tương ứng với mỗi màn hình để có thể chạy tốt trên trình duyệt web
      initialRoute: '/', // màn hình mặc định khi app start
      routes: {
        '/': (ctx) => FirstScreen(),
        '/second': (ctx) => SecondScreen(),
        '/third': (ctx) => ThirdScreen()
      }, 
    );
  }
}