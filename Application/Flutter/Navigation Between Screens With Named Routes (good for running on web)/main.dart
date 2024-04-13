import 'package:flutter/material.dart';
import 'package:demo/not-found.dart';
import 'package:demo/second-screen.dart';
import 'package:demo/third-screen.dart';
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
      onGenerateRoute: (settings) {
        var name = settings.name;
        var args = settings.arguments; // tham số được truyền từ màn hình gốc sang màn hình đích

        switch(name) {  
          case '/':
            return MaterialPageRoute(builder: (ctx) => FirstScreen(), settings: settings);
          case '/second':
            return MaterialPageRoute(builder: (ctx) => SecondScreen(message: args.toString()), settings: settings);
          case '/third':
            return MaterialPageRoute(builder: (ctx) => ThirdScreen(), settings: settings);
          default:
            return MaterialPageRoute(builder: (ctx) => NotFound(), settings: settings);
        }
      },
    );
  }
}