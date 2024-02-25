import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  State<MyApp> createState() => MyAppState();
}

class MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: GridView.builder( 
          itemCount: 100, // 100 phần tử
          gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
            crossAxisCount: 10, // 10 phần tử trên 1 row
            crossAxisSpacing: 8, // trên cách dưới 10
            mainAxisSpacing: 8, // trái cách phải 10
          ),
          itemBuilder: (context, index) { 
            return Container( 
              color: Colors.greenAccent, 
              child: Center(child: Text("Item ${index+1}")),
            ); 
          }
        )
      )
    );
  }
}