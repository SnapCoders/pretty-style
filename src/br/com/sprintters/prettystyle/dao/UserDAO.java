package br.com.sprintters.prettystyle.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;

import br.com.sprintters.prettystyle.model.User;

public class UserDAO {
	public int insert(User to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO user (username, name, surname, email, email_confirmation, password_hash, birthday, sex, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW())";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setString(1, to.getUsername());
			stm.setString(2, to.getName());
			stm.setString(3, to.getSurname());
			stm.setString(4, to.getEmail());
			stm.setString(5, to.getEmailConfirmation());
			stm.setString(6, to.getPasswordHash());
			stm.setDate(7, new java.sql.Date(to.getBirthday().getTime()));
			
			to.setSex("M");
			
			stm.setString(8, to.getSex());
			stm.execute();
			
			try (ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ID()")) {
				if (rs.next()) {
					id = rs.getInt(1);
					to.setId(id);
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
	
	public void update(User to) throws Exception {
		String sqlUpdate = "UPDATE user SET username = ?, name = ?, surname = ? , email = ?, email_confirmation = ?, password_hash = ?, birthday = ?, sex = ?, updated_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setString(1, to.getUsername());
			stm.setString(2, to.getName());
			stm.setString(3, to.getSurname());
			stm.setString(4, to.getEmail());
			stm.setString(5, to.getEmailConfirmation());
			stm.setString(6, to.getPasswordHash());
			stm.setDate(7, (Date)to.getBirthday());
			stm.setString(8, to.getSex());
			stm.setInt(9, to.getId());
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
					to.setUsername(rs.getString("username"));
					to.setName(rs.getString("name"));
					to.setSurname(rs.getString("surname"));
					to.setEmail(rs.getString("email"));
					to.setEmailConfirmation(rs.getString("email_confirmation"));
					to.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("birthday")));
					to.setSex(rs.getString("sex"));
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
							rs.getString("username"),
							rs.getString("name"),
							rs.getString("surname"),
							rs.getString("email"),
							rs.getString("email_confirmation"),
							rs.getDate("birthday"),
							rs.getString("sex"),
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
	
	public User findByEmail(String email) throws Exception {
		User to = new User();
		String sqlSelect = "SELECT * FROM user WHERE email = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setString(1, email);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setUsername(rs.getString("username"));
					to.setName(rs.getString("name"));
					to.setSurname(rs.getString("surname"));
					to.setEmail(rs.getString("email"));
					to.setEmailConfirmation(rs.getString("email_confirmation"));
					to.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("birthday")));
					to.setSex(rs.getString("sex"));
					to.setCreatedAt(rs.getTimestamp("created_at"));
					to.setUpdatedAt(rs.getTimestamp("updated_at"));
					to.setDeletedAt(rs.getTimestamp("deleted_at"));
					to.setPasswordHash(rs.getString("password_hash"));
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return to;
	}
	
	public User findByUsername(String username) throws Exception {
		User to = new User();
		String sqlSelect = "SELECT * FROM user WHERE username = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setString(1, username);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setUsername(rs.getString("username"));
					to.setName(rs.getString("name"));
					to.setSurname(rs.getString("surname"));
					to.setEmail(rs.getString("email"));
					to.setEmailConfirmation(rs.getString("email_confirmation"));
					to.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("birthday")));
					to.setSex(rs.getString("sex"));
					to.setCreatedAt(rs.getTimestamp("created_at"));
					to.setUpdatedAt(rs.getTimestamp("updated_at"));
					to.setDeletedAt(rs.getTimestamp("deleted_at"));
					to.setPasswordHash(rs.getString("password_hash"));
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
