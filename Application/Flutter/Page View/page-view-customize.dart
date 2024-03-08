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
  final PageController controller = PageController();
  int currentPage = 0;

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
          controller: controller,
          itemCount: 5, // số lượng page
          itemBuilder: (content, index) => createPageItem("Page $index"),
          onPageChanged: (int pageIndex) {
            print("Current page: $pageIndex");
          },
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.arrow_forward),
          onPressed: () {
            currentPage++;

            if (currentPage >= 5) currentPage = 0;

            goToPage(currentPage);
          },
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

  @override
  void dispose() {
    controller.dispose();
    super.dispose();
  }

  void goToPage(int page) {
    controller.animateToPage(
      page,
      duration: Duration(milliseconds: 500), // tốc độ chuyển page
      curve: Curves.ease, // hiệu ứng chuyển page
    );
  }
}
