let express = require('express')
let app = express()

let tours = [
    { id: 0, name: 'Hood River', price: 99.99 },
    { id: 1, name: 'Oregon Coast', price: 149.95 },
]

// Middle ware hỗ trợ lấy dữ liệu được gửi từ request dưới dạng JSON
app.use(express.json());   
// Middle ware hỗ trợ lấy dữ liệu được gửi từ request dưới dạng URL-Encoded
app.use(express.urlencoded({ extended: true }));

// GET API: lấy thông tin của tất cả các tour
app.get('/api/tours', (req, res) => {
    if(tours.length === 0)
        return res.status(404).json({data: 'The tour list is empty'});

    res.json(tours)
})

// GET API: lấy thông tin của 1 tour dựa vào id (search)
app.get('/api/tour/:id', (req, res) => {
    let id = parseInt(req.params.id);
    let tour = tours.find(i => i.id === id);

    if(!tour)
        return res.status(404).json({error: 'No such tour exists'});
    
    res.json(tour);
})

// POST API: thêm 1 tour
app.post('/api/tour/add', (req, res) => {
    if(!req.body.name || !req.body.price)
        return res.status(404).json({error: 'Missing name or price'});
    
    let id = 0;
    if(tours.length > 0)
        id = tours[tours.length - 1].id + 1; // chỗ này phải tạo ID tự tăng trong db
    
    let name = req.body.name;
    let price = req.body.price;

    let tour = {id: id, name: name, price: price};
    tours.splice(tours.length, 0, tour); // tính từ vị trí tours.length xóa 0 phần tử và thêm phần tử tour vào

    res.json({ success: true })
})

// PUT API: chỉnh sửa 1 tour. ":id" là Path Variable
app.put('/api/tour/:id', (req, res) => {
    let id = parseInt(req.params.id) ; // lấy id từ Path Variable
    let tour = tours.find(i => i.id === id)

    if(!tour) 
        return res.status(404).json({ error: 'No such tour exists' })

    // lấy ra giá trị từ biến "name" được gửi từ request (dưới dạng json hay url-encoded đều được)
    if(req.body.name) 
        tour.name = req.body.name

    // lấy ra giá trị từ biến "price" được gửi từ request (dưới dạng json hay url-encoded đều được)
    if(req.body.price) 
        tour.price = req.body.price

    res.json({ success: true })
})

// DELETE API: xóa 1 tour. ":id" là Path Variable
app.delete('/api/tour/:id', (req, res) => {
    let id = parseInt(req.params.id) ; // lấy id từ Path Variable
    let tourIndex = tours.findIndex(i => i.id === id)

    if(tourIndex < 0) 
        return res.json({ error: 'No such tour exists.' })

    tours.splice(tourIndex, 1) // tính từ vị trí tourIndex ta sẽ loại bỏ 1 phần tử

    res.json({ success: true })
})

// Middle ware custom 404 error
app.use((req, res) => {
    res.status(404) 
    res.render('404')
})

// Middle ware custom 500 error
app.use((err, req, res, next) => {
    console.error(err.message) 
    res.status(500)
    res.render('500')
})

// Tạo server trên cổng 8080
app.listen(8080)
