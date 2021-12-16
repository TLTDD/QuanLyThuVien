<?php
    include_once("connect.php");
    $id = $_POST['id'];
    $hoTen = $_POST['hoTen'];
    $maSV = $_POST['maSV'];
    $lop = $_POST['lop'];
    $ngaySinh = $_POST['ngaySinh'];
    $gioiTinh = $_POST['gioiTinh'];
    $diaChi = $_POST['diaChi'];
    $soDienThoai = $_POST['soDienThoai'];
    $email = $_POST['email'];
    $querry = "INSERT into bandoc values('$id','$hoTen','$maSV','$lop','$ngaySinh','$gioiTinh','$diaChi','$soDienThoai','$email')";           
    $result =mysqli_query($conn, $querry);
    if($result)
    {
        echo "success";
    }
    else echo "error";
?>