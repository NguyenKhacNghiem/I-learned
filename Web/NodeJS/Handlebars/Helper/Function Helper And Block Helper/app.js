let express = require('express')
let app = express()

let hbs = require('express-handlebars')
app.engine('handlebars', hbs.engine({
    defaultLayout: 'main',

    helpers: {
        // Định nghĩa 1 function helper
        formatPrice: function(price) {
            return '$' + price
        },

        // Định nghĩa 1 block helper. "options" là parameter phải đặt ở cuối để nó hiểu đây là 1 block helper
        showTours: function (tours, options) {
            let data = '';

            for (let i = 0; i < tours.length; i++) {
                tours[i].name = '<b>' + tours[i].name + '</b>';
                tours[i].price = '$' + tours[i].price;

                 // options.fn() sẽ trả về 1 chuỗi hiểu được html dựa vào context truyền vào
                data += options.fn(tours[i]);
            }

            return data;
        }
    }
}))
app.set('view engine', 'handlebars')

app.get('/', (req, res) => {
    // Không nên để biến tours ra làm biến toàn cục vì khi đó F5 lại trang sẽ bị lỗi do dữ liệu đã bị các helper thay đổi
    let tours = [
        { name: 'Hood River', price: '99.95' },
        { name: 'Oregon Coast', price: '159.95' }
    ]

    res.render('home', {
        tours: tours
    })
})

app.listen(8080)
