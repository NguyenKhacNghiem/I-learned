let express = require("express");
let mongoose = require("mongoose");
let courseController = require("./controllers/course"); // import module
require("dotenv").config(); // package nodemon giúp tự reload server khi có thay đổi trên file

let app = express();
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// Load dữ liệu từ file .env ra
const PORT = process.env.PORT;
const CONNECTION_STRING = process.env.CONNECTION_STRING;

// add
app.post("/api/course/add", (req, res) => {
    courseController.createCourse(req, res);
})

// get all
app.get("/api/courses", (req, res) => {
    courseController.getAllCourse(req, res);
})

// get one
app.get("/api/courses/:courseId", (req, res) => {
    courseController.getOneCourse(req, res);
})

// delete
app.delete("/api/course/delete/:courseId", (req, res) => {
    courseController.deleteCourse(req, res);
})

// update
app.put("/api/course/update/:courseId", (req, res) => {
    courseController.updateCourse(req, res);
})

// Kết nối tới database
mongoose.connect(CONNECTION_STRING, { 
    useNewUrlParser: true, 
    useUnifiedTopology: true 
})
.then(() => {
    console.log('Database connected');
    app.listen(PORT);
})
.catch((error) => {
    console.log('Error connecting to database');
});
