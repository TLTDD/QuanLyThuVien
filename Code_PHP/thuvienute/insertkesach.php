<?php
    include_once("connect.php");
    $id = $_POST['id'];
    $tenKeSach = $_POST['tenKeSach'];
    $querry = "INSERT into kesach values('$id', '$tenKeSach')";           
    $result =mysqli_query($conn, $querry);
    if($result)
    {
        echo "success";
    }
    else echo "error";
?>