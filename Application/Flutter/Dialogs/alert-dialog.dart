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
  var _message = "Alert Dialog";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Alert Dialog"),
        centerTitle: true,
      ),
      body: Center(
        child: Text(
          _message,
          style: TextStyle(
            fontSize: 50,
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () async {
          // Hàm showDialog() hiện 1 màn hình mới đè lên trên màn hình hiện tại
          var _value = await showDialog(
            context: context,
            // AlertDialog() là Dialog dùng để confirm
            builder: (ctx) => AlertDialog(
              title: Text("Delete Product"),
              content: Text("Do you want to delete this product?"),
              actions: [
                TextButton(
                  onPressed: () {
                    Navigator.pop(context, "Yes");
                  },
                  child: Text("Yes"),
                ),
                TextButton(
                  onPressed: () {
                    Navigator.pop(context, "No");
                  },
                  child: Text("No"),
                )
              ],
            ),
            // barrierDismissible: false, // khi click bên ngoài thì dialog sẽ không biến mất
            // barrierColor: Colors.green.withOpacity(0.5), // màu nền bên ngoài của dialog
          );

          print("Người dùng đã chọn: $_value");
          setState(() => _message = _value);
        },
        child: Icon(Icons.settings),
      ),
    );
  }
}
