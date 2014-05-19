<%@include file="../include/header.jsp" %>
 <script type = "text/javascript">
	$(document).ready(function() {
		//alert("test");
		$('.fancybox').fancybox({
			 'afterClose':function () {
			        window.location.reload();
			    },
		});
	});
 </script>
    <div id="content" class="box"  style ="background-color:#F0F0F0;width:100%">
	    <div style = "padding-bottom:50%;">
	    <a class="fancybox fancybox.ajax" href="add_employee.do">Add Employee</a>
	    <p><h2>Employee List</h2></p><br/>
		    <div align = "center">          
			    <table width = "50%">
			        <tr>
			        	<th>First Name</th>
			        	<th>Last Name</th>
			        	<th>City</th>
			        	<th>Action</th>
			        </tr>
			        <c:forEach items = "${employeeList}" var = "employee">
			        	<tr>
			        		<td>${employee.firstName}</td>
			        		<td>${employee.lastName}</td>
			        		<td>${employee.employeeDetail.city}</td>
			        		<td><a class="fancybox fancybox.ajax" style = "display:block;" href="edit_employee.do?employeeId=${employee.employeeId}"><img src= "../images/edit.png"/></a></td>
			        	</tr>
			        </c:forEach>
			     </table>
			 </div>
	     </div>
     <!-- <div class="tabs box" >
        <ul>
          <li><a href="#tab01"><span>Tab 1</span></a></li>
          <li><a href="#tab02"><span>Tab 2</span></a></li>
          <li><a href="#tab03"><span>Tab 3</span></a></li>
        </ul>
      </div>
     
    <div id="tab01" style = "padding-bottom:50%;">
        <p>Tab 1</p>
        
        
      </div>      
      <div id="tab02" style = "padding-bottom:50%;">
        <p>Tab 2</p>
      </div>
            
      <div id="tab03" style = "padding-bottom:50%;">
        <p>Tab 3</p>
      </div> 
      -->
     
    </div>
    <!-- /content -->
 <%@include file ="../include/footer.jsp" %>
