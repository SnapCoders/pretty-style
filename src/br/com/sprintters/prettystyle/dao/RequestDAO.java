package br.com.sprintters.prettystyle.dao;
package br.com.sprintters.prettystyle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestDAO {

	public void create(Request req) {		
		String sqlInsert = "INSERT INTO request (id_item, id_client, created_at) values (?, ?, now())";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, req.getIdItem());
			stm.setInt(2, req.getIdClient());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void update(Request req) {
		String sqlUpdate = "UPDATE request SET id_item = ?, id_client = ?, updated_at = now() where id = ?";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setInt(1, req.getIdItem());
			stm.setInt(2, req.getIdClient());
			stm.setInt(3, req.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete(Request req) {
		String sqlUpdate = "UPDATE request SET deleted_at = now() where id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, req.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Request find(int id) {
		Request req = new Request();
		String sqlSelect = "SELECT * FROM request where request.id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					req.setId(rs.getInt("id"));
					req.setItem(rs.getInt("id_item"));
					req.setIdClient(rs.getInt("id_client"));
					req.setCreatedAt(rs.getTimestamp("created_at"));
					req.setUpdatedAt(rs.getTimestamp("updated_at"));
					req.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
				else {
					req.setId(0);
					req.setIdItem(0);
					req.setIdClient(0);
					req.setCreatedAt(null);
					req.setUpdatedAt(null);
					req.setDeletedAt(null);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return req;
	}
	
	public ArrayList<Request> list() throws Exception  {
		ArrayList<Request> reqs = new ArrayList<Request>();
		String sqlSelect = "SELECT * FROM request WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Request req = new Request(
						rs.getInt("id"),
						rs.getInt("id_item"),
						rs.getInt("id_client"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
						
					);
					reqs.add(req);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return reqs;
	}
}
