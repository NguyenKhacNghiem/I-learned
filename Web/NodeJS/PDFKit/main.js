PDFDocument = require('pdfkit');

function createPDF(dataCallback, endCallback) {
    let pdf = new PDFDocument();
    
    pdf.on('data', dataCallback); // Mỗi khi có một phần dữ liệu PDF được tạo, nó sẽ gọi hàm dataCallback
    pdf.on('end', endCallback);   // Khi file PDF hoàn thành, hàm endCallback sẽ được gọi.

    pdf.fontSize(25)
    pdf.text('Hello World', 100, 100);
    
    pdf.end();
}

module.exports = {createPDF};
