import 'package:flutter/material.dart';

void main() {
  runApp(MainApp());
}

class MainApp extends StatefulWidget {
  const MainApp({super.key});

  @override
  State<MainApp> createState() => _MainAppState();
}

class _MainAppState extends State<MainApp> with SingleTickerProviderStateMixin{
  late TabController controller = TabController(length: 3, vsync: this);
  
  @override
  Widget build(BuildContext context) {
    controller.addListener(() {
      if (!controller.indexIsChanging) {
        print(controller.index);
      }
    });
    
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text("Tabbar"),
          centerTitle: true,
          bottom: TabBar(
            controller: controller,
            tabs: const [
              Tab(text: 'Bike', icon: Icon(Icons.directions_bike),), 
              Tab(text: 'Train', icon: Icon(Icons.directions_train),), 
              Tab(text: 'Bus', icon: Icon(Icons.directions_bus),),
            ]),
        ),
        body: TabBarView(
          controller: controller,
          children: [ // phần body bên trong mỗi tab
            createTabBarView("Bike"),
            createTabBarView("Train"),
            createTabBarView("Bus"),
          ],),
        floatingActionButton: FloatingActionButton( 
          onPressed: () => changeTab(0),  // nhấn vào FAB thì quay lại tab 0
          child: Icon(Icons.directions_bike),
        )
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

  @override
  void dispose() { 
    controller.dispose(); 
    super.dispose();
  }

  void changeTab(int index) { 
    controller.animateTo(index);
  }
}
