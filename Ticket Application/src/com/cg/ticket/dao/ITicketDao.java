package com.cg.ticket.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.ticket.bean.TicketBean;
import com.cg.ticket.exception.TicketException;

public interface ITicketDao 
{
	public String addTain(TicketBean ticketBean) throws TicketException, ClassNotFoundException, IOException, SQLException;
	public TicketBean viewSeat(TicketBean ticketBean) throws TicketException;
	public TicketBean bookTicket(TicketBean ticketBean) throws TicketException;
	public List<TicketBean> retrieveAll() throws TicketException; 
}
