<%@ page import="java.util.ArrayList"%>
<%@ page import="br.com.sprintters.prettystyle.model.Mark"%>
<%@ page import="br.com.sprintters.prettystyle.service.MarkService"  %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon" />

		<title>Pretty Style - Cadastrar Marca</title>
    
		<link rel="stylesheet" href="../../../lib/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="../../../lib/sweetalert/sweetalert.css">

		<link rel="stylesheet" href="../../../styles/index.css">
		<link rel="stylesheet" href="../../../styles/header.css">
		<link rel="stylesheet" href="../../../styles/footer.css">
		<link rel="stylesheet" href="../../../styles/responsive.css">
    
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>
		<c:import url="../../../components/header.jsp" />
		<div id="main-content" class="container">
			<div class="new-mark-container">
			  	<div class="container">
			  		<div class="col-md-12 header">
			  			<div class="row content">
				  			<div class="title">
				  				<label>Cadastrar novo produto</label>
				  			</div>
				  			<div class="line">
				  				<hr />
				  				<a class="btn btn-sm btn-primary" href="/PrettyStyle/controller.do?path=admin&command=ListMarks">Voltar</a>
				  			</div>
			  			</div>
			  		</div>
			  		<div class="jumbotron main">
			  			<div class="col-md-12 content">
			  				<form id="id-user" action="/PrettyStyle/controller.do?path=marks&command=CreateMark" method="post" name="add-mark">
				  				<div class="row">
				  					<div class="col-md-6">
					  					<label for="name">Nome da marca<span style="color: #ff0000; margin-left: 5px;">*</span></label>
					  					<input class="form-control" id="name" name="name" placeholder="Nome da marca" />
					  				</div>
				  				</div>
					  			<div class="row button-area">
				  					<button type="submit">CADASTRAR</button>
				  				</div>
			  				</form>
			  			</div>
					</div>
			  	</div>
			</div>
 		</div>
 		<c:import url="../../../components/footer.jsp" />
		
		<script src="../../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script src="../../../lib/jquery-validation/jquery.validate.min.js"></script>
		<script src="../../../lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script src="../../../lib/sweetalert/sweetalert.min.js"></script>
		
		<script src="script.js"></script>
	</body>
</html>
