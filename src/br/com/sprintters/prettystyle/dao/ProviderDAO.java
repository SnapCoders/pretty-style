package br.com.sprintters.prettystyle.dao;
package br.com.sprintters.prettystyle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProviderDAO {

	public void create(Provider prov) {
		String sqlInsert = "INSERT INTO provider (cnpj, id_user, created_at) values (?,?, now())";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString(1, prov.getCnpj());
			stm.setInt(2, prov.getIdUser());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Provider prov) {
		String sqlUpdate = "UPDATE provider SET cnpj = ?, id_user = ?, updated_at = now() where id = ?";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, prov.getCnpj());
			stm.setInt(2, prov.getIdUser());
			stm.setInt(3, prov.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Provider prov) {
		String sqlUpdate = "UPDATE provider SET deleted_at = now() where id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, prov.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Provider find(int id) {
		Provider prov = new Provider();
		String sqlSelect = "SELECT * FROM provider where provider.id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					prov.setId(rs.getInt("id"));
					prov.setCnpj(rs.getString("cnpj"));
					prov.setIdUser(rs.getInt("id_user"));
					prov.setCreatedAt(rs.getTimestamp("created_at"));
					prov.setUpdatedAt(rs.getTimestamp("updated_at"));
					prov.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
				else {
					prov.setId(0);
					prov.setCnpj(null);
					prov.setIdUser(0);
					prov.setCreatedAt(null);
					prov.setUpdatedAt(null);
					prov.setDeletedAt(null);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return mark;
	}
		
	
	public ArrayList<Provider> list() throws Exception  {
		ArrayList<Provider> providers = new ArrayList<Provider>();
		String sqlSelect = "SELECT * FROM provider WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Provider prov = new Provider(
						rs.getInt("id"),
						rs.getString("cnpj"),
						rs.getInt("id_user"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
					);
					providers.add(prov);
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
