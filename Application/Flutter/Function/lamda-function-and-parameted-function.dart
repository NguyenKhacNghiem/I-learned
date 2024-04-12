import 'dart:math';

int add(int a, int b) {
  return a+b;
}

// Hàm calculate1() nhận vào tham số là 1 hàm
int calculate1(Function op) {
  int a = Random().nextInt(100);
  int b = Random().nextInt(100);

  print('a = $a, b = $b');

  return op(a, b);
}

// Hàm calculate2() nhận vào tham số là 1 hàm có kiểu dữ liệu trả về và kiểu dữ liệu của đối số
int calculate2(int Function(int, int) op) {
  int a = Random().nextInt(100);
  int b = Random().nextInt(100);

  print('a = $a, b = $b');

  return op(a, b);
}

void main() {
  int r1 = calculate1(add);
  print('R1 = $r1');

  int r2 = calculate2((a, b) => a - b);
  print('R2 = $r2');

  int r3 = calculate2(add);
  print('R3 = $r3');  
}