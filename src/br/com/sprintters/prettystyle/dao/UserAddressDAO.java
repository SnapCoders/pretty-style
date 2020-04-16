package br.com.sprintters.prettystyle.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import br.com.sprintters.prettystyle.model.UserAddress;

public class UserAddressDAO {
	public void insert(UserAddress to) throws Exception {
		String sqlInsert = "INSERT INTO UserAddress (id_user, id_address) VALUES (?, ?)";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setInt(1, to.getIdUser());
			stm.setInt(2, to.getIdAddress());
			
			stm.execute();
			
			conn.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void update(UserAddress to) throws Exception {
		String sqlUpdate = "UPDATE UserAddress SET id_user = ?, id_address = ? WHERE id_user = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setInt(1, to.getIdUser());
			stm.setInt(2, to.getIdAddress());
			stm.setInt(3, to.getIdUser());
			
			stm.execute();
			
			conn.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void delete(UserAddress to) throws Exception {
		String sqlDelete = "DELETE FROM UserAddress WHERE id_user = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
			stm.setInt(1, to.getIdUser());
			
			stm.execute();
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public UserAddress find(int id) throws Exception {
		UserAddress to = new UserAddress();
		String sqlSelect = "SELECT * FROM UserAddress WHERE id_user = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					to.setIdUser(rs.getInt("id_user"));
					to.setIdAddress(rs.getInt("id_address"));
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return to;
	}
}
