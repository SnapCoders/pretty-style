<%@ page import="java.util.ArrayList"%>
<%@ page import="br.com.sprintters.prettystyle.model.Product"%>
<%@ page import="br.com.sprintters.prettystyle.service.ProductService"  %>

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

		<title>Pretty Style - Gerenciar</title>
    
		<link rel="stylesheet" href="../../../lib/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="../../../lib/datatables/datatables.min.css">

		<link rel="stylesheet" href="../../../styles/index.css">
		<link rel="stylesheet" href="../../../styles/header.css">
    
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>
		<%
  			ProductService ps = new ProductService();
  			
  			request.setAttribute("products", ps.list());
  		%>
  		<% request.getContextPath(); %>
		<c:import url="../../../components/header.jsp" />
		<div class="container">
			<div class="list-products-container">
			  	<div class="container">
			  		<div class="col-md-12 header">
			  			<div class="row content">
				  			<div class="title">
				  				<label>Gerenciamento</label>
				  			</div>
				  			<div class="line">
				  				<hr />
				  				<a class="btn btn-sm btn-primary" href="../new-product/new-product.jsp">Cadastrar</a>
				  				<a class="btn btn-sm btn-outline-primary" href="../admin.jsp">Voltar</a>
				  			</div>
			  			</div>
			  		</div>
			  		<div class="jumbotron main">
			  			<div class="col-md-12 content">
							<table id="tbProducts" class="table table-bordered table-hover">
								<thead class="thead-dark">
									<tr>
										<th scope="col" style="text-align: center;">Id</th>
										<th scope="col" style="text-align: center;">Nome</th>
										<th scope="col" style="text-align: center;">Descrição</th>
										<th scope="col" style="text-align: center;">Preço</th>
										<th scope="col" style="text-align: center;">Ações</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="product" items="${products}">
										<tr>
											<th scope="row">${product.id}</th>
											<td>${product.name}<span class="badge badge-pill badge-primary" style="margin-left: 10px;">50% OFF</span></td>
											<td>${product.description}</td>
											<td><fmt:formatNumber value="${product.price}" type="currency" currencySymbol="R$"/></td>
											<td style="text-align: center;">
												<button class="btn btn-sm btn-outline-primary">Editar</button>
												<button type="submit" class="btn btn-sm btn-outline-danger">
													Excluir
												</button>
												<input type="hidden" name="id" value="${product.id}" />
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
			  			</div>
			  		</div>
			  	</div>
			</div>
		</div>
		<script src="../../../lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script src="../../../lib/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<script src="../../../lib/datatables/datatables.min.js"></script>
		<script src="../../../lib/sweetalert/sweetalert.min.js"></script>
		<script>
			$(document).ready(function () {
				swal({
			        title: "Atenção!",
			        text: "Deseja realmente excluir o registro?",
			        type: "warning",
			        showCancelButton: true,
			        confirmButtonText: "Sim",
			        confirmButtonColor: "#3CB371",
			        cancelButtonText: "N\u00e3o",
			        closeOnConfirm: false,
			        closeOnCancel: true
			    }, function (isConfirm) {
			        if (!isConfirm) return;
			        $.ajax({
			            url: "/products",
			            type: "DELETE",
			            data: {
			                id: id
			            },
			            success: function (data) {
			                if (data.Sucesso == true) {
			                    sweetAlert
			                    ({
			                        title: "Sucesso!",
			                        text: data.Mensagem,
			                        type: "success"
			                    },
			                    function () {
			                        Load();
			                    });
			                }
			                else {
			                    sweetAlert
			                    ({
			                        title: "Erro",
			                        text: "Ocorreu um erro ao deletar o registro!",
			                        type: "error"
			                    });
			                }
			            },
			            error: function (data) {
			                swal("Erro", "Erro ao Deletar o Registro!", "error");
			            }
			        });
			    });
			});
		</script>
	</body>
</html>