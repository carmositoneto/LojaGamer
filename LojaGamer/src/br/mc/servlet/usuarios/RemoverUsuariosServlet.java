package br.mc.servlet.usuarios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mc.model.UsuarioHandler;

@WebServlet("/Signedin/Usuarios/RemoverUsuariosServlet")
public class RemoverUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioHandler usuarioHandler = new UsuarioHandler();

	public RemoverUsuariosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = new Integer(request.getParameter("id"));
			usuarioHandler.remover(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		response.sendRedirect(request.getContextPath() + "/Signedin/Usuarios/ListarUsuariosServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
