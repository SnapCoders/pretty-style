<header id="main-header">
  <div class="top-header">
    <div class="logo-area" onclick="window.location.href='<%=request.getContextPath()%>/index.jsp';">
      <img src="<%=request.getContextPath()%>/App/assets/logos/pretty-style-logo-light.svg" alt="Logo Pretty style">
    </div>
    <div class="search-area">
      <input type="text" placeholder="O que você deseja pesquisar?">
      <img src="<%=request.getContextPath()%>/App/assets/icons/search.svg">
    </div>
    <div class="search-area-responsive" style="display: none;">
    </div>
    <div class="client-area">
      <div class="admin" onclick="window.location.href='<%=request.getContextPath()%>/App/pages/admin/admin.jsp';">
        <div class="admin-icon">
          <img src="<%=request.getContextPath()%>/App/assets/icons/framework.svg">
        </div>
        <strong>Gerenciar</strong>
      </div>
      <div class="account">
        <div class="account-icon">
          <img src="<%=request.getContextPath()%>/App/assets/icons/home.svg">
        </div>
        <strong onclick="handleShowModal();">Minha conta</strong>
        <img src="<%=request.getContextPath()%>/App/assets/icons/arrow-down.svg">
        <div id="login-modal" class="login-modal inactive">
        	<div class="actions">
        		<button type="button" class="login-button" onclick="window.location.href = '/PrettyStyle/App/pages/sign-in/sign-in.jsp'">ENTRAR</button>
        		<button type="button" class="create-account-button" onclick="window.location.href = '/PrettyStyle/App/pages/sign-up-simple/sign-up-simple.jsp'">CRIAR CONTA</button>
        	</div>
        	<hr />
        	<div class="pages">
        		<button type="button" onclick="window.location.href = '/PrettyStyle/App/pages/profile/profile.jsp'">Minha conta</button>
        		<button type="button" onclick="window.location.href = '/PrettyStyle/App/pages/requests/requests.jsp'">Meus Pedidos</button>
        	</div>
        </div>
      </div>
      <div class="favorite">
        <div class="favorite-icon">
          <img src="<%=request.getContextPath()%>/App/assets/icons/heart.svg">
        </div>
      </div>
      <div class="cart">
        <div class="cart-icon" onclick="window.location.href='<%=request.getContextPath()%>/App/pages/cart/cart.jsp';">
          <img src="<%=request.getContextPath()%>/App/assets/icons/cart.svg">
        </div>
      </div>
    </div>
  </div>
  <div class="bottom-header">
    <nav>
      <ul>
        <li class="active">SALES</li>
        <li onclick="window.location.href = '<%= request.getContextPath() %>/App/pages/'">NOVIDADES</li>
        <li onclick="window.location.href = '<%= request.getContextPath() %>/App/pages/sign-in/sign-in.jsp'">LOGIN</li>
        <li onclick="window.location.href = '<%= request.getContextPath() %>/App/pages/edit-profile/edit-profile.jsp'">EDITAR PERFIL</li>
        <li onclick="window.location.href = '<%= request.getContextPath() %>/App/pages/save-address/save-address.jsp'">CRIAR ENDEREÇO</li>
        <li onclick="window.location.href = '<%= request.getContextPath() %>/App/pages/profile-address/profile-address.jsp'">MEUS ENDEREÇOS</li>
        <li onclick="window.location.href = '<%= request.getContextPath() %>/App/pages/requests/requests.jsp'">MEUS PEDIDOS</li>
        <li onclick="window.location.href = '<%= request.getContextPath() %>/App/pages/payment-steps/payment-steps.jsp'">ETAPAS DE PAGAMENTO</li>
        <!-- <li>ACESSÓRIOS</li>
        <li>MASCULINO</li>
        <li>FEMININO</li>
        <li>PETS</li> -->
      </ul>
    </nav>
  </div>
</header>
