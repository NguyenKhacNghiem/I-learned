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
  var scaffoldKey = GlobalKey<ScaffoldState>();

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        key: scaffoldKey,
        appBar: AppBar(
          title: Text("Tabbar"),
          centerTitle: true,
        ),
        drawer: Drawer(
          child: ListView(
            children: [
              DrawerHeader(
                child: Text("Drawer Header"),
                decoration: BoxDecoration(
                  color: Colors.blue,
                ),
              ),
              ListTile(
                title: Text('Item 1'),
                onTap: () {},
              ),
              ListTile(
                title: Text('Item 2'),
                onTap: () {},
              ),
              ListTile(
                title: Text('Close drawer'),
                onTap: () {
                  scaffoldKey.currentState?.closeDrawer();
                },
              ),
            ],
          ),
        ),
        body: Center(
          child: Text("Drawer"),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.open_in_full),
          onPressed: () {
            scaffoldKey.currentState?.openDrawer();
          },
        ),
      ),
      theme: ThemeData(useMaterial3: false),
    );
  }
}
