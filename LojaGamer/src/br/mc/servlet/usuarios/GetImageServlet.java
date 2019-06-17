package br.mc.servlet.usuarios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mc.model.Usuario;
import br.mc.model.UsuarioHandler;

@WebServlet("/Signedin/Usuarios/GetImageServlet")
public class GetImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioHandler usuarioHandler = new UsuarioHandler();

	public GetImageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Usuario u = usuarioHandler.consultarComFoto(id);
			if (u != null) {
				if((u.getFotoType() != null) && (u.getFoto() != null)) {
					response.setContentType(u.getFotoType());
					response.getOutputStream().write(u.getFoto());
				}else {
					response.setContentType("image/png");
					String s = getServletContext().getRealPath(File.separator) + "/imgs/user.png";
					Path path = Paths.get(s);
					byte[] bytes = Files.readAllBytes(path);
					response.getOutputStream().write(bytes);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.setContentType("image/png");
			Path path = Paths.get(getServletContext().getRealPath(File.separator) + "./imgs/user.png");
			byte[] bytes = Files.readAllBytes(path);
			response.getOutputStream().write(bytes);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
