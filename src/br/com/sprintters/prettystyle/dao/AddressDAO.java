package br.com.sprintters.prettystyle.dao;
package br.com.sprintters.prettystyle.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAO {
	
	public void create(Address addr) {
		String sqlInsert = "INSERT INTO address (place, number, neighborhood, city, country, zip, complement , id_user, created_at) values (?,?,?,?,?,?,?,?,now())";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString(1, addr.getPlace());
			stm.setString(2, addr.getNumber());
			stm.setString(3, addr.getNeighborhood());
			stm.setString(4, addr.getCity());
			stm.setString(5, addr.getCountry());
			stm.setString(6, addr.getZip());
			stm.setString(7, addr.getComplement());
			stm.setInt(8, addr.getIdUser());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Address addr) {
		String sqlUpdate = "UPDATE address SET place = ?, number = ?, neighborhood = ?, city = ?, country = ?, zip = ?, complement = ?, id_user = ?, updated_at = now() where id = ?";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, addr.getPlace());
			stm.setString(2, addr.getNumber());
			stm.setString(3, addr.getNeighborhood());
			stm.setString(4, addr.getCity());
			stm.setString(5, addr.getCountry());
			stm.setString(6, addr.getZip());
			stm.setString(7, addr.getComplement());
			stm.setInt(8, addr.getIdUser());
			stm.setInt(9, addr.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Address addr) {
		String sqlUpdate = "UPDATE address SET deleted_at = now() where id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, addr.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
		
	public Address find(int id) {
		Address addr = new Address();
		String sqlSelect = "SELECT * FROM address where address.id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					addr.setId(rs.getInt("id"));
					addr.setPlace(rs.getString("place"));
					addr.setNumber(rs.getString("number"));
					addr.setNeighborhood(rs.getString("neighborhood"));
					addr.setCity(rs.getString("city"));
					addr.setCountry(rs.getString("country"));
					addr.setZip(rs.getString("zip"));
					addr.setComplement(rs.getString("complement"));					
					addr.setIdUser(rs.getInt("id_user"));
					addr.setCreatedAt(rs.getTimestamp("created_at"));
					addr.setUpdatedAt(rs.getTimestamp("updated_at"));
					addr.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
				else {
					addr.setId(0);
					addr.setPlace(null);
					addr.setNumber(null);
					addr.setNeighborhood(null);
					addr.setCity(null);
					addr.setCountry(null);
					addr.setZip(null);
					addr.setComplement(null);					
					addr.setIdUser(0);
					addr.setCreatedAt(null);
					addr.setUpdatedAt(null);
					addr.setDeletedAt(null);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return addr;
	}
	
    place			varchar(150) not null,
    number			varchar(12) not null,
    neighborhood	varchar(100) not null,
    city			varchar(80) not null,
    country			varchar(80) not null,
    zip				varchar(8) not null,
    complement		varchar(250) not null,
	
	public ArrayList<Address> list() throws Exception  {
		ArrayList<Address> address = new ArrayList<Address>();
		String sqlSelect = "SELECT * FROM address WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Address addr = new Address(
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
					address.add(addr);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return address;
	}
}
