package br.com.sprintters.prettystyle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.ClientProductLike;
import br.com.sprintters.prettystyle.model.Product;

public class ProductDAO {
	public int insert(Product to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO product (name, description, price, id_mark, created_at) VALUES (?, ?, ?, ?, NOW())";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setString(1, to.getName());
			stm.setString(2, to.getDescription());
			stm.setDouble(3, to.getPrice());
			stm.setInt(4, to.getIdMark());
			stm.execute();
			try (ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ID()")) {
				if (rs.next()) {				
					id = rs.getInt(1);
					to.setIdMark(id);
				}
				
				conn.close();
			} catch (SQLException e) {
				throw new Exception(e.getMessage());
			}
		} catch (SQLException ex) {
			throw new Exception(ex.getMessage());
		}
		
		return id;
	}
	
	public void update(Product to) throws Exception {
		String sqlUpdate = "UPDATE product SET name = ?, description = ?, price = ?, id_mark = ?, updated_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setString(1, to.getName());
			stm.setString(2, to.getDescription());
			stm.setDouble(3, to.getPrice());
			stm.setInt(4, to.getIdMark());
			stm.setInt(5, to.getId());
			
			stm.execute();
			
			conn.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void delete(Product to) throws Exception {
		String sqlDelete = "UPDATE product SET deleted_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
			stm.setInt(1, to.getId());
			
			stm.execute();
			
			conn.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Product find(int id) throws Exception {
		Product to = new Product();
		String sqlSelect = "SELECT * FROM product WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setName(rs.getString("name"));
					to.setDescription(rs.getString("description"));
					to.setPrice(rs.getDouble("price"));
					to.setIdMark(rs.getInt("id_mark"));
					to.setCreatedAt(rs.getTimestamp("created_at"));
					to.setUpdatedAt(rs.getTimestamp("updated_at"));
					to.setDeletedAt(rs.getTimestamp("deleted_at"));
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
	
	public ArrayList<Product> list() throws Exception  {
		ArrayList<Product> products = new ArrayList<Product>();
		String sqlSelect = "SELECT * FROM product WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Product to = new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getDouble("price"),
						rs.getInt("id_mark"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
						
					);
					products.add(to);
				}
				
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return products;
	}
	
	public ArrayList<Product> listBestSellers() throws Exception  {
		ArrayList<Product> products = new ArrayList<Product>();
		String sqlSelect = "SELECT * FROM product WHERE deleted_at IS NULL LIMIT 8";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Product to = new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getDouble("price"),
						rs.getInt("id_mark"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
						
					);
					products.add(to);
				}
				
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return products;
	}
	
	public ArrayList<Product> listByIdProvider(int idProvider) throws Exception  {
		ArrayList<Product> products = new ArrayList<Product>();
		String sqlSelect = "SELECT * FROM product WHERE id_provider = ? AND deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			
			stm.setInt(1, idProvider);
			
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Product to = new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getDouble("price"),
						rs.getInt("id_mark"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
						
					);
					
					products.add(to);
				}
				
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return products;
	}
	
	public int createFavorite(ClientProductLike to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO client_product_like (id_user, id_product, action) VALUES (?, ?, ?)";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setInt(1, to.getIdUser());
			stm.setInt(2, to.getIdProduct());
			stm.setInt(3, to.getAction());
			
			stm.execute();
			
			try (ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ID()")) {
				if (rs.next()) {				
					id = rs.getInt(1);
					to.setId(id);
				}
				
				conn.close();
			} catch (SQLException e) {
				throw new Exception(e.getMessage());
			}
		} catch (SQLException ex) {
			throw new Exception(ex.getMessage());
		}
		
		return id;
	}
	
	public ArrayList<ClientProductLike> listFavoritesByIdUser(int idUser) throws Exception  {
		ArrayList<ClientProductLike> productsLiked = new ArrayList<ClientProductLike>();
		String sqlSelect = "SELECT\r\n" + 
				"	p.id\r\n" + 
				"    , p.name\r\n" + 
				"    , p.description\r\n" + 
				"    , p.price\r\n" + 
				"    , p.id_mark\r\n" +
				"    , cpl.id as 'id_cpl'\r\n" +
				"    , cpl.id_product\r\n" + 
				"    , cpl.id_user\r\n" + 
				"    , cpl.action\r\n" + 
				"FROM\r\n" + 
				"	client_product_like cpl\r\n" + 
				"    INNER JOIN product p ON cpl.id_product = p.id\r\n" + 
				"WHERE cpl.id_user = ? AND cpl.action = 1 AND p.deleted_at IS NULL;";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			
			stm.setInt(1, idUser);
			
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Product to = new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getDouble("price"),
						rs.getInt("id_mark")
					);
					
					ClientProductLike cpl = new ClientProductLike(
						rs.getInt("id_cpl"),
						rs.getInt("id_product"),
						rs.getInt("id_user"),
						rs.getInt("action")
					);
					
					cpl.setProduct(to);
					
					productsLiked.add(cpl);
				}
				
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return productsLiked;
	}
	
	public ClientProductLike listFavoriteByIdUserAndIdProduct(int idUser, int idProduct) throws Exception {
		ClientProductLike to = new ClientProductLike();
		String sqlSelect = "SELECT * FROM client_product_like WHERE id_user = ? AND id_product = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, idUser);
			stm.setInt(2, idProduct);
			
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setIdUser(idUser);
					to.setIdProduct(idProduct);
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
	
	public void deleteFavoriteById(int id) throws Exception {
		String sqlDelete = "DELETE FROM client_product_like WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
			stm.setInt(1, id);
			
			stm.execute();
			
			conn.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
}
