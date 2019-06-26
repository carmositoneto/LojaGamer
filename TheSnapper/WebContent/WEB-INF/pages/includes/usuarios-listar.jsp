<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Lista de usuarios</h2>
<table class="table table-striped">
	<thead>
		<tr>
			<th>CPF</th>
			<th>Imagem</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Alterar</th>
			<th>Remover</th>
		</tr>
	</thead>
	<c:forEach items="${ usuarios }" var="usuario">

		<tr>
			<td>${ usuario.cpf }</td>
			<td><img alt="${ usuario.cpf }" src="<%= request.getContextPath() %>/Signedin/Usuarios/GetImageServlet?id=${ usuario.cpf }" height="100px" width="100px" /></td>
			<td>${ usuario.senha }</td>
			<td>${ usuario.nome }</td>
			<td>${ usuario.email }</td>
			<td>
				<a href="<%= request.getContextPath() %>/Signedin/Usuarios/ListarUsuariosServlet?id=${ usuario.cpf }">Alterar</a>
			</td>
			<td>
				<a href="<%= request.getContextPath() %>/Signedin/Usuarios/RemoverUsuariosServlet?id=${ usuario.cpf }">Remover</a>
			</td>
		</tr>
	</c:forEach>
</table>