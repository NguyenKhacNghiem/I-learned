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
        body: Container(
          width: 300,
          child: Card(
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                ListTile(
                  title: Text("Title"),
                  subtitle: Text("Subtitle"),
                ),
                Image.network('https://randomuser.me/api/portraits/men/1.jpg'),
                ButtonBar(
                  children: [
                    TextButton(onPressed: () {}, child: Text("Button 1")),
                    ElevatedButton(onPressed: () {}, child: Text("Button 2")),
                  ],
                )
              ],
            ),
          ),
        )
      )
    );
  }
}