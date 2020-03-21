package br.com.sprintters.prettystyle.dao;
package br.com.sprintters.prettystyle.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneNumberDAO {

	public void create(PhoneNumber phone) {
		String sqlInsert = "INSERT INTO phone_number (ddd, number, id_user, created_at) values (?,?,?, now())";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, phone.getDdd());
			stm.setString(2, phone.getNumber());
			stm.setInt(3, phone.getIdUser());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(PhoneNumber phone) {
		String sqlUpdate = "UPDATE phone_number SET ddd = ?, number = ? ,id_user = ?, updated_at = now() where id = ?";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setInt(1, phone.getDdd());
			stm.setString(2, phone.getNumber());
			stm.setInt(3, phone.getIdUser());
			stm.setInt(4, phone.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(PhoneNumber phone) {
		String sqlUpdate = "UPDATE phone_number SET deleted_at = now() where id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, phone.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public PhoneNumber find(int id) {
		PhoneNumber phone = new PhoneNumber();
		String sqlSelect = "SELECT * FROM phone_number where phone_number.id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					phone.setId(rs.getInt("id"));
					phone.setDdd(rs.getInt("ddd"));
					phone.setNumber(rs.getString("number"));
					phone.setIdUser(rs.getInt("id_user"));
					phone.setCreatedAt(rs.getTimestamp("created_at"));
					phone.setUpdatedAt(rs.getTimestamp("updated_at"));
					phone.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
				else {
					phone.setId(0);
					phone.setDdd(0);
					phone.setNumber(null);
					phone.setIdUser(0);
					phone.setCreatedAt(null);
					phone.setUpdatedAt(null);
					phone.setDeletedAt(null);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return phone;
	}
		
	
	public ArrayList<PhoneNumber> list() throws Exception  {
		ArrayList<PhoneNumber> phones = new ArrayList<PhoneNumber>();
		String sqlSelect = "SELECT * FROM phone_number WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					PhoneNumber phone = new PhoneNumber(
						rs.getInt("id"),
						rs.getInt("ddd"),
						rs.getString("number"),
						rs.getInt("id_user"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
					);
					phones.add(phone);
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
