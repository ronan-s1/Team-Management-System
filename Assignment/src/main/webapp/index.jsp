<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Dashboard</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" box="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	
   	<!--  <input type="submit" onclick="location.href='/Assignment/addPlayer.jsp';" value="add player" class="btn btn-dark"/>-->
   	<form action="FrontController" method="post" class="box">
	    <h2>Dashboard</h2>
	    <div id="success"></div>
	    <input type="hidden" name="action" value="GetSquads" />
	    <input type="submit" value="Add New Player" class="btn btn-dark"/>
	</form>

</body>
</html>

<script>
	document.getElementById('success').innerHTML = localStorage.getItem("success");
	localStorage.setItem("success", "")
</script>

<style>
	.box{
		margin-top: 30px;
        text-align: center;
	}
	
	.success{
        margin: auto;
		margin-top: 20px;
        margin-bottom: 20px;
		width: 300px;
	}

    .btn-dark{
        margin-top: 8px;
    }
	
	body{
		background: #f4f4f4;
	}
</style>