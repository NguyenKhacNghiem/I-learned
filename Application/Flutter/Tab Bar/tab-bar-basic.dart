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
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: DefaultTabController(
        length: 3, // số lượng tab
        child: Scaffold(
          appBar: AppBar(
            title: Text("Tabbar"),
            centerTitle: true,
            bottom: TabBar(tabs: const [
              Tab(text: 'Bike', icon: Icon(Icons.directions_bike),), 
              Tab(text: 'Train', icon: Icon(Icons.directions_train),), 
              Tab(text: 'Bus', icon: Icon(Icons.directions_bus),),
            ]),
          ),
          body: TabBarView(children: [ // phần body bên trong mỗi tab
            createTabBarView("Bike"),
            createTabBarView("Train"),
            createTabBarView("Bus"),
          ],)
        ),
      ),
      theme: ThemeData(useMaterial3: false),
    );
  }

  Widget createTabBarView(String label) { 
    return Container( 
      alignment: Alignment.center, 
      child: Text(
        label, 
        style: const TextStyle(fontSize: 36)
      )
    );
  }
}