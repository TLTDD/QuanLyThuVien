<?php
     include "connect.php";
     $idUser = $_GET['taiKhoan'];
    class user{
        function __construct($id, $name, $taiKhoan, $password, $soDienThoai, $diaChi, $ngaySinh){
            $this->id = $id;
            $this->name = $name;
            $this ->taiKhoan = $taiKhoan;
            $this ->password = $password;
            $this ->soDienThoai = $soDienThoai;
            $this ->diaChi = $diaChi;
            $this ->ngaySinh = $ngaySinh;
        }
    }
    $userArray = array();
    $query = "SELECT * FROM taikhoan WHERE taiKhoan = '$idUser'";
    $data = mysqli_query($conn, $query);
    while($row = mysqli_fetch_array($data)){
        array_push($userArray,new user(
            $row['id'],
            $row['name'],
            $row['taiKhoan'],
            $row['password'],
            $row['soDienThoai'],
            $row['diaChi'],
            $row['ngaySinh']
          ));
}   
    echo json_encode($userArray);
?>