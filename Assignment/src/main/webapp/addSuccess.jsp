<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<script>
    localStorage.setItem("success", "<div class='alert alert-success success' role='alert'>Player Added Successfully!</div>");
    location.href='/Assignment';
</script> 
</body>
</html>