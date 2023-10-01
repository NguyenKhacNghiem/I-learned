let mongoose = require("mongoose");

mongoose.Promise = global.Promise; // promise của mongo sẽ giống với promise của nodejs
let Schema = mongoose.Schema;

// Khai báo các thuộc tính cho model
let courseSchema = new Schema({
    _id: Schema.Types.ObjectId, // tạo ra id ngẫu nhiên
    title: {
        type: String,
        required: true
    },
    description: {
        type: String,
        required: true
    },
    price: Number,
    available: Boolean
});

// Khai báo các phương thức cho model (ko dùng arrow function vì ko dùng this được)
courseSchema.methods.getPrice = function() {
    return "$" + this.price;
}

let Course = mongoose.model("Course", courseSchema);
module.exports = Course