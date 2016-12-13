<?php
    $con = mysqli_connect("localhost", "id275871_iulian", "remember", "id275871_300cem");
    
    $name = $_POST["name"];
    $username = $_POST["username"];
    $password = $_POST["password"];
    $statement = mysqli_query($con, "INSERT INTO users (uName, username, password) VALUES ('$name', '$username', '$password')");
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>