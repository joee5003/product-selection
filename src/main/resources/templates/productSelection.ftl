<!DOCTYPE HTML>
<html>
<head>
    <title>Product Selection</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script src="js/jquery.min.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/productSelection.js"></script>
    <script src="js/basket.js"></script>
    <script>
        $(document).ready( function(){
            $("#errorAlert").hide();
            <#if customerId?? >
                loadProducts( "${customerId}" );
            <#else>
                loadProducts( "" );
            </#if>
            listenForBasketChanges();
        } );
    </script>
</head>
<body>
<div id="errorAlert" class="alert alert-danger" role="alert">
  <strong>Error: </strong> <p id="errorMessage"></p>
</div>
<div id="content" class="container" style="margin-top:15px">
    <div class="row">
        <div class="col-xs-4 card-block">
            <ul class="list-group" >
                <li class='list-group-item'><h4 class='list-group-item-heading'>Sports</h4></li>
                <div id="sports"></div>
            </ul>
        </div>
        <div class="col-xs-4">
            <ul class="list-group" >
                <li class='list-group-item'><h4 class='list-group-item-heading'>News</h4></li>
                <div id="news"></div>
            </ul>
        </div>
        <div class="col-xs-4">
            <ul class="list-group" >
                <li class='list-group-item'><h4 class='list-group-item-heading'>Basket</h4></li>
                <form name="basket" method="post" action="productSelection" >
                    <div id="basket" ></div>
                    <#if customerId?? >
                        <input type="hidden" name="customerId" value="${customerId}" />
                    </#if>
                    <li class='list-group-item'>
                        <button type="submit" id="submitButton" class="btn btn-primary center-block" disabled >Checkout</button>
                    </li>
                </form>
            </ul>
        </div>
    </div>
</div>
</body>
</html>