<?php
    include_once("connect.php");
    $id = $_POST['id'];
    $maPM = $_POST['maPM'];
    $tenSach = $_POST['tenSach'];
    $maSach = $_POST['maSach'];
    $ngayMuon = $_POST['ngayMuon'];
    $ngayHetHan = $_POST['ngayHetHan'];
    $trangThai = $_POST['trangThai'];
    $querry = "INSERT into chitietmuon values('$id','$maPM','$tenSach','$maSach','$ngayMuon','$ngayHetHan','$trangThai')";           
    $result =mysqli_query($conn, $querry);  
    if($result)
    {
        echo "success";
    }
    else echo "error";
?>