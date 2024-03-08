import 'package:flutter/material.dart';

void main() {
  runApp(MainApp());
}

class MainApp extends StatefulWidget {
  const MainApp({super.key});

  @override
  State<MainApp> createState() => _MainAppState();
}

class _MainAppState extends State<MainApp> {
  var items = [
    BottomNavigationBarItem(icon: Icon(Icons.home), label: 'Home'),
    BottomNavigationBarItem(icon: Icon(Icons.book), label: 'Book'),
    BottomNavigationBarItem(icon: Icon(Icons.search), label: 'Search'),
    BottomNavigationBarItem(icon: Icon(Icons.settings), label: 'Settings'),
  ];

  int currentIndex = 0;

  void onItemSelected(int index) {
    setState(() {
      currentIndex = index;
    });

    print(items[index].label);
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text("Bottom Navigation Bar"),
          centerTitle: true,
        ),
        body: Center(
          child: Text('Hello World!'),
        ),
        bottomNavigationBar: BottomNavigationBar(
          items: items,
          backgroundColor: Colors.grey,
          selectedItemColor: Colors.blue,
          type: BottomNavigationBarType.fixed,     
          unselectedItemColor: Colors.black,
          selectedLabelStyle: TextStyle(
            fontSize: 20,
            color: Colors.white,
            fontWeight: FontWeight.bold
          ),
          onTap: onItemSelected, // khi click 1 item
          currentIndex: currentIndex, // item đầu tiên được chọn
        ),
      ),
      theme: ThemeData(
        useMaterial3: false,
       ),
    );
  }
}
