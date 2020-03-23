package br.com.sprintters.prettystyle.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;

import br.com.sprintters.prettystyle.model.Client;

import java.sql.PreparedStatement;

public class ClientDAO {
	public int insert(Client to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO client (cpf, id_user, created_at) VALUES (?, ?, NOW())";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setString(1, to.getCpf());
			stm.setInt(2, to.getIdUser());
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
	
	public void update(Client to) throws Exception {
		String sqlUpdate = "UPDATE client SET cpf = ?, id_user = ?, updated_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setString(1, to.getCpf());
			stm.setInt(2, to.getIdUser());
			stm.setInt(3, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void delete(Client to) throws Exception {
		String sqlDelete = "UPDATE client SET deleted_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Client find(int id) throws Exception {
		Client to = new Client();
		String sqlSelect = "SELECT * FROM client WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setCpf(rs.getString("cpf"));
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
	
	public ArrayList<Client> list() throws Exception  {
		ArrayList<Client> clients = new ArrayList<Client>();
		String sqlSelect = "SELECT * FROM client WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Client to = new Client(
						rs.getInt("id"),
						rs.getString("cpf"),
						rs.getInt("id_user"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
					);
					clients.add(to);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return clients;
	}
}
