<?php
    include "connect.php";
    $idBD = $_POST['id'];
    $query = "DELETE FROM bandoc where id='$idBD'";
    
    if(mysqli_query($conn,$query)){
        echo "success";
    }
    else{
        echo "error";
    }
?>