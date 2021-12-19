<?php
    include "connect.php";
    $idKe = $_POST['id'];
    $query = "DELETE FROM kesach where id='$idKe'";
    
    if(mysqli_query($conn,$query)){
        echo "success";
    }
    else{
        echo "error";
    }
?>