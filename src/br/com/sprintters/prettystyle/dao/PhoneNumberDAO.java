package br.com.sprintters.prettystyle.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.PhoneNumber;

import java.sql.PreparedStatement;

public class PhoneNumberDAO {
	public int insert(PhoneNumber to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO phone_number (ddd, number, id_user, created_at) VALUES (?, ?, ?, NOW())";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setInt(1, to.getDdd());
			stm.setString(2, to.getNumber());
			stm.setInt(3, to.getIdUser());
			stm.execute();
			try (ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ID()")) {
				if (rs.next()) {					
					id = rs.getInt(1);
				}
				
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return id;
	}
	
	public void update(PhoneNumber to) throws Exception {
		String sqlUpdate = "UPDATE phone_number SET ddd = ?, number = ? ,id_user = ?, updated_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setInt(1, to.getDdd());
			stm.setString(2, to.getNumber());
			stm.setInt(3, to.getIdUser());
			stm.setInt(4, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void delete(PhoneNumber to) throws Exception {
		String sqlUpdate = "UPDATE phone_number SET deleted_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public PhoneNumber find(int id) throws Exception {
		PhoneNumber to = new PhoneNumber();
		String sqlSelect = "SELECT * FROM phone_number WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setDdd(rs.getInt("ddd"));
					to.setNumber(rs.getString("number"));
					to.setIdUser(rs.getInt("id_user"));
					to.setCreatedAt(rs.getTimestamp("created_at"));
					to.setUpdatedAt(rs.getTimestamp("updated_at"));
					to.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
			} catch (SQLException ex) {
				 throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return to;
	}
		
	
	public ArrayList<PhoneNumber> list() throws Exception  {
		ArrayList<PhoneNumber> phones = new ArrayList<PhoneNumber>();
		String sqlSelect = "SELECT * FROM phone_number WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					PhoneNumber to = new PhoneNumber(
						rs.getInt("id"),
						rs.getInt("ddd"),
						rs.getString("number"),
						rs.getInt("id_user"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
					);
					phones.add(to);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return phones;
	}
}
