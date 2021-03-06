<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Style/styles.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Rubik" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<div>

	<nav class="navbar navbar-inverse navbar-static-top nav-upper nav1">
  		<div class="container-fluid">
  			<c:choose>
  				<c:when test="${sessionScope.iduser != null}">
  				<form action="Logout" class="navbar-form navbar-right">
      				<input type="submit" class="btn btn-info" value="Logout" onclick = "myFunction2()">
      				<script>
						function myFunction2() {
    					alert("Successfully Logged Out.");
						}
						
					</script>
      			</form>
                </c:when>
                <c:otherwise>
                
                <script type="text/javascript">
                var login_attempts=3;
				function check_form()
				{
				 var name=document.getElementById("uname").value;
				 var pass=document.getElementById("password").value;
				 if(Login==true)
				 {
				  alert("SuccessFully Logged In");
				  document.getElementById("name").value="";
				  document.getElementById("pass").value="";
				 }
				 else
				 {
				  if(login_attempts==0)
				  {
				   alert("No Login Attempts Available");
				  }
				  else
				  {
				   login_attempts=login_attempts-1;
				   alert("Login Failed Now Only "+login_attempts+" Login Attempts Available");
				   if(login_attempts==0)
				   {
				    document.getElementById("uname").disabled=true;
				    document.getElementById("password").disabled=true;
				   }
				  }
				 }
				 
				 return false;
				}	
			</script>
                <form id="signin" class="navbar-form navbar-right" role="form" action="Login" method="post" onsubmit="return check_form(this);" >
                	<div class="input-group">
                    	<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="uname" type="text" class="form-control" name="username" placeholder="username" required>                                        
                    </div>

                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input id="password" type="password" class="form-control" name="password" placeholder ="password" required>                                        
                    </div>
					<button type="submit" class="btn btn-info" onclick ="checkForm()">Login</button>
					
                    <a href = "SignUp.jsp"><button type="button" class="btn btn-info">Sign Up</button></a>    
               	</form>
                </c:otherwise>
    		</c:choose>	
    			
    			<form action="SearchProductServlet" class="navbar-form navbar-left" role="search">
    				<div class="form-group">
						<div class="input-group" id = "searchid">
						<input type="text" class="form-control" placeholder = "Search" name = "name"/>
						</div>
					</div>
				</form>
  		</div>		
</nav>
  	
  			
<nav class="navbar navbar-default nav2">
	<div class="container-fluid">
		  <ul class="nav navbar-nav">
		      <li><a href="Home.jsp">Home</a></li>
		      <li><a href="DisplayProductsServlet?page=Analog">Analog Watches</a></li>
		      <li><a href="DisplayProductsServlet?page=Digital">Digital Watches</a></li>
		      <li><a href="DisplayProductsServlet?page=SmartWatch">Smart Watches</a></li>
		      <c:if test="${sessionScope.username != null}">
		      <li><a href="DisplayProfileServlet">Profile</a></li>
		      
		      </c:if>
		      <c:if test="${sessionScope.cartnum != null}">
		      <li><a href="GetCartProductsServlet">Cart</a></li>
		      </c:if>
		 </ul>
	</div>
</nav>
		
</div>