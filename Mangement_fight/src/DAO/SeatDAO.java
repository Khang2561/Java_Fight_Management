package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Plane;
import Model.Seat;
import libData.JDBCUtil;

public class SeatDAO implements DAOInterface<Seat>{

	@Override
	public int insert(Seat t) {
		Connection con = null;
	    PreparedStatement preparedStatement = null;
	    int rowsAffected = 0;
	    
	    try {
	    	//B1: KET NOI VOI DATABASE
	        con = JDBCUtil.getConnection();
	        //B2: THUC HIEN CAU LENH SQL 
	        String sql = "INSERT INTO SEAT (SeatID, PlaneID, TicketClassID) VALUES (?,?, ?)";
	        //B3: TAO STATEMENT
	        preparedStatement = con.prepareStatement(sql);
	        
	        // Set values for parameters
	        preparedStatement.setString(1, t.getSeatID());
	        preparedStatement.setString(2, t.getPlaneID());
	        preparedStatement.setString(3, t.getTicketClass());
	        
	        
	        // Execute the statement
	        rowsAffected = preparedStatement.executeUpdate();
	        //B5: CLOSE CONNECTION 
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources in the reverse order of their creation
	        JDBCUtil.closeConnection(con);
	        if (preparedStatement != null) {
	            try {
	                preparedStatement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    return rowsAffected;
	}

	@Override
	public int update(Seat t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Seat t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Seat selectById(Seat t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Seat> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	

}