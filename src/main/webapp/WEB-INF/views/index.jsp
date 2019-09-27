<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>LİSTELER</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="açıklama" />
    <meta name="keywords" content="arama kelimeleri" />
    <meta name="author" content="Enes Tuncay" />





    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="favicon.ico">
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,400italic|Roboto:400,300,700' rel='stylesheet' type='text/css'>
    <!-- Animate -->
    <link rel="stylesheet" href="list/css/animate.css">
    <!-- Icomoon -->
    <link rel="stylesheet" href="list/css/icomoon.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="list/css/bootstrap.css">

    <link rel="stylesheet" href="list/css/style.css">

    <link rel="stylesheet" href="list/custom/index.css">






    <!-- Modernizr JS -->
    <script src="list/js/modernizr-2.6.2.min.js"></script>





</head>
<body>
<div id="fh5co-offcanvas">
    <a href="#" class="fh5co-close-offcanvas js-fh5co-close-offcanvas"><span><i class="icon-cross3"></i> <span>Kapat</span></span></a>
    <div class="fh5co-bio">
        <h2>${user.name} ${user.surname}</h2>
        <ol class="fh5co-social">
            <li><a href="logout">Çıkış</a></li>
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            <li><a href="deleteUser">Hesabı Sil</a></li>
        </ol>

    </div>
</div>





<!-- END #fh5co-offcanvas -->
<header id="fh5co-header">

    <div class="container-fluid">

        <div class="row">
            <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
            <ol class="fh5co-social">
                <li><a href="new"><i class="icon-pencil" style="background-color: white; font-size: 36px " ></i></a></li>
            </ol>
            <div class="col-lg-12 col-md-12 text-center">
                <h1 id="fh5co-logo"><a href="index.html">LİSTELERİM</a></h1>
            </div>

        </div>

    </div>

</header>





<!-- END #fh5co-header -->
<div class="container-fluid">
    <div class="row fh5co-post-entry">
        <div  id="list"></div>
    </div>

</div>





<!-- jQuery -->
<script src="list/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="list/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="list/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="list/js/jquery.waypoints.min.js"></script>
<!-- Main JS -->
<script src="list/js/main.js"></script>

<script src="list/custom/index.js"></script>


</body>
</html>


