let express = require('express')
let app = express()

let hbs = require('express-handlebars')
app.engine('handlebars', hbs.engine({
    defaultLayout: 'main',
}))
app.set('view engine', 'handlebars')

let currency = {
    name: 'United States dollars',
    abbrev: 'USD'
}

let tours = [
    { name: 'Hood River', price: '99.95' },
    { name: 'Oregon Coast', price: '159.95' }
]

let specialsUrl = '/january-specials'

let currencies = ['USD', 'GBP', 'BTC']

app.get('/', (req, res) => {
    res.render('home', {currency: currency, 
                        tours: tours, 
                        specialsUrl: specialsUrl, 
                        currencies: currencies})
})

app.listen(8080)
