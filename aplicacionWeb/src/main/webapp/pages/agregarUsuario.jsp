<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Login MCGA</title>
        <link rel="shotcut  icon" href="img/shortcut-icon.ico">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-theme.css">
        <link rel="stylesheet" href="css/modificacion.css">
        <script src="js/bootstrap.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="twitter-bootstrap-v2/docs/assets/js/bootstrap-transition.js"></script>
    </head>
    <body>
        <div class="nvar navbar-inverse navbar-fixed-top"> 
            <div class="container">
                <div class="navbar-header">                    
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Responsive</span>
                        <span class="icon-bar"></span>
                        <span class ="icon-bar"></span>
                        <span class ="icon-bar"></span>
                    </button> 
                    
                    <a class="navbar-brand" href="#">Login</a>                    
                </div>
                <div class="navbar-collapse collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#Usuarios">Usuario</a>
                        </li>
                        <li>
                            <a href="#Grupos">Grupos</a>
                        </li>
                        <li>
                            <a href="#Help">Help</a>
                        </li> 
                    </ul>
                        <form class="navbar-form navbar-right" role="form">
                            <div class="form-group">
                                <input type="text" placeholder="Email" class="form-control-own">
                            </div>
                            <div class="form-group">
                                <input type="text" placeholder="Password" class="form-control">
                            </div>
                            <button type="submit" class="btn btn-success">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        <hr>
        <br>
        <br>
        <br>
        <div class="container">
    <div class="row">
        <form role="form">
            <div class="col-lg-6">
                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Campos requeridos</strong></div>
                <div class="form-group">
                    <label for="InputName">Nombre</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="InputName" id="InputName" placeholder="Ingresar Name" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">Email</label>
                    <div class="input-group">
                        <input type="email" class="form-control" id="InputEmailFirst" name="InputEmail" placeholder="Ingresar Email" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">Confirm Email</label>
                    <div class="input-group">
                        <input type="email" class="form-control" id="InputEmailSecond" name="InputEmail" placeholder="Confirm Email" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
            </div>
        </form>
        <div class="col-lg-5 col-md-push-1">
            <div class="col-md-12">
                <div class="alert alert-success">
                    <strong><span class="glyphicon glyphicon-ok"></span> Success! Message sent.</strong>
                </div>
                <div class="alert alert-danger">
                    <span class="glyphicon glyphicon-remove"></span><strong> Error! Please check all page inputs.</strong>
                </div>
            </div>
        </div>
    </div>
</div>
    </body>
</html>