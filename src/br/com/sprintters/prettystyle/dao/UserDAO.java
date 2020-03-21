package br.com.sprintters.prettystyle.dao;
package br.com.sprintters.prettystyle.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	public void create(User user) {
		String sqlInsert = "INSERT INTO user (name, surname, email, created_at) values (?,?,?, now())";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString(1, user.getName());
			stm.setString(2, user.getSurname());
			stm.setInt(3, user.getEmail());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(User user) {
		String sqlUpdate = "UPDATE user SET name = ?, surname = ? ,email = ? ,updated_at = now() where id = ?";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, user.getName());
			stm.setString(2, user.getSurname());
			stm.setString(3, user.getEmail());
			stm.setInt(4, user.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(User user) {
		String sqlUpdate = "UPDATE user SET deleted_at = now() where id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, user.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User find(int id) {
		User user = new User();
		String sqlSelect = "SELECT * FROM user where user.id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setSurname(rs.getString("surname"));
					user.setEmail(rs.getString("email"));
					user.setCreatedAt(rs.getTimestamp("created_at"));
					user.setUpdatedAt(rs.getTimestamp("updated_at"));
					user.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
				else {
					user.setId(0);
					user.setName(null);
					user.setSurname(null);
					user.setEmail(null);
					user.setCreatedAt(null);
					user.setUpdatedAt(null);
					user.setDeletedAt(null);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return user;
	}
		
	
	public ArrayList<User> list() throws Exception  {
		ArrayList<User> users = new ArrayList<User>();
		String sqlSelect = "SELECT * FROM user WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					User user = new User(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("surname"),
							rs.getString("email"),
							rs.getTimestamp("created_at"),
							rs.getTimestamp("updated_at"),
							rs.getTimestamp("deleted_at")
					);
					users.add(user);
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
