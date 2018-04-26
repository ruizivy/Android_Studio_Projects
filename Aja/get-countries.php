<?php
include 'dbcon.php';

$id = $_GET['id'];

$sql = "SELECT * FROM 
		tblcity ct INNER JOIN tblcountries c
		ON ct.countryID = c.countryID 
		WHERE c.countryID = $id";

$result = mysqli_query($con, $sql);

$data = array();

while($row = mysqli_fetch_assoc($result)) {
	$data[] = $row;
}

echo json_encode($data);

?>

