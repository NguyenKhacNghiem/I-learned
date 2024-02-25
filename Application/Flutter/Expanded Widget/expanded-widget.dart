import 'package:flutter/material.dart';

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text("Flutter"),
          centerTitle: true,
          backgroundColor: Colors.lightBlue,
        ),
        body: Padding(
          padding: EdgeInsets.all(10),
          child: Column(
          children: [
            // Có height là 100
            Container(
              child: Text("Height 100"),
              height: 100,
              alignment: Alignment.center,
              decoration: BoxDecoration(
                color: Colors.green,
                border: Border.all(width: 10, color: Colors.black)
              ),
            ),

            // Lấp đầy không gian trống của cha
            Expanded(
              flex: 2, // so với những Expanded khác thì cái này lấp đầy đến 2 lần
              child: Container(
                child: Text("Expanded"),
                alignment: Alignment.center,
                decoration: BoxDecoration(
                  color: Colors.pink,
                  border: Border(
                    left: BorderSide(width: 10, color: Colors.blue),
                    right: BorderSide(width: 10, color: Colors.blue)
                  )
                ),
              ),
            ),

            // Lấp đầy không gian trống của cha
            Expanded(
              child: Container(
                child: Text("Expanded"),
                alignment: Alignment.center,
                color: Colors.purple,
              ),
            ),
          ],
        ),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.add),
          onPressed: () => {print("Clicked")},
        ),
      ),
    );
  }
}

void main() {
  runApp(MyApp());
}
