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

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.get("/", (req, res) => {
    res.render("index");
})

app.post('/upload-file', (req, res) => {
    let form = new multiparty.Form()

    form.parse(req, (error, data, files) => {
        if (error)  
            return res.status(500).send(error.message)

        files.file.forEach(f => { 
            let tempPath = f.path;
            let savePath = __dirname + "/public/uploads/" + f.originalFilename;

            fsx.copy(tempPath, savePath, (err) => {
                if (err) {
                    console.error(err);
                    return res.status(500).send(err.message);
                }
            });
        });

    })
})

app.listen(8080);