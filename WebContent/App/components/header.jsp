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
      <div class="account" onclick="window.location.href = '/PrettyStyle/App/pages/sign-in/sign-in.jsp'">
        <div class="account-icon">
          <img src="<%=request.getContextPath()%>/App/assets/icons/home.svg">
        </div>
        <strong>Minha conta</strong>
        <img src="<%=request.getContextPath()%>/App/assets/icons/arrow-down.svg">
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
        <%-- <li onclick="window.location.href = '<%= request.getContextPath() %>/App/pages/'">NOVIDADES</li> --%>
        <li onclick="window.location.href = '<%= request.getContextPath() %>/App/pages/sign-up-simple/sign-up-simple.jsp'">SIMPLES</li>
        <li onclick="window.location.href = '<%= request.getContextPath() %>/App/pages/sign-up-business/sign-up-business.jsp'">BUSINESS</li>
        <!-- <li>ACESSÓRIOS</li>
        <li>MASCULINO</li>
        <li>FEMININO</li>
        <li>PETS</li> -->
      </ul>
    </nav>
  </div>
</header>
