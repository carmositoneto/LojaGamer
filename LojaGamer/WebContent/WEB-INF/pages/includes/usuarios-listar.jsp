<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Lista de usuarios</h2>
<table class="table table-striped">
	<thead>
		<tr>
			<th>ID</th>
			<th>Foto</th>
			<th>Login</th>
			<th>Senha</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Alterar</th>
			<th>Remover</th>
		</tr>
	</thead>
	<c:forEach items="${ usuarios }" var="usuario">

		<tr>
			<td>${ usuario.id }</td>
			<td><img alt="${ usuario.login }" src="<%= request.getContextPath() %>/Signedin/Usuarios/GetImageServlet?id=${ usuario.id }" height="100px" width="100px" /></td>
			<td>${ usuario.login }</td>
			<td>${ usuario.senha }</td>
			<td>${ usuario.nome }</td>
			<td>${ usuario.email }</td>
			<td>
				<a href="<%= request.getContextPath() %>/Signedin/Usuarios/ListarUsuariosServlet?id=${ usuario.id }">Alterar</a>
			</td>
			<td>
				<a href="<%= request.getContextPath() %>/Signedin/Usuarios/RemoverUsuariosServlet?id=${ usuario.id }">Remover</a>
			</td>
		</tr>
	</c:forEach>
</table>