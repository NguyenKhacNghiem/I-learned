function login2()
{
    let username = document.getElementById('uname') ;
    let password = document.getElementById('pass') ;

    let usernameValue = username.value.trim() ;
    let passwordValue = password.value.trim() ;

    if(usernameValue === 'admin' && passwordValue === '782002')
        return true ;    
    else
    {
        showError('Invalid username or password !') ;        
        return false ;
    }
}

function showError(message)
{
    let usernameError = document.getElementById('invalid-feedback-username') ;
    let passwordError = document.getElementById('invalid-feedback-password') ;
    let username = document.getElementById('uname') ;
    let password = document.getElementById('pass') ;
    
    username.value = '' ;
    password.value = '' ;
    usernameError.innerHTML = message ;
    passwordError.innerHTML = message ;
    usernameError.style.fontWeight = 'bold' ;
    passwordError.style.fontWeight = 'bold' ;
}

