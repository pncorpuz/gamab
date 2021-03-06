<html>
<title>AION Edit Profile</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Style/styles.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<body class = "container-fluid" style="background-color:lightgray;">

<div class="row"><%@ include file="navbar.jsp" %></div></br>

<div class="container" id="wrap">
	<div class="row">
	<div class="panel panel-default">
      	<div class="panel-heading">  
      		<h4 >Edit Profile</h4>
      	</div>
      	<div class="panel-body"> 
		<div class="col-md-6 col-md-offset-3">
		
		
		
			<form action="EditProfileServlet" method="get" accept-charset="utf-8" class="form" role="form" onsubmit="return checkForm(this);">
				<div class="row">
					<div class="col-xs-6 col-md-6">
						<input type="text" name="firstname" value="" class="form-control input-lg" placeholder="First Name" required />
					</div>
					<div class="col-xs-6 col-md-6">
						<input type="text" name="lastname" value=""class="form-control input-lg" placeholder="Last Name" required />
					</div>
				</div></br>
				<input type="text" name="email" value="" class="form-control input-lg" placeholder="Email Address" required /></br> 
				<input type="password" name="new_password" value="" class="form-control input-lg" placeholder="New Password" required />
				*Minimum of 6 characters with at least one number, one lowercase and one uppercase letter</br></br>  
				<input type="password" name="confirm_new_password" value="" class="form-control input-lg" placeholder="Confirm New Password" required /></br>  
				<input type ="text" name = "billing_address" value="" class="form-control input-lg" placeholder="New Billing Address" required /></br> 
				<input type ="text" name = "shipping_address" value="" class="form-control input-lg" placeholder="New Shipping Address" required /> <br>
				<button type="submit" class="btn btn-lg btn-primary signup-btn">Edit Profile</button></a>
				
				
			</form>
		</div>
		</div>
	</div>
</div>

</body>
</html>