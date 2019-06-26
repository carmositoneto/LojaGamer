package br.mc.servlet.usuarios;

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

@WebServlet("/Signedin/Usuarios/AdicionarUsuariosServlet")
@MultipartConfig
public class AdicionarUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioHandler usuarioHandler = new UsuarioHandler();

	public AdicionarUsuariosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BigInteger cpf = new BigInteger(request.getParameter("cpf"));
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
		
        byte[] imagem = null;
        String imagemTipo = null;

		InputStream inputStream = null;
        Part filePart = request.getPart("foto");
        if (filePart != null) {
            imagemTipo = filePart.getContentType();
            inputStream = filePart.getInputStream();
            imagem = IOUtils.toByteArray(inputStream);
        }
		
		usuarioHandler.adicionar(cpf, senha, nome, email, admin, imagem, imagemTipo);
		//
		response.sendRedirect(request.getContextPath() + "/Signedin/Usuarios/ListarUsuariosServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
