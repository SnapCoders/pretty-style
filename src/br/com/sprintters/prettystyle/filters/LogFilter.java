package br.com.sprintters.prettystyle.filters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.sprintters.prettystyle.model.User;
import br.com.sprintters.prettystyle.service.UserService;
import br.com.sprintters.prettystyle.utils.Log;

@WebFilter("/*")
public class LogFilter implements Filter {

	FilterConfig filterConfig = null;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpServletRequest req = (HttpServletRequest) request;
		
		int idUser = -1;
		
		if (request.getAttribute("idUser") != null) idUser = (int)request.getAttribute("idUser");
		
		UserService us = new UserService();
		
		User user = null;
		
		try {
			user = us.find(idUser);				
		} catch (Exception e) {
			e.printStackTrace();
		}

		String command = req.getParameter("command");
		String action = "";

		if (command == null) action = req.getRequestURI();

		Calendar timestamp = Calendar.getInstance();

		String textoLog = "";
		ServletContext servletContext = filterConfig.getServletContext();
		String contextPath = servletContext.getRealPath(File.separator);
		
		if (command == null && user == null) {
			textoLog = String.format("[%1$tA, %1$tB %1$td, %1$tY %1$tZ %1$tI:%1$tM:%1$tS:%1$tL %tp] %s\n", timestamp, action);
		} else {
			textoLog = String.format("[%1$tA, %1$tB %1$td, %1$tY %1$tZ %1$tI:%1$tM:%1$tS:%1$tL %tp] %s -> %s\n", timestamp, user.getUsername(), command);
		}

		String logDirectory = contextPath + File.separator + "log";
		
		if (!Files.exists(Paths.get(logDirectory), LinkOption.NOFOLLOW_LINKS)) new File(logDirectory).mkdir();
		
		synchronized (textoLog) {
			Log arqLog = new Log();
			
			arqLog.abrir(contextPath + File.separator + "log" + File.separator + Log.NOME);
			arqLog.escrever(textoLog);
			arqLog.fechar();
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}
}
