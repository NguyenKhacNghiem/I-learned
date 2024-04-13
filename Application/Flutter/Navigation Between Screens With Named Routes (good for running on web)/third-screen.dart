import 'package:flutter/material.dart';

class ThirdScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // Mỗi 1 màn hình được đại diện bởi 1 Scaffold
    return Scaffold(
      appBar: AppBar(
        title: Text("Third Screen"),
        centerTitle: true,
      ),
      body: Container(
        color: Colors.green,
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                "Third Screen",
                style: TextStyle(fontSize: 50),
              ),
              ElevatedButton(
                // Quay về màn hình cụ thể
                onPressed: () => Navigator.popUntil(
                  context,
                  ModalRoute.withName('/'), // '/' là màn hình hiện đầu tiên
                ),
                child: Text("Go to first screen"),
              )
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        // Quay về màn hình trước đó
        onPressed: () => Navigator.pop(context),
        child: Icon(Icons.arrow_back),
      ),
    );
  }
}
