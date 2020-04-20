package br.com.sprintters.prettystyle.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.Request;

public class RequestDAO {
	public int insert(Request to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO request (total_price, id_client, number_request, type_payment, created_at) VALUES (?, ?, ?, ?, NOW())";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setDouble(1, to.getTotalPrice());
			stm.setInt(2, to.getIdClient());
			stm.setString(3, to.getNumberRequest());
			stm.setString(4, to.getTypePayment());
			
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
	
	public void update(Request to) throws Exception {
		String sqlUpdate = "UPDATE request SET id_item = ?, id_client = ?, updated_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setDouble(1, to.getTotalPrice());
			stm.setInt(2, to.getIdClient());
			stm.setInt(3, to.getId());
			
			stm.execute();
			
			conn.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void delete(Request to) throws Exception {
		String sqlDelete = "UPDATE request SET deleted_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
			stm.setInt(1, to.getId());
			
			stm.execute();
			
			conn.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Request find(int id) throws Exception {
		Request to = new Request();
		String sqlSelect = "SELECT * FROM request where request.id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setNumberRequest(rs.getString("number_request"));
					to.setTotalPrice(rs.getDouble("total_price"));
					to.setIdClient(rs.getInt("id_client"));
					to.setCreatedAt(rs.getTimestamp("created_at"));
					to.setUpdatedAt(rs.getTimestamp("updated_at"));
					to.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
				
				conn.close();
			} catch(SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return to;
	}
	
	public ArrayList<Request> list() throws Exception  {
		ArrayList<Request> reqs = new ArrayList<Request>();
		String sqlSelect = "SELECT * FROM request WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Request to = new Request(
						rs.getInt("id"),	
						rs.getInt("id_client"),
						rs.getDouble("total_price"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
					);
						
					reqs.add(to);
				}
				
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return reqs;
	}
	
	public ArrayList<Request> listRequestsByIdClient(int idClient) throws Exception  {
		ArrayList<Request> reqs = new ArrayList<Request>();
		String sqlSelect = "SELECT\r\n" + 
				"	p.name\r\n" + 
				"    , p.description\r\n" + 
				"    , p.price\r\n" + 
				"    , p.id_mark\r\n" + 
				"    , r.id_client\r\n" + 
				"FROM\r\n" + 
				"	product p\r\n" + 
				"    INNER JOIN item i on p.id = i.id_product\r\n" + 
				"    INNER JOIN request r on i.id_request = r.id\r\n" + 
				"WHERE r.id_client = ?;";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, idClient);
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Product p = new Product(
						rs.getString("name"),	
						rs.getString("description"),
						rs.getDouble("price"),
						rs.getInt("id_mark")
					);
					Request to = new Request(p,rs.getInt("id_client"));
					reqs.add(to);
				}
				
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return reqs;
	}
}
