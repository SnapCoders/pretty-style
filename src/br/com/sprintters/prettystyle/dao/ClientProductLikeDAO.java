package br.com.sprintters.prettystyle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sprintters.prettystyle.model.ClientProductLike;

public class ClientProductLikeDAO {
	public int insert(ClientProductLike to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO client_product_like (id_product, id_client, action) VALUES (?, ?, ?);";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setInt(1, to.getIdProduct());
			stm.setInt(2, to.getIdUser());
			stm.setInt(3, to.getAction());
			stm.execute();
			try (ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ID()")) {
				if (rs.next()) {				
					to.setIdUser(rs.getInt(1));
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
	
	public void update(ClientProductLike to) throws Exception {
		String sqlUpdate = "UPDATE client_product_like SET id_product = ?, id_client = ?, action = ? updated_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setInt(1, to.getIdProduct());
			stm.setInt(2, to.getIdUser());
			stm.setInt(3, to.getAction());
			stm.setInt(4, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void delete(ClientProductLike to) throws Exception {
		String sqlDelete = "UPDATE client_product_like SET deleted_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
		
	public ClientProductLike find(int idProduct, int idClient) throws Exception {
		ClientProductLike to = new ClientProductLike();
		String sqlSelect = "select * from client_product_like where id_product = ? and id_client = ?;";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, idProduct);
			stm.setInt(2, idClient);
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					to.setIdUser(rs.getInt("id_product"));
					to.setIdProduct(rs.getInt("id_client"));
					to.setAction(rs.getInt("action"));
				}
				
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return to;
	}
//	public ArrayList<ClientProductLike> listProductLikeByIdClient(int idClient) throws Exception {
//		ArrayList<ClientProductLike> clientProductLike = new ArrayList<ClientProductLike>();
//		String sqlSelect = "SELECT\r\n" + 
//				"	i.quantity\r\n" + 
//				"    , p.name\r\n" + 
//				"    , p.description\r\n" + 
//				"    , p.price\r\n" +
//				"    , q.action\r\n" +
//				"FROM\r\n" + 
//				"	item i\r\n" + 
//				"    INNER JOIN product p ON i.id_product = p.id\r\n" + 
//				"    INNER JOIN client_product_like" +
//				"WHERE id_client = ?;";
//		
//		try (Connection conn = ConnectionFactory.createConnection();
//			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
//			stm.setInt(1, idClient);
//			
//			try (ResultSet rs = stm.executeQuery()) {
//				while (rs.next()) {
//					ClientProductLike to = new ClientProductLike(
//						rs.getString("name"),	
//						rs.getString("description"),
//						rs.getInt("price"),
//						rs.getInt("action")
//					);
//					clientProductLike.add(to);
//				}
//				conn.close();
//			} catch (SQLException ex) {
//				throw new Exception(ex.getMessage());
//			}
//		} catch (SQLException e) {
//			throw new Exception(e.getMessage());
//		}
//		
//		return clientProductLike;
//	}
}
