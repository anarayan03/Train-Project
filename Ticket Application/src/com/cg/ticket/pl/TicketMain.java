package com.cg.ticket.pl;

import java.util.Scanner;

import com.cg.ticket.bean.BookedDetail;
import com.cg.ticket.bean.TicketBean;
import com.cg.ticket.exception.TicketException;
import com.cg.ticket.service.ITicketService;
import com.cg.ticket.service.ITicketServiceImpl;

public class TicketMain 
{
	
	static Scanner scanner = new Scanner(System.in);
	static ITicketService iTicketService = null;
	static ITicketServiceImpl iticketServiceImpl = null;
	
	public static void main(String[] args)
	{
		TicketBean ticketBean = null;
		BookedDetail bookedDetail = new BookedDetail();
		String trainNo = null;
		int option = 0;
		
		while(true)
		{
			
			System.out.println();
			System.out.println();
			System.out.println("	WELCOME TO IRCTC	");
			System.out.println("----------------------------");
			System.out.println("1. Add Train Details ");
			System.out.println("2. View Seat Availability");
			System.out.println("3. Book Tickets");
			System.out.println("4. Retrieve Trains ");
			System.out.println("5. Exit");
			System.out.println("____________________________");
			System.out.println("\nEnter your Choice ");
			
			try
			{
				option = scanner.nextInt();
				switch (option)
				{
				case 1 :
					
					while(ticketBean==null)
					{
						ticketBean=populateTicketBean();
					}
					try
					{
						iticketServiceImpl = new ITicketServiceImpl();
						trainNo=iticketServiceImpl.addTain(ticketBean);
						System.out.println("Train details added successfully....");
						System.out.println("Train No is :"+ trainNo);
					}catch (TicketException ticketException) {
						System.out.println("ERROR :" + ticketException.getMessage());
					}
					finally
					{
						trainNo = null;
						iticketServiceImpl = null;
						ticketBean = null;
					}
					
					
					break;

				case 2 :
					
					
					break;
				case 3 :
	
	
					break;
				case 4 :
	
	
					break;
				case 5 :
	
	
					break;
				default :
					
					break;
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}

	private static TicketBean populateTicketBean() {
		
		TicketBean ticketBean = new TicketBean();
		System.out.println("Enter Train Details :");
		
		System.out.println("\nEnter Train Name : ");
		ticketBean.setTrainName(scanner.next());
		
		System.out.println("Enter Source : ");
		ticketBean.setSource(scanner.next());
		
		System.out.println("Enter Destination : ");
		ticketBean.setDestination(scanner.next());
		
		try
		{
		System.out.println("Enter Seat Details : ");
		ticketBean.setSeat(scanner.nextInt());
		}catch (Exception e) {
			System.out.println("Invalid Data");
			System.err.println(e);
			System.exit(0);
		}
		
		try
		{
		System.out.println("Enter Price : ");
		ticketBean.setPrice(scanner.nextDouble());
		}catch (Exception e) {
			System.out.println("Invalid Data");
			System.err.println(e);
			System.exit(0);
		}
		
		iticketServiceImpl = new ITicketServiceImpl();
		
		try
		{
			iticketServiceImpl.validateLibraryAttribute(ticketBean);
			return ticketBean;
		}catch (TicketException e)
		{
			System.out.println("Invalid Data");
			System.err.println(e);
			System.exit(0);
		}
		
		return null;
	}
}
