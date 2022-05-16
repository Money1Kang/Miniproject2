package com.ticket.controller;

import java.util.List;

import com.ticket.model.Ticket;
import com.ticket.service.TicketService;
import com.ticket.view.TicketView;

public class TicketController {

	private List<Ticket> tickets;
	private final TicketView ticketView;
	private final TicketService ticketService;
	private Exception errorObject;

	public TicketController() {
		this.ticketView = new TicketView();
		this.ticketService = new TicketService();
	}

	public void findAll() {
		tickets = ticketService.findAll();
		ticketView.findAll(tickets);
	}

	public void findById(Long ticktId) {
		Ticket ticket = ticketService.findById(ticktId);

		if (ticket != null) {
			ticketView.findById(ticket);
		} else {
			errorObject = new Exception("해당하는 Ticket 정보가 존재하지 않습니다.");
			ticketView.errorPage(errorObject);
		}

	}

//	public void save(Ticket newTicket) {
//		int result = ticketService.save(newTicket);
//
//		// 데이터의 저장 성공 여부는 TicketView가 출력한다.
//		if (result > 0) {
//			ticketView.successPage();
//		} else {
//			ticketView.errorPage(errorObject);
//		}
//	}

	public void updateById(Long passengerId, Ticket updateTicket) {
		int previousTicket = ticketService.updateById(passengerId, updateTicket);

		if (previousTicket > 0) {
			ticketView.update(previousTicket);
		} else {
			errorObject = new Exception("수정 실패");
			ticketView.errorPage(errorObject);
		}

	}

	public void deleteById(Long deleteNumber) {
		int deletedTicket = ticketService.deleteById(deleteNumber);

		if (deletedTicket > 0) {
			ticketView.delete(deletedTicket);
		} else {
			errorObject = new Exception("삭제 실패");
		}
	}

}


