package br.mc.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetImageServlet")
public class GetImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArrayList<String> thanosImgs = new ArrayList<String>();

	public GetImageServlet() {
		super();
		thanosImgs.add("thanos1.jpg");
		thanosImgs.add("thanos2.gif");
		thanosImgs.add("thanos3.jpg");
		thanosImgs.add("thanos4.jpg");
		thanosImgs.add("thanos5.jpg");
		thanosImgs.add("thanos6.gif");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random r = new Random();
		String imgid = request.getParameter("imgid");
		int imgidNro = r.nextInt(thanosImgs.size());

		try {
			imgidNro = Integer.parseInt(imgid);
			if ((imgidNro < 0) || (imgidNro > r.nextInt(thanosImgs.size()))) {
				imgidNro = r.nextInt(thanosImgs.size());
			}
		} catch (NumberFormatException e) {
		}

		String thanosImgPath = thanosImgs.get(imgidNro);
		String pathToWeb = getServletContext().getRealPath(File.separator);

		if (thanosImgPath.toLowerCase().endsWith(".gif")) {
			response.setContentType("image/gif");
		} else {
			response.setContentType("image/jpeg");
		}

		Path path = Paths.get(pathToWeb + "./imgs/" + thanosImgPath);
		byte[] bytes = Files.readAllBytes(path);
		response.getOutputStream().write(bytes);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
