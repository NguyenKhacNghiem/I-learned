// Class
class Animal {
  // Properties
  String? name;
  int? legs;
  int? age;

  // Constructors
  Animal(String name, int legs, int age) {
    this.name = name;
    this.legs = legs;
    this.age = age;
  }

  // Constructors viết tắt
  Animal.shortForm(this.name, this.legs);

  // Parameterized Constructor: cho phép truyền tham số không phân biệt thứ tự
  Animal.parameterized({String? name, int? legs, int? age}) {
    this.name = name;
    this.legs = legs;
    this.age = age;
  }

  // Parameterized Constructor với giá trị mặc định
  Animal.parameterizedWithDefault({String? name = "No name", int? legs = 0, int? age = 0}) {
    this.name = name;
    this.legs = legs;
    this.age = age;
  }

  // Methods
  void display() {
    print("Name: $name");
    print("Number of legs: $legs");
    print("Age: $age");
  }
}

// Main
void main() {
  Animal a1 = Animal("Tom", 4, 10);
  print(a1); // a1 là 1 object của class Animal nên khi in ra sẽ là Instance of 'Animal'
  a1.display();

  Animal a2 = Animal.shortForm("Jerry", 2);
  a2.display();

  Animal a3 = Animal.parameterized(legs: 2, age: 2, name: "Doraemon");
  a3.display();

  Animal a4 = Animal.parameterizedWithDefault();
  a4.display();
}