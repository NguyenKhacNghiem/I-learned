import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      debugShowCheckedModeBanner: false,
      home: MyApp(),
      theme: ThemeData(
        useMaterial3: false,
      ),
    ),
  );
}

class MyApp extends StatefulWidget {
  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("DateTime Picker"),
        centerTitle: true,
      ),
      body: Center(
        child: Text(
          "DateTime Picker",
          style: TextStyle(
            fontSize: 30,
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () async {
          var _value = await showDatePicker(
            context: context,
            initialDate: DateTime.now(),
            firstDate: DateTime(2000, 04, 14),
            lastDate: DateTime(2050, 04, 14),
          );

          print("Người dùng đã chọn ngày: $_value");
        },
        child: Icon(Icons.settings),
      ),
    );
  }
}
