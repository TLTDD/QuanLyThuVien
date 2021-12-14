<?php
echo 'hahah';
    if(isset($_POST['email'])&&isset($_POST['password'])){
        require_once "conn.php";
        require_once "validate.php";
        $masv = validate($_POST['email']);
        $password = validate($_POST['password']);
        $sql = "select * from bandoc where masv='$masv' and password='$password'";
        echo $sql;
	$result = mysqli_query($connect,$sql);
        if($result->num_rows > 0){
            echo "success" ;
        } else {
            echo "failure";
        }
    }
?>
