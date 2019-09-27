<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>LİSTEM</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="açıklama" />
    <meta name="keywords" content="arama kelimeleri" />
    <meta name="author" content="Enes Tuncay" />





    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="favicon.ico">
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,400italic|Roboto:400,300,700' rel='stylesheet' type='text/css'>
    <!-- Animate -->
    <link rel="stylesheet" href="./../list/css/animate.css">
    <!-- Icomoon -->
    <link rel="stylesheet" href="./../list/css/icomoon.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="./../list/css/bootstrap.css">

    <link rel="stylesheet" href="./../list/css/style.css">

    <link rel="stylesheet" href="./../list/custom/list.css" />




    <!-- Modernizr JS -->
    <script src="js/modernizr-2.6.2.min.js"></script>




</head>
<body>

<input type="text" hidden style="display: none" value="${id}" id="id" />

<div id="fh5co-offcanvas">
    <a href="#" class="fh5co-close-offcanvas js-fh5co-close-offcanvas"><span><i class="icon-cross3"></i> <span>Kapat</span></span></a>
    <div class="fh5co-bio">
        <h2>${user.name} ${user.surname}</h2>
    </div>

</div>





<!-- END #fh5co-offcanvas -->
<header id="fh5co-header">
    <div class="container-fluid">
        <div class="row">

            <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>

            <div class="col-lg-12 col-md-12 text-center">
                <h1 id="fh5co-logo"><a href="${id}">LİSTEM</a></h1>
            </div>

        </div>
    </div>
</header>





<!-- END #fh5co-header -->
<div class="container-fluid">
    <div class="row fh5co-post-entry single-entry">
        <article class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12 col-xs-offset-0">

            <input class ="form form-control" type="text" id="list_title" style="height: 50px; width: 100%;" placeholder="Liste Adı..." disabled="disabled">


            <div class="col-lg-12 col-lg-offset-0 col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-left content-article">
                <div class="row">
                    <div class="col-lg-8 cp-r animate-box">
                        <div class="fh5co-highlight right">
                            <div id="myDIV" class="header">
                                <input type="text" id="myInput" placeholder="Ekle..." disabled="disabled">
                                <span onclick="newElement()" id="addButton" class="addBtn">Ekle</span>
                            </div>

                            <ul id="myUL">

                            </ul>

                        </div>

                    </div>
                    <div class="col-lg-4 animate-box">
                        <div class="fh5co-highlight right">
                            <button class="btn btn-info" style="width: 100%" onclick="update()" id="updateBtn" >GÜNCELLE</button>
                            <br/>   <br>
                            <button class="btn btn-danger" style="width: 100%" onclick="deleteList()" >SİL</button>
                        </div>
                    </div>
                </div>

            </div>
        </article>
    </div>
</div>





<!-- jQuery -->
<script src="./../list/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="./../list/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="./../list/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="./../list/js/jquery.waypoints.min.js"></script>
<!-- Main JS -->
<script src="./../list/js/main.js"></script>

<script src="./../list/custom/list.js"></script>

<script src="./../list/custom/detail.js"></script>

</body>
</html>

