package com.ticket.model;

import java.time.LocalDate;

import com.ticket.model.Ticket;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Ticket {
	private Long ticketId;
	private String firstName;
	private String lastName;
	private String aireline;
	private LocalDate birthDate;
	private String destination;
	private String startingPoint;
	

	public Ticket() {
	}

	public Ticket(Long ticketId, String firstName, String lastName, String aireline, LocalDate birthDate,
			String destination, String startingPoint) {
		this.ticketId = ticketId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.aireline = aireline;
		this.birthDate = birthDate;
		this.destination = destination;
		this.startingPoint = startingPoint;
	}

	// Builder 적용
	public Ticket(Builder builder) {
			this.ticketId = builder.ticketId;
			this.firstName = builder.firstName;
			this.lastName = builder.lastName;
			this.aireline = builder.aireline;
			this.birthDate = builder.birthDate;
			this.destination = builder.destination;
			this.startingPoint = builder.startingPoint;
		}
	
	public static class Builder {
		private Long ticketId;
		private String firstName;
		private String lastName;
		private String aireline;
		private LocalDate birthDate;
		private String destination;
		private String startingPoint;

		public Builder(Long ticketId) {
			this.ticketId = ticketId;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder aireline(String aireline) {
			this.aireline = aireline;
			return this;
		}

		public Builder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public Builder destination(String destination) {
			this.destination = destination;
			return this;
		}
		
		public Builder startingPoint(String startingPoint) {
			this.startingPoint = startingPoint;
			return this;
		}

		public Ticket build() {
			return new Ticket(this);
		}
		
	}

}

