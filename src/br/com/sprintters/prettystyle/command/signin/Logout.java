package br.com.sprintters.prettystyle.command.signin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sprintters.prettystyle.command.Command;

public class Logout implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		HttpSession session = request.getSession();
		
		session.invalidate();
	}
}
