<?php
    include "connect.php";
    $maSach = $_POST['maSach'];
    $query = "DELETE FROM chitietmuon where maSach = '$maSach'";
    
    if(mysqli_query($conn,$query)){
        echo "success";
    }
    else{
        echo "error";
    }
?>