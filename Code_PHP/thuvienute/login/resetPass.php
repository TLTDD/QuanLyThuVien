<?php
    if(isset($_POST['taiKhoan'])&&isset($_POST['NewPass'])){
        require_once "conn.php";
        require_once "validate.php";
        $id = validate($_POST['taiKhoan']);
        $passNew = validate($_POST['NewPass']);
        $passOld = validate($_POST['OldPass']);
        $sql = "select password from taikhoan where taiKhoan='$id' and password='$passOld'";
	    $result = mysqli_query($connect,$sql);
        if($result->num_rows > 0){
            $sql = "UPDATE  taikhoan set taikhoan.password = $passNew where taiKhoan = '$id'";
            $result = mysqli_query($connect,$sql);
            echo "success" ;
        } else {
            echo "failure";
        }
    }
?>