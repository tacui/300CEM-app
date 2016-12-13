<?php
    $con = mysqli_connect("localhost", "id275871_iulian", "remember", "id275871_300cem");
    
    
    $r1 = mysqli_query($con, "SELECT * FROM markers");
    
    $response1 = array();
	
	$response1["success"] = true;  
    $response1["title"] = "Cov Cath";  
    $response1["comment"] = "Lorem Ipsum DOlor Sit Amdsf";  
    $response1["latitude"] = 52.4082598;  
    $response1["longitude"] = -1.5083808;
	
	echo json_encode($response1)
	
    /*$response = array();
    $response["success"] = false;  
	
    while($row = mysqli_fetch_array($r1)){
        $response["success"] = true;  
        $response["name"] = $name;
        $response["age"] = $age;
        $response["username"] = $username;
        $response["password"] = $password;
    }
    
    echo json_encode($response);*/
?>