package br.mc.servlet;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mc.model.Usuario;
import br.mc.model.UsuarioHandler;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioHandler usuarioHandler = new UsuarioHandler();
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("cpf") != null)
		{
			BigInteger cpf = new BigInteger((request.getParameter("cpf")));
			String senha = request.getParameter("senha");
	
			request.getSession().invalidate();
			
			Usuario usuariologado = usuarioHandler.consultarLogin(cpf, senha);
			if (usuariologado != null) {
				request.getSession().setAttribute("usuariologado", usuariologado);
				response.sendRedirect(request.getContextPath()+"/Signedin/Produtos/ListarProdutosServlet");
			}
			else {
				request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
			}
		}
		else {
			request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
