package com.assignment.service;

import java.util.ArrayList;
import java.util.List;

import com.assignment.business.Player;
import com.assignment.dao.MainDao;
import com.assignment.exceptions.DaoException;

public class PlayerService {

	MainDao dao = new MainDao();
	
	public Player addPlayer(String firstName, String lastName, String dob, String contactNumber, String email, String[] squadCheckboxList){
		
		Player player = null;
		try {			
			player = dao.InsertIntoPlayer(firstName, lastName, dob, contactNumber, email, squadCheckboxList);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return player;
	}

	
}

