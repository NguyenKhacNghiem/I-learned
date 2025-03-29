const express = require('express');
const app = express();
const { faker } = require('@faker-js/faker'); // Thư viện hỗ trợ tạo dummy data

app.get('/', (req, res) => {
    for (let i = 0; i < 5; i++) {
        console.log(faker.person.fullName()); 
        console.log(faker.location.city());  
        console.log(faker.phone.number());
        console.log("--------------------")
    }

    res.send('See dummy data in console');
});

app.listen(3000, () => {
    console.log('Visit http://localhost:3000');
});