let express = require('express')
let app = express();

let hbs = require('express-handlebars')
app.engine('handlebars', hbs.engine({
    defaultLayout: 'main',
    helpers: {
        // using this block function twice (2 for) to create a table
        // create a for-loop from m to n
        for: function(m, n, options) {
            let data = "";

            for(;m<=n;m++) 
                data += options.fn({index: m});
            
            return data;
        }
    } 
}))
app.set('view engine', 'handlebars')

app.get('/', (req, res) => {
    res.render('home') 
})
app.listen(8080)