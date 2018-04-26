<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link href="Bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
</head>

<body>

<br />
<br />
<div class="row">
<div class="col-md-6 col-lg-6">
<form id="frmRegister">

	<label for="txtUName" > User Name </label>
	<input type="text" id="txtUName" name="txtuname" class="form-control" placeholder="Enter username" required />
	<br />
	<label for="txtEmail" > Email </label>
	<input type="text" id="txtEmail" name="txtemail" class="form-control"  placeholder="Enter email" required />
	<br />
	<label for="txtPassword" > Password </label>
	<input type="password" id="txtPassword" name="txtpwd" class="form-control"  placeholder="Password" required />
	

	<br />
	<button type="submit" class="btn btn-primary pull-right">Register</button>

</form>
	<button type="button" id="show">Show Password</button>
</div>
</div>





<script src="Bootstrap/js/jquery-3.2.1.min.js"></script>
<script src="Bootstrap/js/bootstrap.js"></script>
<script src="Bootstrap/js/jquery.validate.min.js"></script>
<script src="myevents.js"></script>
<script src="validate-form.js"></script>
</body>
</html>