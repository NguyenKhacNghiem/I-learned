<?php
    $listSupported = array('Courses', 'Animals', 'Countries') ;

    $data = array
    (
        'Courses' => array('Math', 'Physic', 'Chemistry'),
        'Animals' => array('Dog', 'Cat', 'Duck'),
        'Countries' => array('Vietnam', 'Laos', 'Cambodia')
    ) ;

    $name = isset($_POST['name']) ? $_POST['name'] : '' ;
    $list = isset($_POST['list']) ? $_POST['list'] : '' ;

    if(empty($name))
        die("Please specify your name, <a style=\"text-decoration: none\" href=\"post.html\">Return to login page.</a>") ; 
    
    if(empty($list))
        die("$name, please choose a list, <a style=\"text-decoration: none\" href=\"post.html\">Return to login page.</a>") ;
    
    if(!in_array($list, $listSupported))
        die("$name, please choose a valid list, <a style=\"text-decoration: none\" href=\"post.html\">Return to login page.</a>") ;
    
    echo "<p>Hello, $name.</p>\n" ;
    echo "<p>Here is your list.</p>\n" ;

    echo "<ul>\n" ;  
        foreach($data[$list] as $i)
            echo "<li>$i</li>\n" ;
    echo "</ul>\n" ;

    echo "<a style=\"text-decoration: none\" href=\"post.html\">Return to login page.</a>" ;
?>