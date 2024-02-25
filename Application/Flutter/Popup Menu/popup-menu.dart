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
        appBar: AppBar(
          title: Text("Popup Menu"),
          centerTitle: true,
          leading: IconButton(onPressed: () {}, icon: Icon(Icons.arrow_back)),
          actions: [
            PopupMenuButton<String>(
              // Các option trong PopupMenu
              itemBuilder: (context) => [
                PopupMenuItem(
                  child: Text("Option 1"), 
                  value: "Option 1", 
                  onTap: () {print('Tap option 1');},
                ),

                // Linh hoạt giá trị của option dựa theo biểu thức điều kiện
                PopupMenuItem(
                  child: Text("Block" == "Block" ? "Unblock" : "Block") , 
                  value: "Block" == "Block" ? "Unblock" : "Block", 
                  onTap: () {print('Tap option Block/Unblock');},
                ),
                
                // Dùng if để hiển thị option dựa theo 1 điều kiện nào đó
                if("Admin" == "Admin") 
                  PopupMenuItem(
                    child: Text("Option for admin"), 
                    value: "Option for admin", 
                    onTap: () {print('Tap option for admin');},
                  ),
                
                // Hiển thị vạch chia
                PopupMenuDivider(),

                // Customize option
                PopupMenuItem(
                  child: ListTile(leading: Icon(Icons.delete), title: Text("Delete"),),
                  value: "Option delete",
                  onTap: () {print('Tap option delete');},
                ),
              ],
              onSelected: (option) {print('Selected option: $option');}, // khi người dùng select 1 option bất kỳ trên PopupMenu
              icon: Icon(Icons.more_vert), // Icon đại diện cho PopupMenu
              enabled: true, // enable hoặc disable PopupMenu
            )
          ],
        ),
        body: Container(
          width: 300,
          height: 300,
          color: Colors.green,
          child: Center(
            child: Text(
              "Hello World",
              style: TextStyle(
                fontSize: 30
              ),
            )
          )
        )
      )
    );
  }
}