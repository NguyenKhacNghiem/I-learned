PDFDocument = require('pdfkit');

function createPDF(dataCallback, endCallback) {
    let pdf = new PDFDocument();
    
    pdf.on('data', dataCallback);
    pdf.on('end', endCallback);
    pdf.fontSize(25)
    pdf.text('Hello World', 100, 100);
    
    pdf.end();
}

module.exports = {createPDF};