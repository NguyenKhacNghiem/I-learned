let mongoose = require("mongoose");
let Course = require("../models/course");

// add
function createCourse(req, res) {
    let course = new Course({
        _id: new mongoose.Types.ObjectId(), // tạo ra id ngẫu nhiên
        title: req.body.title,
        description: req.body.description,
        price: req.body.price,
        available: req.body.available,
    });

    course.save()
    .then(newCourse => {
        res.status(201);

        res.json({
            success: true,
            message: "New course created successfully",
            Course: newCourse
        });
    })
    .catch(error => {
        console.log(error);
        res.status(500);

        res.json({
            success: false,
            message: "Server error. Please try again.",
            error: error.message
        });
    });
}

// get all
function getAllCourse(req, res) {
    Course.find() // truyền điều kiện vô find nếu có. VD: Course.find({available: true})
        .select("_id title description price available") // chọn những cột muốn lấy ra
        .then(courses => {
            res.status(200)

            res.json({
                success: true,
                message: "A list of all course",
                Course: courses
            });
        })
        .catch(error => {
            res.status(500);

            res.json({
                success: false,
                message: "Server error. Please try again.",
                error: error.message
            });
        });
}

// get one
function getOneCourse(req, res) {
    let id = req.params.courseId;

    Course.findById(id)
        .then(course => {
            console.log(course.getPrice())
            res.status(200);

            res.json({
                success: true,
                message: `More on ${course.title}`,
                Course: course
            });
        })
        .catch(error => {
            res.status(500)

            res.json({
                success: false,
                message: "This course does not exist",
                error: error.message
            });
        });
}

// delete
function deleteCourse(req, res) {
    let id = req.params.courseId;
    
    Course.findByIdAndRemove(id)
        .then(deletedCourse => {
            res.status(200) // nếu để 204 sẽ không thấy kết quả trả về 

            res.json({
                success: true,
                message: "This course has been deleted",
                Course: deletedCourse
            })
        })
        .catch(error => {
            res.status(500)

            res.json({
                success: false,
                message: "This course does not exist",
                error: error.message
            });
        });
}

// update
function updateCourse(req, res) {
    let id = req.params.courseId;
    
    let updateFields = {
        // Update những thuộc tính được set
        $set: {
            title: req.body.title,
            description: req.body.description,
            price: req.body.price,
            available: req.body.available
        },
    };

    Course.findByIdAndUpdate(id, updateFields, { new: true }) // new: true -> sau khi update sẽ trả về course được update. Mặc định thì nó sẽ trả về course trước khi update
    .then(updatedCourse => {
        if (!updatedCourse) {
            res.status(404)

            return res.json({
                success: false,
                message: "Course not found"
            });
        }

        res.status(200);
        res.json({
            success: true,
            message: "Course updated successfully",
            Course: updatedCourse
        });
    })
    .catch(error => {
        res.status(500);

        res.json({
            success: false,
            message: "Server error. Please try again.",
            error: error.message
        });
    });
}

// export các function này ra để gọi
module.exports = {
    createCourse: createCourse,
    getAllCourse: getAllCourse,
    getOneCourse: getOneCourse,
    deleteCourse: deleteCourse,
    updateCourse:updateCourse
}