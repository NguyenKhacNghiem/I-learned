const express = require('express');
const hbs = require('express-handlebars');

const app = express();

app.engine('handlebars', hbs.engine({
    defaultLayout: 'main',
}))
app.set('view engine', 'handlebars')

// Import module routes chứa các middleware. Chố này có thể có nhiều file routes.
// Ví dụ 1 route dành cho product, 1 route dành cho user,...
require(__dirname + "/routes/myRoute")(app);

app.listen(8080);