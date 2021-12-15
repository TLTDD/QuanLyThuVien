<?php
    include_once("connect.php");
    $id = $_POST['id'];
    $idKeSach = $_POST['idKeSach'];
    $tenSach = $_POST['tenSach'];
    $tenTacGia = $_POST['tenTacGia'];
    $nhaXuatBan = $_POST['nhaXuatBan'];
    $ngayXuatBan = $_POST['ngayXuatBan'];
    $ngonNgu = $_POST['ngonNgu'];
    $giaSach = $_POST['giaSach'];
    $soSeries = $_POST['soSeries'];
    $soLuong = $_POST['soLuong'];
    $loiTua = $_POST['loiTua'];
    $hinhAnhSach = $_POST['hinhAnhSach'];
    $querry = "INSERT into sach values('$id','$idKeSach','$tenSach','$tenTacGia','$nhaXuatBan','$ngayXuatBan','$ngonNgu','$giaSach','$soSeries','$soLuong','$loiTua','$hinhAnhSach')";           
    $result =mysqli_query($conn, $querry);
    if($result)
    {
        echo "success";
    }
    else echo "error";
?>