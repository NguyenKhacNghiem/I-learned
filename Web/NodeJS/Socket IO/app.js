const express = require('express');
const app = express();  

const http = require('http');
const server = http.createServer(app);

const {Server} = require('socket.io');
const io = new Server(server);

app.use(express.static(__dirname));

app.get('/', (req, res) => {
  res.sendFile(__dirname + '/index.html');
})

// Khi có kết nối đến server
io.on('connection', (socket) => {
    console.log('A user connected');

    socket.on('on-send', (data) => {
        console.log(`${data.user}: ${data.input}`);

        // Gửi dữ liệu cho tất cả các client
        io.emit('on-receive', data); 
    })

    // Khi mất kết nối
    socket.on('disconnect', () => {
        console.log('A user disconnected');
    })
})

// Handle 404
app.use((req, res) => {
  res.status(404).send('404 ERROR');
})

// Handle 500
app.use((err, req, res, next) => {
    console.error(err.message);
    res.status(500).send('500 ERROR. See console for details');
})

server.listen(3000, () => {
  console.log('Visit http://localhost:3000');
})