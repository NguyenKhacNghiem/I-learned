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
  var _message = "Single Choice Item Dialog";
  var _selected = "A";
  var _options = ["A", "B", "C", "D"];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Single Choice Item Dialog"),
        centerTitle: true,
      ),
      body: Center(
        child: Text(
          _message,
          style: TextStyle(
            fontSize: 30,
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          // Hàm showDialog() hiện 1 màn hình mới đè lên trên màn hình hiện tại
          showDialog(
            context: context,
            // StatefulBuilder giúp tạo ra 1 Widget mới có trạng thái Stateful
            builder: (ctx) => StatefulBuilder(
              builder: (ctx, setState2) => AlertDialog(
                title: Text("Question"),
                content: Column(
                  mainAxisSize: MainAxisSize.min,
                  children: _options
                      .map(
                        (o) => RadioListTile(
                          title: Text(o), // cái label kế bên radio button
                          value: o, // giá trị hiện tại của từng lừa chọn
                          groupValue: _selected, // giá trị chọn sẵn ban đầu
                          onChanged: (value) => setState2(
                            () => _selected = value!,
                          ),
                        ),
                      )
                      .toList(),
                ),
                actions: [
                  TextButton(
                    onPressed: () {
                      Navigator.pop(context);
                      print("Người dùng đã chọn: $_selected");
                      setState(() => _message = _selected);
                    },
                    child: Text("OK"),
                  ),
                  TextButton(
                    onPressed: () {
                      Navigator.pop(context);
                    },
                    child: Text("Cancel"),
                  )
                ],
              ),
            ),
          );
        },
        child: Icon(Icons.settings),
      ),
    );
  }
}
