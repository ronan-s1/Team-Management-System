<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Player</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body>
    <form action="FrontController" method="post" id="form">
        <h2>Add New Player</h2>
        <div class="box">
            
            <div class="p-div">
                <h6>Details:</h6>
                <table class="fields">
                    <tr>
                        <td><input name="firstName" size=15 type="text" placeholder="first name" class="form-control" required/> </td> 
                    </tr>
                    <tr>
                        <td><input name="lastName" size=15 type="text" placeholder="last name" class="form-control" required/> </td> 
                    </tr>
                    <tr>
                        <td><input name="dob" size=15 type="text" placeholder="date of birth" class="form-control" required/> </td> 
                    </tr>
                    <tr>
                        <td><input name="contactNumber" size=15 type="text" placeholder="contact number" class="form-control" required/> </td> 
                    </tr>
                    <tr>
                        <td><input name="email" type="email" size=15 placeholder="email" class="form-control" required/> </td> 
                    </tr>
                </table>
            </div>
            
            
            <div class="s-div">
                <h6>Squads:</h6>
                <table class="table table-hover">
                    <c:forEach var="squads" items="${squads}">
                   
                        <tr>
                            <td>
                                <input class="form-check-input" type="checkbox" name="squadCheckbox" id="${squads.name}" value="${squads.id}">
                                <label for "${squads.name}" class="form-check-label"> ${squads.name}</label>
                            </td>
                        </tr> 
                    </c:forEach>
                    
                    <c:if test="${empty squads}">
                    	<tr class="table-danger">
                            <td style="text-align: center;">
                                <label class="form-check-label">Please create a squad to add players to!</label>
                            </td>
                        </tr> 
                    </c:if>      
                </table>
            </div>

        </div>

        <div class="button-box">  
            <input type="hidden" id="cancel-button" name="action" value="AddPlayer" />
            <input type="submit" value="Add Player" class="btn btn-dark" id="submit-button"/>
            <input value="Cancel" onclick="location.href='/Assignment';" type="button" class="btn btn-danger cancel"/>
        </div>  
    </form>

</body>
</html>

<script>
(function() {
	const form = document.querySelector("#form");
    const checkboxes = form.querySelectorAll("input[type=checkbox]");
    const checkboxLength = checkboxes.length;
    const firstCheckbox = checkboxLength > 0 ? checkboxes[0] : null;

    function init() {
        if (firstCheckbox) {
            for (let i = 0; i < checkboxLength; i++) {
                checkboxes[i].addEventListener("change", checkValidity);
            }

            checkValidity();
        }
    }

    function isChecked() {
        for (let i = 0; i < checkboxLength; i++) {
            if (checkboxes[i].checked) return true;
        }

        return false;
    }

    function checkValidity() {
        const errorMessage = !isChecked() ? "Select a squad!" : "";
        firstCheckbox.setCustomValidity(errorMessage);
    }

    init();
})();
</script>

<style>
    .cancel{
        width: 100px;
        margin-left: 15px;
    }

    h6{
        text-align: center;
    }
    h2{
        margin-top: 30px;
        text-align: center;
    }
	.box{
        margin-top: 40px;
        display: flex;
        justify-content: center;
	}
	
	p{
		font-weight: 800;
	}

    .p-div{
        float: left;
    }
	
	.s-div{
		margin-left: 30px;
		float: left;
	}
	
	.button-box{
        margin-right: 15px;
        display: flex;
        justify-content: center;
	}
    
	body{
		background: #f4f4f4;
	}
	
	.table-hover{
		width: 220px;
		float: left;
	}
	
	.form-control{
		margin-bottom: 6px;
	}
	
	.container{
		margin: auto;
	}
	
	.btn{
		margin-top: 20px;
	}
</style>