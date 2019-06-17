package br.mc.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/Signedin/*")
public class LoginRequiredFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest)request;
		HttpServletResponse rp = (HttpServletResponse)response;
		
		if(rq.getSession().getAttribute("usuariologado") != null) {
			chain.doFilter(request, response);
		}
		else {
			System.out.println("LoginRequiredFilter: invalidate");
			rq.getSession().invalidate();
			rp.sendRedirect(rq.getContextPath()+"/LoginServlet");
		}
	}
}
