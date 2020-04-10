<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

    <title>Pretty Style</title>
    
    <link rel="stylesheet" href="lib/bootstrap/4.4.1/css/bootstrap.min.css">

    <link rel="stylesheet" href="styles/global/index.css">
    <link rel="stylesheet" href="styles/global/header.css">
    
    <link rel="stylesheet" href="styles/home.css">
    <link rel="stylesheet" href="styles/sign-in.css">
    <link rel="stylesheet" href="styles/sign-up-simple.css">
    <link rel="stylesheet" href="styles/sign-up-business.css">
    <link rel="stylesheet" href="styles/product-details.css">
    <link rel="stylesheet" href="styles/payments-steps.css">
    <link rel="stylesheet" href="styles/favorites.css">
    <link rel="stylesheet" href="styles/cart.css">
    <link rel="stylesheet" href="styles/thanks.css">
    <link rel="stylesheet" href="styles/profile.css">
    <link rel="stylesheet" href="styles/catalog.css">
    <link rel="stylesheet" href="styles/save-address.css">
    <link rel="stylesheet" href="styles/profile-address.css">
    <link rel="stylesheet" href="styles/requests.css">
    <link rel="stylesheet" href="styles/global/responsive.css">
  </head>
  <body>
  	<c:import url="components/header.jsp" />
  	<div class="container">
	    <c:import url="pages/home.jsp"/>
  	</div>
    <script src="lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
    <script src="lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  </body>
</html>
