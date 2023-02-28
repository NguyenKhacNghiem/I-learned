function add()
{
    let fn = document.getElementById('firstname') ;
    let ln = document.getElementById('lastname') ;
    let em = document.getElementById('email') ;
    let body = document.getElementById('table-body') ;

    let firstName = fn.value ;
    let lastName = ln.value ;
    let email = em.value ;
    
    // Tạo thẻ
    let tr = document.createElement('tr') ;
    let td1 = document.createElement('td') ;
    let td2 = document.createElement('td') ;
    let td3 = document.createElement('td') ;
    let td4 = document.createElement('td') ;
    let btn = document.createElement('button') ;
    btn.className = 'btn btn-danger' ;
    
    td1.innerHTML = firstName ;
    td2.innerHTML = lastName ;
    td3.innerHTML = email ;
    
    btn.innerHTML = 'Delete' ;
    btn.setAttribute('onclick', 'deleteRow(this)') ;
    
    // Sắp xếp thứ tự thẻ con và thẻ cha
    td4.append(btn) ;
    tr.append(td1) ;
    tr.append(td2) ;
    tr.append(td3) ;
    tr.append(td4) ;
    body.append(tr) ;

    // Xóa những dòng dữ liệu cũ
    fn.value = '' ;
    ln.value = '' ;
    em.value = '' ;

    // Đưa con trỏ chuột nhấp nháy tại vị trí mới
    fn.focus() ;
}

function deleteRow(btn)
{   
    // tìm ngược lên thẻ cha
    let td = btn.parentElement ;
    let tr = td.parentElement ;

    tr.remove() ;
}