import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

// Widget cha
class MyApp extends StatefulWidget {
  State<MyApp> createState() => MyStatefulApp();
}

class MyStatefulApp extends State<MyApp> {
  // Key để gán cho widget
  GlobalKey<_MyContainerWidgetState> _key = GlobalKey<_MyContainerWidgetState>();

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: GestureDetector(
          onTap: () => _key.currentState?.updateState(), // gọi phương thức bên trong Widget thông qua key
          child: MyContainerWidget(key: _key), // gắn key cho widget cần update
        ),
      ),
    );
  }
}

// Widget cần update
class MyContainerWidget extends StatefulWidget {
  MyContainerWidget({Key? key}) : super(key: key);

  @override
  _MyContainerWidgetState createState() => _MyContainerWidgetState();
}

class _MyContainerWidgetState extends State<MyContainerWidget> {
  var _color = Colors.blue;

  void updateState() {
    setState(() {
      if (_color == Colors.blue)
        _color = Colors.red;
      else
        _color = Colors.blue;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 300,
      height: 300,
      color: _color,
    );
  }
}
