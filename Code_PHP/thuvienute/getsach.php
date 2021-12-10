<?php
    include "connect.php";
    $mangsach = array();
    $query = 'SELECT * FROM sach';
    $data = mysqli_query($conn, $query);
    while ($row = mysqli_fetch_assoc($data)){
        array_push($mangsach,new Sach(
                $row['id'],
                $row['idKeSach'],
                $row['tenSach'],
                $row['tenTacGia'],
                $row['nhaXuatBan'],
                $row['ngayXuatBan'],
                $row['ngonNgu'],
                $row['giaSach'],
                $row['soSeries'],
                $row['soLuong'],
                $row['loiTua'],
                $row['hinhAnhSach'],));
    }
    echo json_encode($mangsach);
    
    class Sach{
        function __construct($id,$idKeSach,$tenSach,$tenTacGia,$nhaXuatBan,$ngayXuatBan,$ngonNgu,$giaSach,$soSeries,$soLuong,$loiTua,$hinhAnhSach) {
            $this->id = $id;
            $this->idKeSach = $idKeSach;
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

