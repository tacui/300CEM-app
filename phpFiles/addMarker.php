<?php
    $con = mysqli_connect("localhost", "id275871_iulian", "remember", "id275871_300cem");
    
    $title = $_POST["title"];
    $comment = $_POST["comment"];
    $longitude = $_POST["longitude"];
    $latitude = $_POST["latitude"];
    $statement = mysqli_query($con, "INSERT INTO markers (title, comment, longitude, latitude) VALUES ('$title', '$comment', '$longitude', '$latitude')");
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>