const express = require('express');
const multer = require('multer');
const path = require('path');

const app = express();

// Configure Multer
const storage = multer.diskStorage({
    destination: function (req, file, cb) {
        cb(null, 'uploads/'); // Destination folder for uploaded files
    },
    filename: function (req, file, cb) {
        // Extract product ID from the request body
        const productId = req.body.productId;
        
        // Rename file with product ID and current timestamp
        const filename = `${productId}_${Date.now()}${path.extname(file.originalname)}`;
        cb(null, filename);
    }
});

const upload = multer({ storage: storage });

// Define route for file upload
app.post('/upload', upload.single('file'), (req, res) => {
    // Access file through req.file
    const file = req.file;
    
    // Access other form fields through req.body
    const { name, email } = req.body;
    
    // Access uploaded file through req.file
    res.send('File uploaded successfully');
});

// Start the server
app.listen(3000, () => {
    console.log('Server is running on port 3000');
});
