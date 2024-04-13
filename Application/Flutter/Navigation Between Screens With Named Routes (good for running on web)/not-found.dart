import 'package:flutter/material.dart';

class NotFound extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Not Found"),
        centerTitle: true,
      ),
      body: Container(
        color: Colors.red,
        child: Center(
          child: Text(
            "Not Found",
            style: TextStyle(fontSize: 50),
          ),
        ),
      ),
    );
  }
}