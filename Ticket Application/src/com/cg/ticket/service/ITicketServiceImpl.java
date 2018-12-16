package com.cg.ticket.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.ticket.bean.TicketBean;
import com.cg.ticket.dao.ITicketDao;
import com.cg.ticket.dao.TicketDaoImpl;
import com.cg.ticket.exception.TicketException;

public class ITicketServiceImpl implements ITicketService
{

	ITicketDao iticketdao  = new TicketDaoImpl();
	
	@Override
	public String addTain(TicketBean ticketBean) throws TicketException, ClassNotFoundException, IOException, SQLException {
		String trainNoseq;
		trainNoseq = iticketdao.addTain(ticketBean);
		return trainNoseq;
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

	public void validateLibraryAttribute(TicketBean ticketBean) throws TicketException
	{
		
		List <String> validationError  = new ArrayList<String>();
		if(!(isValidTrainName(ticketBean.getTrainName())))
		{
			
			validationError.add("\n Train name should be in alphabet and minimum 2 character. ");
		}
		
		if(!(isValidSourceName(ticketBean.getSource())))
		{
			
			validationError.add("\n Source name should be in alphabet and minimum 3 characters. ");
		}
		
		if(!(isValidDestinationName(ticketBean.getDestination())))
		{
			validationError.add("\n Destination name should be in alphabet and minimum 3 characters. ");
		}
		
		if(!(isValidSeat(ticketBean.getSeat())))
		{
			validationError.add("\n Quantity should be positive. ");
		}
		
		if(!(isValidPrice(ticketBean.getPrice())))
		{
			validationError.add("\n Quantity should be positive. ");
		}
		
		if(!(validationError.isEmpty()))
		{
			throw new TicketException(validationError+" ");
		}
		

		
	}

	private boolean isValidPrice(double price) {
	
		return price>0;
	}

	private boolean isValidSeat(int seat) {
	
		return seat>0;
	}

	private boolean isValidDestinationName(String destination) {
		Pattern bpattern = Pattern.compile("^[A-Za-z]{2,}$");
		Matcher bmatcher = bpattern.matcher(destination);
		return bmatcher.matches();
	}

	private boolean isValidSourceName(String source) {
		Pattern bpattern = Pattern.compile("^[A-Za-z]{3,}$");
		Matcher bmatcher = bpattern.matcher(source);
		return bmatcher.matches();
	}

	private boolean isValidTrainName(String trainName)
	{
		
		Pattern bpattern = Pattern.compile("^[A-Za-z]{2,}$");
		Matcher bmatcher = bpattern.matcher(trainName);
		return bmatcher.matches();
	}

}
