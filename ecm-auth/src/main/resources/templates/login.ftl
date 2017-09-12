<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<div id="test" class="col-xs-offset-1 col-md-10">

    <div id="test1" class="col-md-6 col-md-offset-9 col-sm-6" align="center">
      	<h3>Ventus</h3>
        <form name = "form" role="form" action="login" method="post">

		<!-- username -->
            <div id = "user" class="form-group">
                <label for="username" style="margin-right:75%">Email</label>
                <input type="email" name="username" id="username" class="form-control" placeholder="email-id" ng-model="username" required/>
                <span ng-show="form.username.$dirty && form.username.$error.required" >email is required</span>
            </div>
         
		 <!-- password-->
            <div id= "pass" class="form-group">
   				<label for="password" style="margin-right:75%" >password</label>
                <input type="password" name="password" id="password" class="form-control" placeholder="password" ng-model="password" required />
                <span ng-show="form.password.$dirty && form.password.$error.required" >Password is required</span>
				<a href="/password_reset" class="label-link" >Forgot password?</a>
            </div>
            <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <!-- SUBMIT BUTTON -->
            <div id=submit  align="center">
                <button type="submit" class="btn btn-success">
                    <span class="glyphicon"></span> Submit!
                </button>

            </div>
            <div align="center">
                <a href="/userauth/register" class="btn btn-link">New Account? <i>SIGNUP</i></a>
            </div>
        </form>
    </div>
</div>

<style>
	form{width: 30%}
    #test1 {
        width: 100%;
        height: 100%;
        margin: 100px;
    }

    #user{
		width:300px;
		font-size:80%;
	
        margin: 30px 0 20px 0;
    }

    #pass{
		width:300px;
		font-size:80%;
        margin: 20px 0 20px 0;
    }

	#submit{
		margin: 20px 0 20px 0;
	}
	
    #imagecontainer {
        margin-left: 70%
    }
</style>
  
</body>
</html>