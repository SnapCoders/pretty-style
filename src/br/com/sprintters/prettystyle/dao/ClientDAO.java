package br.com.sprintters.prettystyle.dao;
package br.com.sprintters.prettystyle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {
	public void create(Client client) {
		String sqlInsert = "INSERT INTO client (cpf, id_user, created_at) values (?,?, now())";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString(1, client.getCpf());
			stm.setInt(2, client.getIdUser());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Client client) {
		String sqlUpdate = "UPDATE client SET cpf = ?, id_user = ?, updated_at = now() where id = ?";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, client.getCpf());
			stm.setInt(2, client.getIdUser());
			stm.setInt(3, client.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Client client) {
		String sqlUpdate = "UPDATE client SET deleted_at = now() where id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, client.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Client find(int id) {
		Client client = new Client();
		String sqlSelect = "SELECT * FROM client where client.id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					client.setId(rs.getInt("id"));
					client.setCpf(rs.getString("cpf"));
					client.setIdUser(rs.getInt("id_user"));
					client.setCreatedAt(rs.getTimestamp("created_at"));
					client.setUpdatedAt(rs.getTimestamp("updated_at"));
					client.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
				else {
					client.setId(0);
					client.setCpf(null);
					client.setIdUser(0);
					client.setCreatedAt(null);
					client.setUpdatedAt(null);
					client.setDeletedAt(null);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return client;
	}
		
	
	public ArrayList<Client> list() throws Exception  {
		ArrayList<Client> clients = new ArrayList<Client>();
		String sqlSelect = "SELECT * FROM client WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Client client = new Client(
						rs.getInt("id"),
						rs.getString("cpf"),
						rs.getInt("id_user"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
					);
					clients.add(client);
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
