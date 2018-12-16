package com.cg.ticket.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.cg.ticket.bean.TicketBean;
import com.cg.ticket.exception.TicketException;
import com.cg.ticket.util.Dbconnection;

public class TicketDaoImpl implements ITicketDao {

	@Override
	public String addTain(TicketBean ticketBean) throws TicketException, ClassNotFoundException, IOException, SQLException {
		Connection connection = Dbconnection.getConnection();
		Statement statement = connection.createStatement();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String trainNo = null;
		int queryResult = 0;
		
		try
		{
			
			preparedStatement = connection.prepareStatement("insert into Ticket values(trainNo_seq.nextval,?,?,?,?,?)");
			preparedStatement.setString(1, ticketBean.getTrainName());
			preparedStatement.setString(2, ticketBean.getSource());
			preparedStatement.setString(3, ticketBean.getDestination());
			preparedStatement.setInt(4, ticketBean.getSeat());
			preparedStatement.setDouble(5, ticketBean.getPrice());
			
			preparedStatement.executeUpdate();
			
			resultSet = statement.executeQuery("Select * from Ticket");
			
			while(resultSet.next())
			{
				trainNo = resultSet.getString(1);
								
			}
			return trainNo;
			
		}catch (Exception e)
		{
			System.out.println(e);
		}
		
		return null;

		
	}

	@Override
	public TicketBean viewSeat(TicketBean ticketBean) throws TicketException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketBean bookTicket(TicketBean ticketBean) throws TicketException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TicketBean> retrieveAll() throws TicketException {
		// TODO Auto-generated method stub
		return null;
	}

}
