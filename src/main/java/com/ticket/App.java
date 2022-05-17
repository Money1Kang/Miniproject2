package com.ticket;

import java.time.LocalDate;

import com.ticket.controller.TicketController;
import com.ticket.model.Ticket;

public class App {

	public static void main(String[] args) throws Exception {

		TicketController ticketController = new TicketController();
		// 전체 조회
		ticketController.findAll();

		// 특정 인덱스 조회
		long ticktId = 2L;
		ticketController.findById(ticktId);

//		// 티켓 추가
//		Ticket ticket = new Ticket.Builder(null)
//								  .firstName("병헌")
//								  .lastName("이")
//								  .aireline("대한한공")
//								  .birthDate(LocalDate.of(2022, 06, 20))
//								  .destination("오사카")
//								  .startingPoint("부산")
//								  .build();
//		 todoController.save(ticket);

		// 정보 업데이트
		long passengerId = 1L;

		Ticket updateTicket = new Ticket.Builder(null).firstName("지섭").lastName("소").build();

		ticketController.updateById(passengerId, updateTicket);

		ticketController.findAll();

		// 정보 삭제
//		long deleteNumber = 6L;

//		ticketController.deleteById(deleteNumber);

//		ticketController.findAll();

		System.out.println("수정");
	}

}