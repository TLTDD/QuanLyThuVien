<?php
    include "connect.php";
    $mangbandoc = array();
    $query = 'SELECT * FROM bandoc';
    $data = mysqli_query($conn, $query);
    while ($row = mysqli_fetch_assoc($data)){
        array_push($mangbandoc,new BanDoc(
                $row['id'],
                $row['hoTen'],
                $row['maSV'],
                $row['lop'],
                $row['ngaySinh'],
                $row['gioiTinh'],
                $row['diaChi'],
                $row['soDienThoai'],
                $row['email']));
    }
    echo json_encode($mangbandoc);
    
    class BanDoc{
        function __construct($id,$hoTen,$maSV,$lop,$ngaySinh,$gioiTinh,$diaChi,$soDienThoai,$email) {
            $this->id = $id;
            $this->hoTen = $hoTen;
            $this->maSV = $maSV;
            $this->lop = $lop;
            $this->ngaySinh = $ngaySinh;
            $this->gioiTinh = $gioiTinh;
            $this->diaChi = $diaChi;
            $this->soDienThoai = $soDienThoai;
            $this->email = $email;
        }
    }
?>

