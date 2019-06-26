package br.mc.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import br.mc.model.UsuarioHandler;

@WebServlet("/CadastroUsuarioServlet")
@MultipartConfig
public class CadastroUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioHandler usuarioHandler = new UsuarioHandler();

	public CadastroUsuarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("cpf") != null)
		{
			BigInteger cpf = new BigInteger((request.getParameter("cpf")));
			String senha = request.getParameter("senha");
			
			if (cpf != null && senha != null) {
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				byte[] imagem = null;
				String imagemTipo = null;
				
				InputStream inputStream = null;
				Part filePart = request.getPart("imagem");
				if (filePart != null) {
					imagemTipo = filePart.getContentType();
					inputStream = filePart.getInputStream();
					imagem = IOUtils.toByteArray(inputStream);
				}
				
				usuarioHandler.adicionar(cpf, senha, nome, email, false, imagem, imagemTipo);
				
				response.sendRedirect(request.getContextPath()+"/Signedin/Produtos/ListarProdutosServlet");
			}
		}	
		else {
			request.getRequestDispatcher("/WEB-INF/pages/usuario-cadastrar.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
