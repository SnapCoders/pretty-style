package br.com.sprintters.prettystyle.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import br.com.sprintters.prettystyle.model.User;

public class UserDAO {
	public int insert(User to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO user (name, surname, email, created_at) VALUES (?, ?, ?, NOW())";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setString(1, to.getName());
			stm.setString(2, to.getSurname());
			stm.setString(3, to.getEmail());
			stm.execute();
			try (ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ID()")) {
				if (rs.next()) {
					id = rs.getInt(1);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return id;
	}
	
	public void update(User to) throws Exception {
		String sqlUpdate = "UPDATE user SET name = ?, surname = ? ,email = ? ,updated_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setString(1, to.getName());
			stm.setString(2, to.getSurname());
			stm.setString(3, to.getEmail());
			stm.setInt(4, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void delete(User to) throws Exception {
		String sqlDelete = "UPDATE user SET deleted_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public User find(int id) throws Exception {
		User to = new User();
		String sqlSelect = "SELECT * FROM user WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setName(rs.getString("name"));
					to.setSurname(rs.getString("surname"));
					to.setEmail(rs.getString("email"));
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
	
	public ArrayList<User> list() throws Exception  {
		ArrayList<User> users = new ArrayList<User>();
		String sqlSelect = "SELECT * FROM user WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					User to = new User(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("surname"),
							rs.getString("email"),
							rs.getTimestamp("created_at"),
							rs.getTimestamp("updated_at"),
							rs.getTimestamp("deleted_at")
					);
					users.add(to);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return users;
	}
}
