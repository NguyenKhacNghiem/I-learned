let express = require('express')
let app = express()
let multiparty = require('multiparty') // đối tượng hỗ trợ việc xử lý upload file
// let fs = require('fs')
let fsx = require('fs-extra'); // đối tượng hỗ trợ việc xử lý upload file

let hbs = require('express-handlebars')
app.engine('handlebars', hbs.engine({
    defaultLayout: 'main', 
                           
}))
app.set('view engine', 'handlebars')

app.use(express.static(__dirname + '/public'))

app.get('/', (req, res) => {
    res.render('home') 
})

app.post('/upload-file', (req, res) => {
    let form = new multiparty.Form()

    form.parse(req, (error, data, files) => {
        if (error)  
            return res.status(500).send(error.message)
        
        console.log('data: ', data) // dữ liệu trong các thẻ input != file
        console.log('files: ', files) // dữ liệu file
        
        // Validate file: size, name, ...
        // ...

        // Save uploaded files
        files.file.forEach(f => { // file: là name của thẻ input type file gửi lên
            let tempPath = f.path;
            let savePath = __dirname + "/upload/" + f.originalFilename;

            // rename dùng để move file nhưng sẽ bị lỗi khi move khác phân vùng
            // fs.rename(tempPath, savePath, function (err) {
            //     if (err)
            //         throw err;
            // })

            fsx.copy(tempPath, savePath, (err) => {
                if (err) {
                    console.error(err);
                    return res.status(500).send(err.message);
                }
            });
        });

        res.render('home', {message: "Upload Success"})
    })
})

app.listen(8080)
