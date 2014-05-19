<script type="text/javascript">
$(".login-form").submit(function(){	
	  parent.fancyBoxClose();	  
	});
</script>
<div style="width:700px;margin-left:2%;">
	<h2>Add Employee</h2>
	<form  method="post" action="add_employee.do" class = "login-form" style = "align:center;margin-left:6%;">
    <label class= "">
        <span class= "">First Name :</span>
        <input id="name" class= "" type="text" name="firstName" placeholder="First Name" />
    </label><br/>
   
    <label class= "">
         <span class= "">Last Name :</span>
        <input id="name" class= "" type="text" name="lastName" placeholder="First Name" />
    </label><br/>
   
    <label class= "">
        <span class= "">Salary :</span>
        <input id="name" class= "" type="text" name="salary" placeholder="Salary" />
    </label><br/>
     <label class= "">
         <span class= "">Street :</span>
        <input id="name" class= "" type="text" name="street" placeholder="Street" />
    </label><br/>    
     <label class= "">
        <span class= "">City :</span>
        <input id="name" class= "" type="text" name="city" placeholder="City" />
    </label><br/>
     <label class= "">
        <span class= "">State :</span>
        <input id="name" class= "" type="text" name="state" placeholder="State" />
    </label><br/>
     <label class= "">
        <span class= "">Country :</span>
        <input id="name" class= "" type="text" name="country" placeholder="Country" />
    </label><br/>
      <input type="submit" value="Submit" />      
</form>
</div>