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
        body: Row(
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            // Default Constructor
            Expanded(
              child: Column(
                children: [
                  Text("Default Constructor"),
                  Expanded(
                    child: ListView(
                      children: items.map((e) => Text(e, textAlign: TextAlign.center)).toList()
                    )
                  )
                ],
              )
            ),

            // Builder Constructor
            Expanded(
              child: Column(
                children: [
                  Text("Builder Constructor"),
                  Expanded(
                    child: ListView.builder(
                      itemBuilder: (context, index) => Text(items[index], textAlign: TextAlign.center),
                      itemCount: items.length, // số phần tử mà ListView hiển thị
                    ),
                  ),
                ],
              )
            ),

            // Separated Constructor
            Expanded(
              child: Column(
                children: [
                  Text("Separated Constructor"),
                  Expanded(
                    child: ListView.separated(
                      itemBuilder: (context, index) => Text(items[index], textAlign: TextAlign.center),
                      separatorBuilder: (context, index) => Divider(height: 1), // tạo ra vạch ngăn cách
                      itemCount: items.length, // số phần tử mà ListView hiển thị
                    ),
                  ),
                ],
              )
            ),

            // ListTile
            Expanded(
              child: Column(
                children: [
                  Text("ListTile"),
                  Expanded(
                    child: ListView(   
                      children: products.map((p) => ListTile(
                        leading: Icon(Icons.apple), // icon ở đầu
                        title: Text(p["name"].toString()),
                        subtitle: Text(p["price"].toString()),
                        onTap: () {
                          // Thông báo cho Flutter biết rằng có Widget đã bị thay đổi trạng thái (màu sắc thay đổi, nội dung thay đổi,...) -> cần cập nhật lại
                          setState(() {
                            p["selected"] = !(p["selected"] as bool);
                          });
                        },
                        trailing: IconButton(onPressed: () {}, icon: Icon(Icons.more_vert)), // icon ở cuối
                        dense: true, // làm cho tổng thể item trông nhỏ hơn
                        contentPadding: EdgeInsets.all(5), // set padding cho các item
                        selected: p["selected"] as bool, // giống toString() nhưng dành cho bool
                      )).toList(),
                    ),
                  )
                ],
              )
            ),

            Expanded(
              child: Column(
                children: [
                  Text("ListTile With Image Leading"),
                  Expanded(
                    child: ListView(   
                      children: products.map((p) => ListTile(
                        leading: CircleAvatar(
                          radius: 30,
                          backgroundImage: NetworkImage("https://randomuser.me/api/portraits/men/1.jpg"),
                        ), // Hình ảnh ở đầu
                        title: Text("Peter"),
                        subtitle: Text("Student"),
                        onTap: () {},
                        trailing: IconButton(onPressed: () {}, icon: Icon(Icons.more_vert)), // icon ở cuối
                        dense: true, // làm cho tổng thể item trông nhỏ hơn
                        contentPadding: EdgeInsets.all(5), // set padding cho các item
                      )).toList(),
                    ),
                  )
                ],
              )
            ),
          ],
        )
      )
    );
  }
}

// generate thay cho vòng lặp để tạo ra
var items = List.generate(50, (index) => "Item ${index + 1}");

var products = List.generate(50, (index) => {
    "name": "Apple",
    "price": "\$1000",
    "selected": false
  }
);