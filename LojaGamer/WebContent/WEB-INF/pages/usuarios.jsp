<%@ include file="/WEB-INF/pages/includes/header.jsp"%>
<body>
	<%@ include file="/WEB-INF/pages/includes/navbar.jsp"%>

	<div class="container">
		<c:if test="${alterarusuario == null}">
			<%@ include file="/WEB-INF/pages/includes/usuarios-adicionar.jsp"%>
		</c:if>
		<c:if test="${alterarusuario != null}">
			<%@ include file="/WEB-INF/pages/includes/usuarios-alterar.jsp"%>
		</c:if>
		<hr>
		<%@ include file="/WEB-INF/pages/includes/usuarios-listar.jsp"%>
	</div>
	<%@ include file="/WEB-INF/pages/includes/footer.jsp"%>
</body>
</html>