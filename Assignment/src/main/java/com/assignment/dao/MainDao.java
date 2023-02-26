package com.assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.assignment.business.Player;
import com.assignment.business.Squad;
import com.assignment.exceptions.DaoException;
import com.mysql.cj.xdevapi.Statement;


public class MainDao extends Dao implements PlayerDao, SquadDao{

	@SuppressWarnings("resource")
	public Player InsertIntoPlayer(String firstName, String lastName, String dob, String contactNumber, String email, String[] squadCheckboxList) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String insertQueryJunction = null;
        String insertedPlayerId = null;
        Player player = null;
        try {
            con = this.getConnection();
            
            //inserting a player
            String insertQuery = "INSERT INTO players VALUES(null, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(insertQuery);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, dob);
            ps.setString(4, contactNumber);
            ps.setString(5, email);
            ps.executeUpdate();
            
            //inserting in junction table
            ps = con.prepareStatement("SELECT MAX(PLAYER_ID) AS insertedPlayerId FROM players");
            rs = ps.executeQuery();
            
            while (rs.next()) {
            	insertedPlayerId = rs.getString("insertedPlayerId");
            }
            
            for (String squadId : squadCheckboxList) { 
            	insertQueryJunction = "INSERT INTO squad_players VALUES(?, ?)";
                ps = con.prepareStatement(insertQueryJunction);
                ps.setString(1, insertedPlayerId);
                ps.setString(2, squadId);
                ps.executeUpdate();
            }

            return player;         
        }
        
        catch (SQLException e) {
            throw new DaoException("InsertIntoPlayer " + e.getMessage());
        }
        
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            }
            
            catch (SQLException e) {
                throw new DaoException("InsertIntoPlayer" + e.getMessage());
            }
        }
    }

    
    //modified code ahead
    
    public ArrayList<Squad> selectAllSquads() throws DaoException {
    	
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Squad squad = null;
        
        ArrayList<Squad> squadList = new ArrayList<Squad>();
        
        try {
            con = this.getConnection();
            
            //select all squads
            String query = "SELECT * FROM squads";
            ps = con.prepareStatement(query);
            
            //if there are more users, continue printing out
            rs = ps.executeQuery();
            while (rs.next()) {
                int squadId = rs.getInt("SQUAD_ID");
                String squadName = rs.getString("SQUAD_NAME");

                squad = new Squad(squadId, squadName);
                squadList.add(squad);
            }
        }
        
        catch (SQLException e) {
            throw new DaoException("selectAllPlayers " + e.getMessage());
        }
        
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            }
            
            catch (SQLException e) {
                throw new DaoException("selectAllPlayers" + e.getMessage());
            }
        }

    	return squadList;
    }
   	
}

