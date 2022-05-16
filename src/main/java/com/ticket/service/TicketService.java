package com.ticket.service;

import java.util.List;

import com.ticket.dao.TicketDAO;
import com.ticket.model.Ticket;

public class TicketService {

	private final TicketDAO ticketDAO;

	public TicketService() {
		ticketDAO = new TicketDAO();
	}

	public List<Ticket> findAll() {
		return ticketDAO.findAll();
	}

	public Ticket findById(Long ticktId) {
		return ticketDAO.findById(ticktId);
	}

//	public int save(Ticket newTicket) {
//		return ticketDAO.save(newTicket);
//	}
	
	public int updateById(Long passengerId, Ticket updateTicket) {
		return ticketDAO.updateById(passengerId, updateTicket);
	}

	public int deleteById(Long deleteNumber) {
		return ticketDAO.deleteById(deleteNumber);
	}

	

}
