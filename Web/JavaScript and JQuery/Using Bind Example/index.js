let person = {
 	name:'hue',
 	getName: function(){
 		return this.name
 	}
}
console.log(person.getName()) // this là của person do có dấu () nên hiểu là gọi hàm như bình thường

// Không dùng bind
let getNamePersonNotBind = person.getName // không có () -> gán hàm cho biến -> sau khi gán thì không hiểu this trong hàm là của ai
console.log(getNamePersonNotBind()) // undefined

// Dùng bind
let getNamePersonBind = person.getName.bind(person) // không có () -> gán hàm cho biến -> sau khi gán thì hiểu this trong hàm là của person tại có bind person
console.log(getNamePersonBind()) // hue 