<?php
    include "connect.php";
    $query = "SELECT * FROM chitietmuon, bandoc where bandoc.id = chitietmuon.maPM";
    $data = mysqli_query($conn, $query);
    $mangphieumuon = array();
    while ($row = mysqli_fetch_assoc($data)){

        array_push($mangphieumuon,new PhieuMuon(
                $row['hoTen'],
                $row['maSV'],
                $row['lop'],
                $row['tenSach'],
                $row['maSach'],
                $row['ngayMuon'],
                $row['ngayHetHan'],
                $row['trangThai']));
    }
    echo json_encode($mangphieumuon);
    
    class PhieuMuon{
        function __construct($hoTen,$maSV,$lop,$tenSach,$maSach,$ngayMuon,$ngayHetHan,$trangThai) {
            $this->hoTen = $hoTen;
            $this->maSV = $maSV;
            $this->lop = $lop;
            $this->tenSach = $tenSach;
            $this->maSach = $maSach;
            $this->ngayMuon = $ngayMuon;
            $this->ngayHetHan = $ngayHetHan;
            $this->trangThai = $trangThai;
        }
    }
?>

