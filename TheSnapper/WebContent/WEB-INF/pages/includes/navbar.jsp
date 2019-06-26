<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- https://gist.github.com/daverogers/5375778 -->
<script type="text/javascript">
	$(document).ready(function() {
		// get current URL path and assign 'active' class
		var pathname = window.location.pathname;
		$('ul.navbar-nav > li > a[href="'+pathname+'"]').parent().addClass('active');
	})
</script>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<img class="navbar-brand" alt="Thanos" src="<%= request.getContextPath() %>/GetImageServlet" height="100px" width="100px" style="display: inline-block;" />
		<a class="navbar-brand" href="<%= request.getContextPath() %>/">Loja Maromba</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<!-- �rea administradores -->
				<c:if test="${ usuariologado.admin }">
					<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/Signedin/Produtos/ListarProdutosServlet">Produtos</a></li>
					<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/Signedin/Usuarios/ListarUsuariosServlet">Usuarios</a></li>
						<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/Signedin/Compra/ListrarProdutoCompra">Comprar</a></li>
						<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/Signedin/Compra/ListaCompracarrinhoServelet">Carrinho</a></li>
						
				</c:if>
				<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/Signedin/SobreServlet">Sobre</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="dropdown">
					<img class="dropdown-toggle" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" alt="${ usuariologado.cpf }" src="<%= request.getContextPath() %>/Signedin/Usuarios/GetImageServlet?id=${ usuariologado.cpf }" height="100px" width="100px" />
<!-- 					<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Login</button> -->
					<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item disabled" href="#">${ usuariologado.cpf }</a>
						<a class="dropdown-item disabled" href="#">${ usuariologado.nome }</a>
						<a class="dropdown-item" href="<%= request.getContextPath() %>/LogoutServlet">Logout</a>
					</div>
				</li>
	        </ul>
		</div>
	</nav>