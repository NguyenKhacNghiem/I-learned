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
  var _message = "Simple Dialog";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Simple Dialog"),
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
            // SimpleDialog() là Dialog đơn giản mục đích chính là dùng để thông báo
            builder: (ctx) => SimpleDialog(
              title: Text("Simple Dialog"),
              children: [
                SimpleDialogOption(
                  child: Text("Option 1"),
                  onPressed: () {
                    // Đóng dialog và trả về value được chọn
                    Navigator.pop(ctx, "Option 1");
                  },
                ),
                SimpleDialogOption(
                  child: Text("Option 2"),
                  onPressed: () {
                    Navigator.pop(ctx, "Option 2");
                  },
                ),
                SimpleDialogOption(
                  child: Text("Option 3"),
                  onPressed: () {
                    Navigator.pop(ctx, "Option 3");
                  },
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
