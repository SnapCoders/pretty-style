package br.com.sprintters.prettystyle.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.sprintters.prettystyle.model.Item;
import br.com.sprintters.prettystyle.model.Mark;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.ProductPhoto;
import br.com.sprintters.prettystyle.model.virtual.Cart;

import java.sql.PreparedStatement;

public class ItemDAO {
	public int insert(Item to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO item (quantity, id_product, id_client, created_at) values (?, ?, ?, now())";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setInt(1, to.getQuantity());
			stm.setInt(2, to.getIdProduct());
			stm.setInt(3, to.getIdClient());
			
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
	
	public void update(Item to) throws Exception {
		String sqlUpdate = "UPDATE item SET quantity = ?, id_product = ?, updated_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setInt(1, to.getQuantity());
			stm.setInt(2, to.getIdProduct());
			stm.setInt(3, to.getId());
			
			stm.execute();
			
			conn.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void delete(Item to) throws Exception {
		String sqlDelete = "UPDATE item SET deleted_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
			stm.setInt(1, to.getId());
			
			stm.execute();
			
			conn.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Item find(int id) throws Exception {
		Item to = new Item();
		String sqlSelect = "SELECT * FROM item WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setQuantity(rs.getInt("quantity"));
					to.setIdProduct(rs.getInt("id_product"));
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
	
	public ArrayList<Item> list() throws Exception  {
		ArrayList<Item> items = new ArrayList<Item>();
		String sqlSelect = "SELECT * FROM item WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Item to = new Item(
						rs.getInt("id"),
						rs.getInt("quantity"),
						rs.getInt("id_product"),
						rs.getInt("id_request"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
					);
						
					items.add(to);
				}
				
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return items;
	}
	
	public Cart listItemsInCartByIdClient(int idClient) throws Exception {
		Cart cart = new Cart();
		
		String sqlSelect = "SELECT\r\n" + 
				"	p.id\r\n" + 
				"    , p.name\r\n" + 
				"    , p.description\r\n" + 
				"    , p.price\r\n" + 
				"    , p.created_at\r\n" + 
				"    , p.id_mark\r\n" + 
				"    , m.name as 'mark'\r\n" + 
				"    , pp.id as 'id_photo'\r\n" + 
				"    , pp.url\r\n" + 
				"    , i.id as 'id_item'\r\n" + 
				"    , i.quantity\r\n" + 
				"FROM\r\n" + 
				"	product p\r\n" + 
				"    LEFT JOIN product_photo pp ON p.id = pp.id_product\r\n" + 
				"    INNER JOIN mark m ON p.id_mark = m.id\r\n" + 
				"    INNER JOIN item i ON p.id = i.id_product\r\n" + 
				"WHERE i.id_client = ?;";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, idClient);
			
			try (ResultSet rs = stm.executeQuery()) {
				int prevIdProduct = 0;
				
				Product product = null;
				ArrayList<ProductPhoto> photos = null;
				
				while (rs.next()) {
					int idProduct = rs.getInt("id");
					int idProductPhoto = rs.getInt("id_photo");
					
					if (idProduct != prevIdProduct) {
						Item item = new Item();
						
						item.setId(rs.getInt("id_item"));
						item.setQuantity(rs.getInt("quantity"));
						
						product = new Product();
						
						product.setId(idProduct);
						product.setName(rs.getString("name"));
						product.setDescription(rs.getString("description"));
						product.setPrice(rs.getDouble("price"));
						//product.setCreatedAt(rs.getDate("created_at"));
						product.setIdMark(rs.getInt("id_mark"));
						
						Mark mark = new Mark();
						
						mark.setId(rs.getInt("id_mark"));
						mark.setName(rs.getString("mark"));
						
						product.setMark(mark);
						
						item.setProduct(product);
						cart.getItems().add(item);
						prevIdProduct = idProduct;
						
						photos = new ArrayList<ProductPhoto>();
						
						ProductPhoto photo = new ProductPhoto();
						
						photo.setId(idProductPhoto);
						photo.setUrl(rs.getString("url"));
						
						photos.add(photo);
					} else {
						ProductPhoto photo = new ProductPhoto();
						
						photo.setId(idProductPhoto);
						photo.setUrl(rs.getString("url"));
						
						photos.add(photo);
					}
					
					product.setPhotos(photos);
				}
				
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return cart;
	}
}
