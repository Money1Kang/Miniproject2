package com.ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ticket.model.Ticket;
import com.ticket.utils.DBUtils;

public class TicketDAO {

	private Ticket ticket;
	private PreparedStatement pstmt;

	// 전체 티켓 조회
	public List<Ticket> findAll() {

		final String selectQuery = "SELECT ticket_id, last_name, first_name, airline, starting_point, destination FROM ticket "
				+ "JOIN airline " + "ON ticket.airline_id = airline.airline_id " + "JOIN starting_point "
				+ "ON ticket.starting_point_id = starting_point.starting_point_id " + "JOIN passenger "
				+ "ON ticket.passenger_id = passenger.passenger_id " + "JOIN destination "
				+ "ON ticket.destination_id = destination.destination_id ";

		List<Ticket> tickets = new ArrayList<>();

		try (Connection conn = DBUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectQuery);) {

			while (rs.next()) {
				ticket = new Ticket.Builder(rs.getLong("ticket_id")).firstName(rs.getString("first_name"))
						.lastName(rs.getString("last_name")).aireline(rs.getString("airline"))
						.destination(rs.getString("destination")).startingPoint(rs.getString("starting_point"))
						.build();

				tickets.add(ticket);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tickets;
	}

	// 하나의 티켓 조회
	public Ticket findById(Long ticktId) {

		final String selectQuery = "SELECT ticket_id, last_name, first_name, airline, starting_point, destination FROM ticket "
				+ "JOIN airline " + "ON ticket.airline_id = airline.airline_id " + "JOIN starting_point "
				+ "ON ticket.starting_point_id = starting_point.starting_point_id " + "JOIN passenger "
				+ "ON ticket.passenger_id = passenger.passenger_id " + "JOIN destination "
				+ "ON ticket.destination_id = destination.destination_id " + "WHERE ticket_id = ? ORDER BY ticket_id ";

		try (Connection conn = DBUtils.getConnection();
				PreparedStatement pstmt = createPreparedStatement(conn, selectQuery, ticktId);
				ResultSet rs = pstmt.executeQuery();) {

			if (rs.next()) {
				ticket = new Ticket.Builder(rs.getLong("ticket_id")).firstName(rs.getString("first_name"))
						.lastName(rs.getString("last_name")).aireline(rs.getString("airline"))
						.destination(rs.getString("destination")).startingPoint(rs.getString("starting_point"))
						.build();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ticket;
	}

	private PreparedStatement createPreparedStatement(Connection conn, String selectQuery, Long ticktId)
			throws SQLException {
		pstmt = conn.prepareStatement(selectQuery);
		pstmt.setLong(1, ticktId);
		return pstmt;
	}

	// 티켓 추가
//	public int save(Ticket newTicket) {
//		String insertQuery = "INSERT INTO ticket (passenger_id, description_id, starting_point_id, airline_id) VALUES (?, ?, ?, ?)";
//		int affectedRows = 0;
//
//		try (Connection conn = DBUtils.getConnection();
//				PreparedStatement pstmt = createPreparedStatement(conn, insertQuery, newTicket);) {
//			affectedRows = pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return affectedRows;
//	}
//
//	private PreparedStatement createPreparedStatement(Connection connection, String selectQuery, Ticket newTicket)
//			throws SQLException {
//		pstmt = connection.prepareStatement(selectQuery);
//		pstmt.setString(1, newTicket.get);
//		pstmt.setString(2, newTicket.getDescription());
//		pstmt.setString(3, newTicket.getDueDate().toString());
//		return pstmt;
//	}

	// 티켓 업데이트
	public int updateById(Long passengerId, Ticket updateTicket) {
		String updateQuery = "UPDATE passenger SET first_name = ?, last_name = ? WHERE passenger_id = ?";
		int affectedRows = 0;

		try (Connection conn = DBUtils.getConnection();
				PreparedStatement pstmt = createPreparedStatement(conn, updateQuery, passengerId, updateTicket);) {
			affectedRows = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}

	private PreparedStatement createPreparedStatement(Connection connection, String updateQuery, Long passengerId,
			Ticket updateTicket) throws SQLException {
		pstmt = connection.prepareStatement(updateQuery);
		pstmt.setString(1, updateTicket.getFirstName());
		pstmt.setString(2, updateTicket.getLastName());
		pstmt.setLong(3, passengerId);
		return pstmt;
	}

	// 정보 삭제
	public int deleteById(Long deleteNumber) {
		String deleteQuery = "DELETE FROM ticket WHERE ticket_id = ?";
		int affectedRows = 0;
		try (Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = deletePreparedStatement(connection, deleteQuery, deleteNumber)) {
			affectedRows = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	private PreparedStatement deletePreparedStatement(Connection connection, String deleteQuery, Long deleteNumber)
			throws SQLException {
		pstmt = connection.prepareStatement(deleteQuery);
		pstmt.setLong(1, deleteNumber);

		return pstmt;
	}

}








