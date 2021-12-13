<?php
    include "connect.php";
    $query = "SELECT * FROM kesach";
    $data = mysqli_query($conn, $query);
    $mangkesach = array();
    while($row = mysqli_fetch_assoc($data)){
        array_push($mangkesach, new KeSach(
            $row['id'],
            $row['tenKeSach']));
    }
    echo json_encode($mangkesach);
    class KeSach{
        function __construct ($id, $tenKeSach){
            $this->id = $id;
            $this->tenKeSach = $tenKeSach;
        }
    }
?>