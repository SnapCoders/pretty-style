package br.com.sprintters.prettystyle.command.signup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sprintters.prettystyle.command.Command;

public class NavigateToNewUserBusiness implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		response.sendRedirect("/PrettyStyle/App/pages/sign-up-business/sign-up-business.jsp");
	}
}
