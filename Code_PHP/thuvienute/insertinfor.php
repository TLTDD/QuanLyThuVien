<?php
    include_once("connect.php");
    $id = $_POST['id'];
    $name = $_POST['name'];
    $taiKhoan = $_POST['taiKhoan'];
    $soDienThoai = $_POST['soDienThoai'];
    $diaChi = $_POST['diaChi'];
    $ngaySinh  = $_POST['ngaySinh'];
    $querry = "UPDATE  taikhoan set name ='$name', taiKhoan ='$taiKhoan', 
                        soDienThoai ='$soDienThoai', 
                        diaChi ='$diaChi', 
                        ngaySinh = '$ngaySinh' 
                        where id = ".$id;

    $result =mysqli_query($conn, $querry);
    if($result)
    {
        echo "ok";
    }
?>