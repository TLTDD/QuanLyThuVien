<?php
    include "connect.php";
    $maSach = $_POST['maSach'];
	$query = "UPDATE chitietmuon SET trangThai='Đã trả' where maSach = '$maSach'";
    if(mysqli_query($conn,$query)){
        echo "success";
    }
    else{
        echo "error";
    }
?>