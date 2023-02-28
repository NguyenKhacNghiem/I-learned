let select = document.getElementById('imageList')
let index = 0
let show
displayImage(index)

function changeImage()
{
    index = select.selectedIndex
    console.log(index)
    displayImage(index)
}

function handleOutOfIndex()
{
    if(index === -1)
        index = select.options.length - 1
    if(index === select.options.length)
        index = 0
}

function back()
{
    index--
    handleOutOfIndex()
    displayImage(index)
}

function next()
{
    index++
    handleOutOfIndex()
    displayImage(index)
}

function displayImage(index)
{
    let img = document.getElementsByTagName('img')[0]
    let p = document.getElementsByTagName('p')[0]
    let imgName = select.options[index].value

    img.setAttribute('src', 'images/' + imgName)
    p.innerHTML = imgName + ' (' + (index + 1) + '/' + select.options.length + ')'
    select.value = imgName
}

function start()
{
    index++
    handleOutOfIndex()
    displayImage(index)
}

function stop()
{
    let buttons = document.getElementsByTagName('button')

    buttons[0].removeAttribute('disabled')
    buttons[1].innerHTML = 'Start slideshow'
    buttons[1].setAttribute('onclick', 'slideShow()')
    buttons[2].removeAttribute('disabled')

    clearInterval(show)
}

function slideShow()
{  
    let buttons = document.getElementsByTagName('button')

    buttons[0].setAttribute('disabled', null)
    buttons[1].innerHTML = 'Stop slideshow'
    buttons[1].setAttribute('onclick', 'stop()')
    buttons[2].setAttribute('disabled', null)

    show = setInterval(start, 1000)  
}

