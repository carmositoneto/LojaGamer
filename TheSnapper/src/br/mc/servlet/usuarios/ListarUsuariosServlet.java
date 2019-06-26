package br.mc.servlet.usuarios;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mc.model.Usuario;
import br.mc.model.UsuarioHandler;

@WebServlet("/Signedin/Usuarios/ListarUsuariosServlet")
public class ListarUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioHandler usuarioHandler = new UsuarioHandler();

	public ListarUsuariosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("usuarios", usuarioHandler.consultar());

		try {
			BigInteger cpf = new BigInteger(request.getParameter("cpf"));
			Usuario u = usuarioHandler.consultarComFoto(cpf);
			request.getSession().setAttribute("alterarusuario", u);
		} catch (Exception e) {
			request.getSession().removeAttribute("alterarusuario");
		}
		
		request.getRequestDispatcher("/WEB-INF/pages/usuarios.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
