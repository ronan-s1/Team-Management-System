package com.assignment.service;

import java.util.ArrayList;

import com.assignment.business.Squad;
import com.assignment.dao.MainDao;
import com.assignment.exceptions.DaoException;

public class SquadService {
	MainDao dao = new MainDao();
	
	public ArrayList<Squad> getSquads(){
			
			ArrayList<Squad> squadList = new ArrayList<Squad>();
			try {			
				squadList = dao.selectAllSquads();
			} 
			catch (DaoException e) {
				e.printStackTrace();
			}
			return squadList;
			
		}
}
