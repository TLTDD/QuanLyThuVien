<?php
    if(isset($_POST['taiKhoan'])&&isset($_POST['password'])){
        require_once "conn.php";
        require_once "validate.php";
        $taiKhoan = validate($_POST['taiKhoan']);
        $password = validate($_POST['password']);
        $sql = "select * from taikhoan where taiKhoan='$taiKhoan' and password='$password' and maQuyen=2";
	$result = mysqli_query($connect,$sql);
        if($result->num_rows > 0){
            echo "success" ;
        } else {
            echo "failure";
        }
    }
?>
