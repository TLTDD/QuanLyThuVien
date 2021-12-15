<?php
    include "connect.php";
    $json = $_POST['json'];
    $data = json_decode($json,true);
    foreach ($data as $value ){
        $maPM = $value['maPM'];
        $maSach = $value['maSach'];
        $tensanpham = $value['tenSanPham'];
        $ngayMuon = $value['ngayMuon'];
        $soluongsanpham = $value['ngayHetHan'];
        $trangThai = "Đang mượn";
        $tr
        $query = "INSERT INTO chitietmuon(id,maPM,maSach,tenSanPham,ngayMuon,ngayHetHan,trangThai)"
                . "VALUE(null,'$maPM','$maSach','$tensanpham','$ngayMuon','$ngayHetHan',$trangThai)";
        $Dta = mysqli_query($conn, $query);
    }
    if($Dta){
        echo "1";
    }
    else {
        echo "0";
    }
?>