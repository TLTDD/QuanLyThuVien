<?php
    include "connect.php";
    $tenKeSach = $_GET['tenKeSach'];
    $mangsach = array();
    $query = "SELECT * FROM sach WHERE tenKeSach = '$tenKeSach'";
    $data = mysqli_query($conn, $query);
    while ($row = mysqli_fetch_assoc($data)){
        array_push($mangsach,new Sach(
            $row['id'], 
            $row['tenKeSach'],
            $row['tenSach'],
            $row['tenTacGia'],
            $row['nhaXuatBan'],
            $row['ngayXuatBan'],
            $row['ngonNgu'],
            $row['giaSach'],
            $row['soSeries'],
            $row['soLuong'],
            $row['loiTua'],
            $row['hinhAnhSach']));
    }
    echo json_encode($mangsach);
    
    class Sach{
        function __construct($id,$tenKeSach,$tenSach,$tenTacGia,$nhaXuatBan,$ngayXuatBan,$ngonNgu,$giaSach,$soSeries,$soLuong,$loiTua,$hinhAnhSach) {
            $this->id = $id;
            $this->tenKeSach = $tenKeSach;
            $this->tenSach = $tenSach;
            $this->tenTacGia = $tenTacGia;
            $this->nhaXuatBan = $nhaXuatBan;
            $this->ngayXuatBan = $ngayXuatBan;
            $this->ngonNgu = $ngonNgu;
            $this->giaSach = $giaSach;
            $this->soSeries = $soSeries;
            $this->soLuong = $soLuong;
            $this->loiTua = $loiTua;
            $this->hinhAnhSach = $hinhAnhSach;
        }
    }
?>

