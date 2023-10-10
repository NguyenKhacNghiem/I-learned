const express = require('express');
const multiparty = require('multiparty') 
const fsx = require('fs-extra'); 
const hbs = require('express-handlebars')

const app = express();
app.engine('handlebars', hbs.engine({
    defaultLayout: 'main', 
                           
}))
app.set('view engine', 'handlebars')

app.use(express.static(__dirname + '/public'))

app.get("/", (req, res) => {
    res.render("index");
})

app.post('/upload-file', (req, res) => {
    let form = new multiparty.Form()

    form.parse(req, (error, data, files) => {
        if (error)  
            return res.status(500).send(error.message)
                
        //Validate file: size, name, ...
        // ...

        // Save uploaded files
        files.file.forEach(f => { // file: là name của thẻ input type file gửi lên
            let tempPath = f.path;
            let savePath = __dirname + "/public/uploads/" + f.originalFilename;

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
    })
})

app.listen(8080)