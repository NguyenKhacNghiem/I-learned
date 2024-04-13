import 'package:flutter/material.dart';

class SecondScreen extends StatelessWidget {
  String message = '';

  SecondScreen({required this.message});

  @override
  Widget build(BuildContext context) {
    // Lấy dữ liệu được gửi qua từ màn hình thứ 1
    print("Dữ liệu được gửi từ màn hình trước đó là: $message");

    // Mỗi 1 màn hình được đại diện bởi 1 Scaffold
    return Scaffold(
      appBar: AppBar(
        title: Text("Second Screen"),
        centerTitle: true,
        // Mặc định khi màn hình số 2 được gọi từ màn hình số 1 thì nó sẽ sinh ra 1 nút back tự động. Dùng thuộc tính này nếu như chúng ta không muốn nó tự sinh nút back
        automaticallyImplyLeading: false,
      ),
      body: Container(
        color: Colors.yellow,
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                "Second Screen",
                style: TextStyle(fontSize: 50),
              ),
              ElevatedButton(
                // Quay về màn hình trước đó.
                onPressed: () => Navigator.pop(context),
                child: Text("Go to first screen"),
              ),
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        // Truy cập màn hình thứ 3
        onPressed: () => Navigator.pushNamed(
          context,
          '/third'
        ),
        child: Icon(Icons.arrow_forward),
      ),
    );
  }
}
