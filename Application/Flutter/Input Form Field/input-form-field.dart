import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  // Khai báo 1 key gắn vào form để control form đó
  var _key = GlobalKey<FormState>();

  // Khai báo các biến chứa dữ liệu của các input field sau khi submit
  String? _fullname;
  String? _email;
  int? _age;
  String? _country = "Vietnam";
  String? _password;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text("Basic Form"),
          centerTitle: true,
        ),
        body: SingleChildScrollView(
          child: Padding(
            padding: EdgeInsets.all(10),
            child: Form(
              key: _key, // gắn key vào form
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text(
                    "User Registration",
                    style: TextStyle(
                      color: Colors.blue,
                      fontSize: 50,
                    ),
                  ),
                  SizedBox(
                    height: 15,
                  ),
                  TextFormField(
                    keyboardType: TextInputType.name,
                    onSaved: (value) {
                      _fullname = value ?? "";
                    },
                    validator: (value) {
                      if (value == null || value.length <= 0)
                        return "Please enter your name";
          
                      return null; // hợp lệ!
                    },
                    decoration: InputDecoration(
                      labelText: "Full Name",
                      border: OutlineInputBorder(),
                      prefixIcon: Icon(Icons.contact_mail),
                      hintText: "Enter your name",
                    ),
                  ),
                  SizedBox(
                    height: 15,
                  ),
                  TextFormField(
                    onSaved: (value) {
                      _email = value ?? "";
                    },
                    validator: (value) {
                      if (value == null || value.length <= 0)
                        return "Please enter your email";
          
                      if (!value.contains("@"))
                        return "This is not a valid email";
          
                      return null; // hợp lệ!
                    },
                    keyboardType: TextInputType.emailAddress,
                    decoration: InputDecoration(
                      labelText: "Email",
                      border: OutlineInputBorder(),
                      prefixIcon: Icon(Icons.email),
                      hintText: "Email",
                    ),
                  ),
                  SizedBox(
                    height: 15,
                  ),
                  TextFormField(
                    onSaved: (value) {
                      _age = value != null ? int.parse(value) : 0;
                    },
                    validator: (value) {
                      if (value == null || value.length <= 0)
                        return "Please enter your age";
          
                      if (int.parse(value) < 16 || int.parse(value) > 99)
                        return "Your age must be between 16 and 99";
          
                      return null; // hợp lệ!
                    },
                    keyboardType: TextInputType.number,
                    decoration: InputDecoration(
                      labelText: "Age",
                      border: OutlineInputBorder(),
                      prefixIcon: Icon(Icons.hail_sharp),
                      hintText: "18",
                    ),
                  ),
                  SizedBox(
                    height: 15,
                  ),
                  DropdownButtonFormField<String>(
                    decoration: InputDecoration(
                      border: OutlineInputBorder(),
                      prefixIcon: Icon(Icons.house),
                    ),
                    hint: Text('Choose a country'),
                    value: _country,
                    onChanged: (String? newValue) {
                      setState(() {
                        _country = newValue!;
                      });
                    },
                    onSaved: (value) {
                      _country = value ?? "Vietnam";
                    },
                    items: <String>['Vietnam', 'Laos', 'Campodia', 'Thailand']
                        .map<DropdownMenuItem<String>>((String value) {
                      return DropdownMenuItem<String>(
                        value: value,
                        child: Text(value),
                      );
                    }).toList(),
                  ),
                  SizedBox(
                    height: 15,
                  ),
                  TextFormField(
                    onSaved: (value) {
                      _password = value ?? "";
                    },
                    validator: (value) {
                      if (value == null || value.length < 6)
                        return "Password must contain at least 6 characters";
          
                      return null; // hợp lệ!
                    },
                    obscureText: true,
                    decoration: InputDecoration(
                      labelText: "Password",
                      border: OutlineInputBorder(),
                      prefixIcon: Icon(Icons.password),
                      hintText: "Password",
                    ),
                  ),
                  SizedBox(
                    height: 15,
                  ),
                  ElevatedButton(
                    onPressed: _handleSubmit,
                    child: Text("Register"),
                    style: ElevatedButton.styleFrom(
                      minimumSize:
                          Size.fromHeight(55), // height là 55 còn width là full
                    ),
                  )
                ],
              ),
            ),
          ),
        ),
      ),
      theme: ThemeData(
        useMaterial3: false,
      ),
    );
  }

  void _handleSubmit() {
    // Khi validate() được gọi thì tất cả các thuộc tình validate của các input field sẽ được chạy. Phương thức này trả về true khi các thuộc tính validate của các field kia trả về null
    if (_key.currentState?.validate() ?? false) {
      // Khi save() được gọi thì tất cả các thuộc tình onSaved của các input field sẽ được chạy. Từ đó dữ liệu mà người dùng đã nhập sẽ được lưu lại trong các biến đã cho trước
      _key.currentState?.save();

      // In các giá trị hợp lệ ra console
      print("Fullname: $_fullname");
      print("Email: $_email");
      print("Age: $_age");
      print("Country: $_country");
      print("Password: $_password");
    } else {
      print("Invalid form!");
    }
  }
}
