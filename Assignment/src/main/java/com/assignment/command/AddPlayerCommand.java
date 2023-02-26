package com.assignment.command;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.business.Player;
import com.assignment.service.PlayerService;

public class AddPlayerCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		PlayerService playerService = new PlayerService();
		String forwardToJsp = "";	
		
		String[] squadCheckboxList = request.getParameterValues("squadCheckbox");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dob = request.getParameter("dob");
		String contactNumber = request.getParameter("contactNumber");
		String email = request.getParameter("email");
		
		Player player = playerService.addPlayer(firstName, lastName, dob, contactNumber, email, squadCheckboxList);
		
		HttpSession session = request.getSession();
		session.setAttribute("players", player);			

		forwardToJsp = "/addSuccess.jsp";
		return forwardToJsp;
	}

}
