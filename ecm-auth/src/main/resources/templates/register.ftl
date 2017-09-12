<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2>Please Register</h2>

<div>
            <div class="two-col" >
                <div class="email" ng-class="{ 'has-error': form.email.$dirty && form.email.$error.required }">
                    <label for="email">EMAIL</label>
                    <input type="email" name="email" id="email"  class="form-control" placeholder="email-id" />
                    <span class="help-block" ng-show="form.email.$dirty && form.email.$error.required" >Email is required</span>

                </div>

                <div class="fullname" ng-class="{ 'has-error': form.fullname.$dirty && form.fullname.$error.required }">
                    <label for="fullname">FULL NAME</label>
                    <input type="text" name="fullname" id="fullname" class="form-control" placeholder="full name"  />
                    <span ng-show="form.fullname.$dirty && form.fullname.$error.required" class="help-block">fullname is required</span>
                </div>
            </div>
            <div class="two-col1" >
                <div class="password" ng-class="{ 'has-error': form.password.$dirty && form.password.$error.required }">
                    <label for="password">PASSWORD</label>
                    <input type="password" name="password" id="password" class="form-control" placeholder="password" />
                    <span ng-show="form.password.$dirty && form.password.$error.required" class="help-block">Password is required</span>
                </div>

              
            </div>
            <div class="two-col2" >
                <div class="company" ng-class="{ 'has-error': form.company.$dirty && form.company.$error.required }">
                    <label for="company">ORGANIZATION</label>
                    <input type="text" name="company" id="company" class="form-control" placeholder="company"/>
                    <span ng-show="form.company.$dirty && form.company.$error.required" class="help-block">Organization is required</span>
                </div>

                <div class="address" style="" ng-class="{ 'has-error': form.address.$dirty && form.address.$error.required }">
                    <label for="address">ADDRESS</label>
                    <input type="text" name="address" id="address" class="form-control" placeholder="address" />
                    <span ng-show="form.address.$dirty && form.address.$error.required" class="help-block">address is required</span>
                </div>
            </div>
            <div class="two-col3">
                <div class="region" style=""  ng-class="{ 'has-error': form.region.$dirty && form.region.$error.required }">

                    <label for="region">REGION</label>
                    <select type= "text" id="region"  class="form-control" style="width: 250px; margin-right: 70%" >
                        <option value="select">--Select Region--</option>
                        <option value="INDIA">INDIA</option>
                        <option value="US">US</option>
                        <option value="GREECE">GREECE</option>
                        <option value="ITALY">ITALY</option>
                        <option value="GERMANY">GERMANY</option>
                        <option value="RUSSIA">RUSSIA</option>
                        <option value="UK">UK</option>
                    </select>

                    <span ng-show="form.region.$dirty && form.region.$error.required" class="help-block">region is required</span>

                </div>
                
            </div>
            

            <div class="submit" align="center" style="margin-right: -90%">
                <button onclick="register()"  class="btn btn-success">SIGNUP</button>
                <a href="#!/login" class="btn btn-link">Cancel</a>
              
            
            </div>
		
        </div>

		
	</div>
	<script
  src="https://code.jquery.com/jquery-2.2.4.min.js"
  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
  crossorigin="anonymous"></script>
  
  <script type="text/javascript">
function register() {

	var obj = {
		username : $("#email").val(),
		password : $("#password").val(),
		fullName : $("#fullname").val(),
		company : $("#company").val(),
		address : $("#address").val(),
		region : $("#region").val()
	}

	$.ajax({
		type : "POST",
		url : "/userauth/postregister",
		data : obj,
		success : function(data) {
			alert("Registration Successful....");
		},
		dataType : "json"
	});

}
  </script
  
  
</body>
</html>
