<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Login</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">ISO Management System</a>
       
      </nav><br><br>
    <div class="container">
        <h1 class="h3 mb-3 font-weight-normal">Log in</h1>
        <h5>${requestScope.msg}</h5>
    <form action="/ISO/Login" method="POST">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">E-mail: </label>
            <div class="col-sm-5">
                <input type="text" class="form-control" name="email" required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password: </label>
            <div class="col-sm-5">
            <input type="password" class="form-control" name="pass" required>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Role: </label>
            <div class="col-sm-5">
            <select class="form-control" name="role">
                <option class="dropdown-item" value="Admin">Admin</option>
                <option class="dropdown-item" value="Faculty">Faculty</option>
                <option class="dropdown-item" value="HOD">HOD</option>
                <option class="dropdown-item" value="Coordinator">Coordinator</option>
            </select>
            </div>
        </div>
        <br>
            <button type="submit" class="btn btn-primary">Submit</button> 
    </form>
    
    </div>
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>