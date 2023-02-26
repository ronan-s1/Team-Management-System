package com.assignment.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.business.Squad;
import com.assignment.exceptions.DaoException;
import com.assignment.service.SquadService;

public class GetSquadsCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		SquadService squadService = new SquadService();
		ArrayList<Squad> squads = new ArrayList<Squad>();
	
		squads = squadService.getSquads();

		HttpSession session = request.getSession();
		
		session.setAttribute("squads", squads);
		
		String forwardToJsp = "/addPlayer.jsp";
		return forwardToJsp;
	}

}
