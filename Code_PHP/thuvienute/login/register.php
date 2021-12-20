<?php
    if(isset($_POST['name'])&&isset($_POST['taikhoan'])&&isset($_POST['password'])){
        require_once "conn.php";
        require_once "validate.php";
        $name =  validate($_POST['name']);
        $taikhoan = validate($_POST['taikhoan']);
        $password = validate($_POST['password']);
        $sql = "insert into taikhoan(id,name,taikhoan,password,maQuyen) values('', '$name', '$taikhoan', '$password',2)";
        if(!$result = mysqli_query($connect,$sql)){
            echo "failure";
        }else {
            echo "success";
        }
    }
?>
