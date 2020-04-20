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
			<c:if test="${not empty token}">
				<div class="admin" onclick="window.location.href='/PrettyStyle/App/pages/admin/admin.jsp';">
					<div class="admin-icon">
						<img src="/PrettyStyle/App/assets/icons/framework.svg">
					</div>
					<strong>Gerenciar</strong>
				</div>
			</c:if>
			<div class="account">
				<div class="account-icon">
					<img src="/PrettyStyle/App/assets/icons/home.svg">
				</div>
				<strong onclick="handleShowModal();">Minha conta</strong>
				<img src="/PrettyStyle/App/assets/icons/arrow-down.svg">
				<div id="login-modal" class="login-modal inactive">
					<div class="actions">
						<button type="button" class="login-button" onclick="window.location.href = '/PrettyStyle/App/pages/sign-in/sign-in.jsp'">ENTRAR</button>
						<button type="button" class="create-account-button" onclick="window.location.href = '/PrettyStyle/App/pages/sign-up-simple/sign-up-simple.jsp'">CRIAR CONTA</button>
						<button type="button" class="logout-account-button" onclick="handleLogout();">SAIR</button>
					</div>
					<hr />
					<div class="pages">
						<button type="button" onclick="window.location.href = '/PrettyStyle/App/pages/profile/profile.jsp'">Minha conta</button>
						<button type="button" onclick="window.location.href = '/PrettyStyle/App/pages/requests/requests.jsp'">Meus Pedidos</button>
					</div>
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
	<div class="bottom-header">
		<nav>
			<ul>
				<li class="active">SALES</li>
				<li onclick="window.location.href='/PrettyStyle/App/pages/'">NOVIDADES</li>
				<li onclick="window.location.href='/PrettyStyle/App/pages/edit-profile/edit-profile.jsp'">EDITAR PERFIL</li>
				<li onclick="window.location.href='/PrettyStyle/App/pages/save-address/save-address.jsp'">CRIAR ENDEREÇO</li>
				<li onclick="window.location.href='/PrettyStyle/App/pages/profile-address/profile-address.jsp'">MEUS ENDEREÇOS</li>
				<li onclick="window.location.href='/PrettyStyle/App/pages/requests/requests.jsp'">MEUS PEDIDOS</li>
				<li onclick="window.location.href='/PrettyStyle/App/pages/payment-steps/payment-steps.jsp'">ETAPAS DE PAGAMENTO</li>
				<li onclick="window.location.href='/PrettyStyle/App/pages/catalog/catalog.jsp'">CATÁLOGO</li>
				<!-- <li>ACESSÓRIOS</li>
		        <li>MASCULINO</li>
		        <li>FEMININO</li>
		        <li>PETS</li> -->
			</ul>
		</nav>
	</div>
</header>
<script src="/PrettyStyle/App/lib/jquery/1.9.1/jquery-1.9.1.min.js"></script>
<script src="/PrettyStyle/App/lib/sweetalert/sweetalert.min.js"></script>
<script src="/PrettyStyle/App/js/general.js"></script>
