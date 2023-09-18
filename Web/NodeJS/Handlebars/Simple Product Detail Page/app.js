let express = require('express')
let app = express();

let hbs = require('express-handlebars')
app.engine('handlebars', hbs.engine({
    defaultLayout: 'main', 
}))
app.set('view engine', 'handlebars')

app.use(express.static(__dirname + '/public'))

let product = {
    "name": "Iphone 14 Pro Max",
    "price": 1190,
    "desc": "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sunt adipisci perferendis minus voluptate, ratione quo accusantium eaque unde maiores ipsa culpa at nemo aut consectetur iusto debitis quod dolore facilis?Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sunt adipisci perferendis minus voluptate, ratione quo accusantium eaque unde maiores ipsa culpa at nemo aut consectetur iusto debitis quod dolore facilis?",
    "images": ["img1.jpeg", "img2.jpeg", "img3.jpeg"],
    "vars": [ // các biến thể
        {
            "name": "Iphone 14 Pro Max 128GB",
            "price": 790
        },
        {
            "name": "Iphone 14 Pro Max 2568GB",
            "price": 990
        }
    ]
}

app.get('/', (req, res) => {
    res.render('home', {product: product}) 
})
app.listen(8080)