<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap and bootstrap icons -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
    
    <link rel="stylesheet" href="css/main.css">
    
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@400;700&display=swap"
        rel="stylesheet">
    
    
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
    <title>Register</title>
</head>
<body>
    <section class="title">
            <!-- NAVIGATION BAR -->
            <nav class="navbar navbar-expand-lg navbar-dark ">
                <a class="navbar-brand" href="/index">RIMS</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler"
                    aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarToggler">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="/login">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/register">Register</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </section>
    <form class="form-horizontal" id="registerForm" action="#">
        <fieldset>
    
            <!-- Form Name -->
            <legend>Register</legend>
    
            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="emailinput">Email</label>
                <div class="col-md-4">
                    <input id="emailinput" name="emailinput" type="text" placeholder="name@email.com"
                        class="form-control input-md">
                    <span class="help-block">help</span>
                </div>
            </div>
    
            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="usernameimput">UserName</label>
                <div class="col-md-4">
                    <input id="usernameinput" name="usernameinput" type="text" placeholder="username" class="form-control input-md">
                    <span class="help-block">help</span>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="firstnameimput">First Name</label>
                <div class="col-md-4">
                    <input id="firstnameinput" name="firstnameinput" type="text" placeholder="first name" class="form-control input-md">
                    <span class="help-block">help</span>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="lastnameimput">Last Name</label>
                <div class="col-md-4">
                    <input id="lastnameinput" name="lastnameinput" type="text" placeholder="last name" class="form-control input-md">
                    <span class="help-block">help</span>
                </div>
            </div>
    
            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="passwordinput">Password</label>
                <div class="col-md-4">
                    <input id="passwordinput1" name="passwordinput" type="password" placeholder="######"
                        class="form-control input-md">
                    <span class="help-block">help</span>
                </div>
            </div>
            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="passwordinput2">Re-Enter Password</label>
                <div class="col-md-4">
                    <input id="passwordinput2" name="passwordinput" type="password" placeholder="######"
                        class="form-control input-md">
                    <span class="help-block">help</span>
                </div>
            </div>
            <!-- ADMIN Toggle -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="custom-switch">Admin settings</label>
                <div class="col-md-4 form-check form-switch">
                    <input class="form-toggle-input" type="checkbox" id="admincheckbox">
                    <label class="form-check-label" for="admincheckbox">Check to register as Admin</label>
                </div>  
            </div>
            <!-- ADMIN Password input-->
            <div class="form-group" id="admininputs">
                <label class="col-md-4 control-label" for="adminpasswordinput">Enter Admin Password</label>
                <div class="col-md-4">
                    <input id="adminpasswordinput" name="adminpasswordinput" type="password" placeholder="######"
                        class="form-control input-md">
                    <span class="help-block">help</span>
                </div>
            </div>
            
    
            <!-- Button (Double) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="button1id">Submit</label>
                <div class="col-md-8">
                    <button id="button1id" name="button1id" class="btn btn-dark" onclick="ValidateUser(document.getElementById('emailinput').value,document.getElementById('usernameinput').value,document.getElementById('passwordinput1').value,document.getElementById('passwordinput2').value)">Register</button>
                    <button id="button2id" name="button2id" class="btn btn-dark">Cancel</button>
                </div>
            </div>
    
        </fieldset>
    </form>
    <script src="/js/email-validation.js"></script>
</body>
</html>