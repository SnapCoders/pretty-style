package br.com.sprintters.prettystyle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.Category;
import br.com.sprintters.prettystyle.model.ClientProductLike;
import br.com.sprintters.prettystyle.model.Mark;
import br.com.sprintters.prettystyle.model.Product;
import br.com.sprintters.prettystyle.model.ProductPhoto;
import br.com.sprintters.prettystyle.model.Stock;

public class ProductDAO {
	public int insert(Product to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO product (name, description, price, id_mark, id_provider,id_stock, created_at) VALUES (?, ?, ?, ?, ?, ?, NOW())";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setString(1, to.getName());
			stm.setString(2, to.getDescription());
			stm.setDouble(3, to.getPrice());
			stm.setInt(4, to.getIdMark());
			stm.setInt(5, to.getIdProvider());
			stm.setInt(6, to.getIdStock());
			
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
					to.setIdStock(rs.getInt("id_stock"));
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
		String sqlSelect = "SELECT\r\n" + 
				"	p.id\r\n" + 
				"    , p.*\r\n" +
				"    , m.id\r\n" +
				"    , m.name as 'mark'\r\n" +
				"    , pp.id as 'id_photo'\r\n" + 
				"    , pp.url\r\n" + 
				"    , pp.name as 'photo_name'\r\n" + 
				"FROM\r\n" + 
				"	product p\r\n" + 
				"   INNER JOIN product_photo pp ON p.id = pp.id_product\r\n" +  
				"    INNER JOIN mark m ON p.id_mark = m.id\r\n" + 
				"WHERE p.deleted_at IS NULL LIMIT 16;";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				int prevIdProduct = 0;
				
				Product product = null;
				ArrayList<ProductPhoto> photos = null;
				
				while (rs.next()) {
					int idProduct = rs.getInt("id");
					int idProductPhoto = rs.getInt("id_photo");
					
					if (idProduct != prevIdProduct) {
						product = new Product(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("description"),
							rs.getDouble("price"),
							rs.getInt("id_mark"),
							rs.getTimestamp("created_at"),
							rs.getTimestamp("updated_at"),
							rs.getTimestamp("deleted_at")
						);
						
						Mark mark = new Mark();
						
						mark.setId(rs.getInt("id_mark"));
						mark.setName(rs.getString("mark"));
						
						product.setMark(mark);
						
						prevIdProduct = idProduct;
						
						photos = new ArrayList<ProductPhoto>();
						
						ProductPhoto photo = new ProductPhoto();
						
						photo.setId(idProductPhoto);
						photo.setUrl(rs.getString("url"));
						photo.setName(rs.getString("photo_name"));
						
						photos.add(photo);
						
						products.add(product);
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
		
		return products;
	}
	
	public ArrayList<Product> listByIdProvider(int idProvider) throws Exception  {
		ArrayList<Product> products = new ArrayList<Product>();
		String sqlSelect = "SELECT p.id, p.name, p.description, p.price, p.id_mark, p.id_stock, p.created_at, p.updated_at, p.deleted_at, s.quantity "
				+ "FROM product p inner join stock s on p.id_stock = s.id WHERE id_provider = ? AND p.deleted_at IS NULL";
		
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
						rs.getInt("id_stock"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
					);
					Stock stock = new Stock(rs.getInt("quantity"));
					to.setStock(stock);
					
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
	
	public ArrayList<Product> findByName(String filter) throws Exception  {
		ArrayList<Product> products = new ArrayList<Product>();
		String sqlSelect = "SELECT * FROM product WHERE NAME LIKE '%" + filter + "%' AND deleted_at IS NULL;";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Product to = new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getDouble("price"),
						rs.getInt("id_mark")
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
	
	public ArrayList<Product> findByCategory(String filter) throws Exception  {
		ArrayList<Product> products = new ArrayList<Product>();
		String sqlSelect = "SELECT\r\n" + 
				"	*\r\n" + 
				"FROM\r\n" + 
				"	product p\r\n" + 
				"    INNER JOIN product_category pc ON p.id = pc.id_product\r\n" + 
				"    INNER JOIN category c ON pc.id_category = c.id\r\n" + 
				"WHERE c.name LIKE '%" + filter + "%' AND p.deleted_at IS NULL AND c.deleted_at IS NULL;";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Product to = new Product(
						rs.getInt("p.id"),
						rs.getString("p.name"),
						rs.getString("p.description"),
						rs.getDouble("p.price"),
						rs.getInt("p.id_mark")
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
	
	public Product findProductAndCategory(int id) throws Exception {
		Product to = new Product();
		ArrayList<Category> categories = new ArrayList<Category>();
		String sqlSelect = "select p.id, p.name, p.description, p.price, p.id_mark,pc.id_category, c.name, c.color from product p "
				+ "inner join category c "
				+ "inner join product_category pc on pc.id_product = p.id and pc.id_category = c.id where p.id = ?;";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery()) {
				int prevIdProduct = 0;
				
				while (rs.next()) {
					int idProduct = rs.getInt("id");
					Category category = new Category();
					
					if (idProduct != prevIdProduct) {						
						to.setId(idProduct);
						to.setName(rs.getString("name"));
						to.setDescription(rs.getString("description"));
						to.setPrice(rs.getDouble("price"));
						to.setIdMark(rs.getInt("id_mark"));
						prevIdProduct = idProduct;
					}
					category.setId(rs.getInt("id_category"));
					category.setName(rs.getString("c.name"));
					category.setColor(rs.getString("color"));
					categories.add(category);
				}
				to.setCategories(categories);
				
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return to;
	}
}
