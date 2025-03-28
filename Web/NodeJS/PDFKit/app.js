const express = require('express');
const app = express();
const pdf = require(__dirname + '/main.js');

app.use(express.json());

app.get('/', (req, res) => {
    let stream = res.writeHead(200, {
        'Content-Type': 'application/pdf',
        'Content-Disposition': 'attachment; filename="my-file.pdf"'
    });

    pdf.createPDF(
        data => stream.write(data), 
        () => stream.end()
    );
});

app.listen(3000, () => console.log('Download pdf file at http://localhost:3000'));