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
      // Khi app start thì chạy màn hình FirstScreen trước
      home: FirstScreen(), 
    );
  }
}