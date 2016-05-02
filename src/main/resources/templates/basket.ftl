<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Product Selection</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script src="js/jquery.min.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="margin-top:15px">
    <h2>Confirmation</h2>
    <h3>Products</h3>
    <ul>
        <#list products as product>
            <li>${product}</li>
        </#list>
    </ul>
    <br/>
    <b>CustomerID: ${customerId}</b>
</div>
</body>
</html>