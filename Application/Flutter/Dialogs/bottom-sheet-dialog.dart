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
  var _message = "Bottom Sheet Dialog";
  var _selected = "A";
  var _options = ["A", "B", "C", "D"];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Bottom SheetDialog"),
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
          showModalBottomSheet(
            context: context,
            builder: (ctx) => Wrap(
              children: _options.map((o) => ListTile(
                onTap: () {
                  setState(() {
                    _selected = o;
                    _message = _selected;
                  });

                  print("Người dùng đã chọn: $_selected");
                  Navigator.pop(context);
                },
                title: Text(o),
                trailing: o == _selected ? Icon(Icons.check) : null,
              )).toList(),
            ),
          );
        },
        child: Icon(Icons.settings),
      ),
    );
  }
}
