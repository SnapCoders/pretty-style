package br.com.sprintters.prettystyle.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import br.com.sprintters.prettystyle.model.Address;

public class AddressDAO {
	public int insert(Address to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO address (place, number, neighborhood, city, country, zip, complement , id_user"
								+ ", created_at, updated_at, deleted_at) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, "
								+ "NOW(), NULL, NULL)";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setString(1, to.getPlace());
			stm.setString(2, to.getNumber());
			stm.setString(3, to.getNeighborhood());
			stm.setString(4, to.getCity());
			stm.setString(5, to.getCountry());
			stm.setString(6, to.getZip());
			stm.setString(7, to.getComplement());
			stm.setInt(8, to.getIdUser());
			stm.execute();
			try (ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ID()")) {
				if (rs.next()) {				
					to.setId(rs.getInt(1));
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
	
	public void update(Address to) throws Exception {
		String sqlUpdate = "UPDATE address SET place = ?, number = ?, neighborhood = ?, city = ?, country = ?, zip = ?, complement = ?, id_user = ?, updated_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setString(1, to.getPlace());
			stm.setString(2, to.getNumber());
			stm.setString(3, to.getNeighborhood());
			stm.setString(4, to.getCity());
			stm.setString(5, to.getCountry());
			stm.setString(6, to.getZip());
			stm.setString(7, to.getComplement());
			stm.setInt(8, to.getIdUser());
			stm.setInt(9, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void delete(Address to) throws Exception {
		String sqlDelete = "UPDATE address SET deleted_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
		
	public Address find(int id) throws Exception {
		Address to = new Address();
		String sqlSelect = "SELECT * FROM address WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setPlace(rs.getString("place"));
					to.setNumber(rs.getString("number"));
					to.setNeighborhood(rs.getString("neighborhood"));
					to.setCity(rs.getString("city"));
					to.setCountry(rs.getString("country"));
					to.setZip(rs.getString("zip"));
					to.setComplement(rs.getString("complement"));
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
	
	public ArrayList<Address> list() throws Exception {
		ArrayList<Address> addresses = new ArrayList<Address>();
		String sqlSelect = "SELECT * FROM address WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Address to = new Address(
						rs.getInt("id"),
						rs.getString("place"),
						rs.getString("number"),
						rs.getString("neighborhood"),
						rs.getString("city"),
						rs.getString("country"),
						rs.getString("zip"),
						rs.getString("complement"),						
						rs.getInt("id_user"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
					);
					addresses.add(to);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return addresses;
	}
}
