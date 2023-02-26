package com.assignment.dao;

import java.util.ArrayList;

import com.assignment.business.Player;
import com.assignment.business.Squad;
import com.assignment.exceptions.DaoException;

//interface
interface PlayerDao {
	public Player InsertIntoPlayer(String firstName, String lastName, String dob, String contactNumber, String email, String[] squadCheckboxList) throws DaoException;
}