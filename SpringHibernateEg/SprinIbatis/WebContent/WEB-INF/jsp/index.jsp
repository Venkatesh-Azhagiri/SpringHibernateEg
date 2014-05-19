<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style type="text/css"> 
	#mydiv {
	    position:absolute;
	    top: 50%;
	    left: 50%;
	    width:30em;
	    height:18em;
	    margin-top: -9em; /*set to a negative number 1/2 of your height*/
	    margin-left: -15em; /*set to a negative number 1/2 of your width*/
	   
	    background-color: #3399FF;
	    -webkit-border-radius:10px; /* for Webkit-Browsers */
		border-radius:10px; /* regular */
	}
	.roundCorners{
	-webkit-border-radius: 10px;
	-moz-border-radius: 5px;
	border-radius: 10px;
	}
	 body { background-image:url(themes/img/YLtO96.png);background-repeat:repeat-x; }
		
</style>
<head>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<script type ="text/javascript">
$(document).ready(function(){
	var status = "${status}";
	if(status == 'failed'){
		$("#error").css("display", "block");
		$("#error").html("Invalid userID/Password. Please try again.");		
	}
});
 function checkValidation(){
	 var userId = document.getElementById("userID").value;
	 var pwd    = document.getElementById("password").value;	 
	 
	 if(userId == '' || pwd == ''){
		 $("#error").css("display", "block");
		 $('#error').css("color", "red");
		 $("#error").html("Please enter the valid userID/Password.");
		 $("#userID").focus();
		 return false;
	 }
	 return true;
 }
</script>
</head>

<body  style ="text-align: center"> 
<!-- bgcolor = "3399FF" -->
	<div id = "mydiv">
		<div id="error" style ="background-color: white; border-radius:10px;"></div>
		<form action = "index.do" method="post" >
			<div style = "padding-top: 78px">				
				<p>	
				<label>UserID</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type = "text" class ="roundCorners" name = "userId" id = "userID" placeholder = "UserID"/><br/><br/>
				<label>Password</label>&nbsp;&nbsp;<input type  = "password" class ="roundCorners" name = "password" id  = "password" placeholder = "Password"/><br/><br/>
				<input type="submit" value="submit" onclick= "return checkValidation();"/>
				</p>
			</div>			
		</form>
	</div>	
</body>
</html>