<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Pretty Style</title>
    
    <link rel="stylesheet" href="App/lib/bootstrap/4.4.1/css/bootstrap.min.css">

    <link rel="stylesheet" href="App/styles/index.css">
    <link rel="stylesheet" href="App/styles/header.css">
    <link rel="stylesheet" href="App/styles/home.css">
    <link rel="stylesheet" href="App/styles/payments-steps.css">
    <link rel="stylesheet" href="App/styles/responsive.css">
  </head>
  <body>
  	<c:import url="App/components/header.jsp" />
  	<div class="container">
	    <!-- <%@ include file="App/components/header.jsp" %> -->
	    <c:import url="App/pages/home.jsp" />
	    <c:import url="App/pages/payments-steps.jsp" />
  	</div>
    <script src="App/lib/jquery/3.4.1/jquery-3.4.1.min.js"></script>
    <script src="App/lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  </body>
</html>
