import 'package:flutter/material.dart';

void main() {
  runApp(MainApp());
}

class MainApp extends StatefulWidget {
  const MainApp({super.key});

  @override
  State<MainApp> createState() => _MainAppState();
}

class _MainAppState extends State<MainApp> with SingleTickerProviderStateMixin {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text("Page View"),
          centerTitle: true,
        ),
        body: PageView.builder(
          itemCount: 10,
          itemBuilder: (content, index) => createPageItem("Page $index"),
        ),
      ),
      theme: ThemeData(useMaterial3: false),
    );
  }

  createPageItem(String label) {
    return Container(
      alignment: Alignment.center,
      child: Text(label),
      color: Colors.grey,
    );
  }
}
