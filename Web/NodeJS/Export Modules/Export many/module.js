// public
function mul(a, b) {
	return a*b
} 

let s = 3 // private của riêng module vì không nằm trong export

// Tạo đối tượng 
module.exports = {
	f1: function(a, b) {return a + b}, // function có tên là f1
	f2: (a, b) => {return a - b}, // arrow function có tên là f2
	total: 10, // biến total có giá trị là 10
	nhan: mul, // hàm mul ở trên nhưng có tên là nhan
}
