package com.ticket.view;

import java.util.List;

import com.ticket.model.Ticket;

public class TicketView {

	public void findAll(List<Ticket> tickets) {
		System.out.println("<전체 티켓 결과 출력>");

		for (Ticket ticket : tickets) {
			System.out.println(String.format("%d번째는  %s -> %s 향하는 %s%s 티켓 입니다.", ticket.getTicketId(),
					ticket.getStartingPoint(), ticket.getDestination(), ticket.getLastName(), ticket.getFirstName()));
			System.out.println();
		}
	}

	public void findById(Ticket ticket) {
		System.out.println("<특정 티켓 조회 결과 출력>");
		System.out.println(String.format("%d번째는  %s -> %s 향하는 %s%s 티켓 입니다.", ticket.getTicketId(),
				ticket.getStartingPoint(), ticket.getDestination(), ticket.getLastName(), ticket.getFirstName()));
		System.out.println();
	}

	public void errorPage(Exception error) {
		System.out.println("<오류 결과 출력>");
		System.out.println("문제가 발생하였습니다." + error.getMessage());
		System.out.println();
	}

	public void successPage() {
		System.out.println("<결과 출력>");
		System.out.println("정상 등록 되었습니다.");
		System.out.println();

	}

	public void update(int previousTicket) {
		System.out.println("<수정된 결과 출력>");
		System.out.println("정상 수정 되었습니다.");
		System.out.println();
	}

	public void delete(int deletedTicket) {
		System.out.println("<삭제된 결과 출력>");
		System.out.println("정상 삭제 되었습니다.");
		System.out.println("삭제될 데이터 값 : " + deletedTicket);
		System.out.println();
	}

}


