package br.com.sprintters.prettystyle.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import br.com.sprintters.prettystyle.model.Provider;

import java.sql.PreparedStatement;

public class ProviderDAO {
	public int create(Provider to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO provider (cnpj, fantasyName, socialReason, contact, id_user, created_at) VALUES (?, ?, ?, ?, ?, NOW())";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setString(1, to.getCnpj());
			stm.setInt(2, to.getIdUser());
			stm.setString(3, to.getFantasyName());
			stm.setString(4, to.getSocialReason());
			stm.setString(5, to.getContact());
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
	
	public void update(Provider to) throws Exception {
		String sqlUpdate = "UPDATE provider SET cnpj = ?, fantasyName = ?, socialReason = ?, contact = ?, id_user = ?, updated_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setString(1, to.getCnpj());
			stm.setString(2, to.getFantasyName());
			stm.setString(3, to.getSocialReason());
			stm.setString(4, to.getContact());
			stm.setInt(5, to.getIdUser());
			stm.setInt(6, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void delete(Provider to) throws Exception {
		String sqlDelete = "UPDATE provider SET deleted_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Provider find(int id) throws Exception {
		Provider to = new Provider();
		String sqlSelect = "SELECT * FROM provider WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setCnpj(rs.getString("cnpj"));
					to.setIdUser(rs.getInt("id_user"));
					to.setCreatedAt(rs.getTimestamp("created_at"));
					to.setUpdatedAt(rs.getTimestamp("updated_at"));
					to.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
			} catch (SQLException e) {
				throw new Exception(e.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return to;
	}
	
	public Provider findByIdUser(int idUser) throws Exception {
		Provider to = new Provider();
		String sqlSelect = "SELECT * FROM client WHERE id_user = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, idUser);
			
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setFantasyName(rs.getString("fantasy_name"));
					to.setSocialReason(rs.getString("social_reason"));
					to.setContact(rs.getString("contact"));
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
	
	public ArrayList<Provider> list() throws Exception  {
		ArrayList<Provider> providers = new ArrayList<Provider>();
		String sqlSelect = "SELECT * FROM provider WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Provider to = new Provider(
						rs.getInt("id"),
						rs.getString("cnpj"),
						rs.getString("fantasyName"),
						rs.getString("socialReason"),
						rs.getString("contact"),
						rs.getInt("id_user"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
					);
					providers.add(to);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return providers;
	}
}
