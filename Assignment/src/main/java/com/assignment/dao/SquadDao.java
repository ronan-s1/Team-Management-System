package com.assignment.dao;

import java.util.ArrayList;

import com.assignment.business.Squad;
import com.assignment.exceptions.DaoException;

//interface
interface SquadDao {
	public ArrayList<Squad> selectAllSquads() throws DaoException;
}