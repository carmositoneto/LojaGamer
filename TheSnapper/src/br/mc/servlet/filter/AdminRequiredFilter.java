package br.mc.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/Signedin/*")
public class AdminRequiredFilter implements Filter {

	@Override
    public void init(FilterConfig config)
        throws ServletException {
        // If you have any <init-param> in web.xml, then you could get them
        // here by config.getInitParameter("name") and assign it as field.
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;

        String requestPath = request.getRequestURI();

        if (needsAuthentication(requestPath)) { // change "user" for the session attribute you have defined
        	System.out.println("Teste");
        } else {
        	System.out.println("Teste2");
        	chain.doFilter(req, res); // Logged-in user found, so just continue request.
        }
    }

    @Override
    public void destroy() {
        // If you have assigned any expensive resources as field of
        // this Filter class, then you could clean/close them here.
    }

    private boolean needsAuthentication(String url) {
        String[] validNonAuthenticationUrls =
            { "../usuarios-listar.jsp", "../usuarios-adicionar.jsp", "../usuarios-alterar.jsp" };
        for(String validUrl : validNonAuthenticationUrls) {
            if (url.endsWith(validUrl)) {
                return true;
            }
        }
        return false;
    }
}
