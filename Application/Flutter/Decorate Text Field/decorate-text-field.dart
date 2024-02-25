import 'package:flutter/material.dart';

// Appbar
var appBar = AppBar(
  title: Text("Flutter Appbar"),
);

// Body
var textFieldNotDecoration = TextField(
  maxLength: 10,
  maxLines: 1,
  readOnly: false,
  textAlign: TextAlign.center,
);

var textFieldDecoration = TextField(
  decoration: InputDecoration(
    border: OutlineInputBorder(
      borderRadius: BorderRadius.circular(8),
    ),
    labelText: "Name:"
  ),
  maxLength: 10,
  maxLines: 1,
  readOnly: false,
  textAlign: TextAlign.center,
);

// Column cho phép tạo ra 1 layout theo chiều dọc để chứa cả 2 TextField
var body = Column(
  mainAxisAlignment: MainAxisAlignment.center,
  children: [
    textFieldNotDecoration,
    SizedBox(height: 10), // Sử dụng SizedBox để tạo khoảng cách giữa hai TextField
    textFieldDecoration,
  ],
);

// FLoating button
var btn = FloatingActionButton(
  onPressed: () => {}, // sự kiện click
  child: Icon(Icons.add), // nội dung bên trong button
);

// add 3 above to Scaffold
var scaffold = Scaffold(
  appBar: appBar,
  body: body,
  floatingActionButton: btn,
);

// use Scaffold in MaterialApp at homepage
var app = MaterialApp(home: scaffold);

void main() {
  runApp(app);
}