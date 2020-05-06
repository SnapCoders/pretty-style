<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<header id="main-header">
	<div class="top-header">
		<div class="logo-area" onclick="window.location.href='/PrettyStyle/index.jsp';">
			<img src="/PrettyStyle/App/assets/logos/pretty-style-logo-light.svg" alt="Logo Pretty style">
		</div>
		<div class="search-area">
			<input type="text" placeholder="O que você deseja pesquisar?">
			<img src="/PrettyStyle/App/assets/icons/search.svg">
		</div>
		<div class="search-area-responsive" style="display: none;"></div>
		<div class="client-area">
			<c:if test="${not empty isProvider}">
				<div class="admin" onclick="window.location.href='/PrettyStyle/App/pages/admin/admin.jsp';">
					<div class="admin-icon">
						<img src="/PrettyStyle/App/assets/icons/framework.svg">
					</div>
					<strong>Gerenciar</strong>
				</div>
			</c:if>
			<div class="account" onmouseover="handleShowModal();" onmouseleave="handleHideModalTimeOut();">
				<div class="account-icon">
					<img src="/PrettyStyle/App/assets/icons/home.svg">
				</div>
				<strong>
					<c:if test="${empty token}">
						Entrar
					</c:if>
					<c:if test="${not empty token}">
						${name}
					</c:if>
				</strong>
				<!-- <strong onclick="handleShowModal();">Minha conta</strong> -->
				<img style="display: none;" class="bottom-arrow" src="/PrettyStyle/App/assets/icons/arrow-down.svg">
				<div id="login-modal" class="login-modal inactive" onmouseleave="handleHideModal();" onmouseover="handleFocusModal();">
					<div class="actions">
						<c:if test="${empty token}">
							<button type="button" class="login-button" onclick="window.location.href='/PrettyStyle/App/pages/sign-in/sign-in.jsp'">ENTRAR</button>
							<button type="button" class="create-account-button" onclick="window.location.href='/PrettyStyle/App/pages/sign-up-simple/sign-up-simple.jsp'">CRIAR CONTA</button>
						</c:if>
						<c:if test="${not empty token}">
							<button type="button" class="logout-account-button" onclick="handleLogout();">SAIR</button>
						</c:if>
					</div>
					<c:if test="${not empty token}">
						<hr />
						<div class="pages">
							<button id="id-user" type="button" onclick="window.location.href='/PrettyStyle/App/pages/edit-profile/edit-profile.jsp'">Minha conta</button>
							<button id="id-user" type="button" onclick="window.location.href='/PrettyStyle/controller.do?path=request&command=ListRequests'">Meus Pedidos</button>
						</div>
					</c:if>
				</div>
			</div>
			<div class="favorite">
				<div id="id-user" class="favorite-icon" onclick="window.location.href='/PrettyStyle/controller.do?path=favorites&command=ListFavorites'">
					<img src="/PrettyStyle/App/assets/icons/heart.svg">
				</div>
			</div>
			<div class="cart">
				<div id="id-user" class="cart-icon" onclick="window.location.href='/PrettyStyle/controller.do?path=cart&command=ListCart'">
					<img src="/PrettyStyle/App/assets/icons/cart.svg">
				</div>
			</div>
		</div>
	</div>
	<div id="bottom-header" class="bottom-header">
		<nav>
			<ul>
				<li class="active">SALES</li>
				<li onclick="window.location.href='/PrettyStyle/controller.do?path=catalog&command=ListByCategory&filter='">NOVIDADES</li>
				<!-- <li onclick="window.location.href='/PrettyStyle/App/pages/save-address/save-address.jsp'">CRIAR ENDEREÇO</li>
				<li id="id-user" onclick="window.location.href='/PrettyStyle/controller.do?path=address&command=ListAddress'">MEUS ENDEREÇOS</li>
				<li onclick="window.location.href='/PrettyStyle/App/pages/catalog/catalog.jsp'">CATÁLOGO</li> -->
				<li onclick="window.location.href='/PrettyStyle/controller.do?path=catalog&command=ListByCategory'">ACESSÓRIOS</li>
		        <li onclick="window.location.href='/PrettyStyle/controller.do?path=catalog&command=ListByCategory'">MASCULINO</li>
		        <li onclick="window.location.href='/PrettyStyle/controller.do?path=catalog&command=ListByCategory'">FEMININO</li>
		        <li onclick="window.location.href='/PrettyStyle/controller.do?path=catalog&command=ListByCategory'">PETS</li>
			</ul>
		</nav>
	</div>
</header>
<script src="/PrettyStyle/App/lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
<script src="/PrettyStyle/App/lib/sweetalert/sweetalert.min.js"></script>
<script src="/PrettyStyle/App/js/general.js"></script>
