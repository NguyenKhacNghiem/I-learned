let express = require('express')
let app = express()

let hbs = require('express-handlebars')
app.engine('handlebars', hbs.engine({
    defaultLayout: 'main', 
                           
}))
app.set('view engine', 'handlebars')

app.use(express.static(__dirname + '/public'))

app.use(express.json());
app.use(express.urlencoded({extended: false}));

app.get('/', (req, res) => {
    res.render('home', { csrf: 'CSRF token goes here'}) 
})

app.post('/register', (req, res) => {
    console.log('CSRF token (from hidden form field): ' + req.body.csrf)
    console.log('Username (from visible form field): ' + req.body.username)
    console.log('Password (from visible form field): ' + req.body.password)

    res.render('home', {message: "Register Success"})
})

app.listen(8080)
