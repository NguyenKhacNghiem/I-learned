const socket = io(); // Tạo kết nối đến socket server
let user = prompt('Enter your name: ');

let form = document.getElementById('form');
let input = document.getElementById('input');
let chatBox = document.getElementById('chat-box');

form.addEventListener('submit', (e) => {
    e.preventDefault();
    
    // Gửi dữ liệu lên server dưới dạng event tự đặt tên là on-send
    socket.emit('on-send', {
        user: user,
        input: input.value
    });     

    input.value = '';  
});

// Nhận dữ liệu từ server dưới dạng event tự đặt tên là on-receive
socket.on('on-receive', (data) => {
    let item = document.createElement('li');
    item.textContent = `${data.user}: ${data.input}`;
    chatBox.appendChild(item);
}); 