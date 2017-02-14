<html>
<head>
<title>Blog Management</title>
</head>
<body>
	<h2 style="color:red;">Blog Management</h2>
	<h3>New User</h3>
	<form action="users/save" method="GET">
		Name: <input type="text" name="Name" required autofocus /><br><br>
		Password : <input type="password" name="Password" required /><br><br>
		EmailId: <input type="email" name="Emailid" required autofocus /><br><br>
		Role:<input type="text" name="Roleid" required autofocus/><br><br>
		<button type="submit">Submit</button>
	</form>
	<a href="/articles">View Articles</a>
	<br>
	<h3>Login User</h3>
	<form action="/users/login">
		EmailId:&nbsp;&nbsp; <input type="text" name="Emailid" required autofocus /> <br>
		<br>Password : <input type="password" name="password" required  /><br>
		<br><button type="submit">Submit</button>
	</form>
	
</body>
</html>	
