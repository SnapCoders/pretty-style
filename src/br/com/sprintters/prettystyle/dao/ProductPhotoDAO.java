package br.com.sprintters.prettystyle.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.ProductPhoto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ProductPhotoDAO {
	public int insert(ProductPhoto to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO product_photo (url, name, id_product, created_at) VALUES (?, ?, ?, NOW())";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setString(1, to.getUrl());
			stm.setString(2, to.getName());
			stm.setInt(3, to.getIdProduct());
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
	
	public void update(ProductPhoto to) throws Exception {
		String sqlUpdate = "UPDATE product_photo SET url = ?,name = ?, id_product = ? ,updated_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setString(1, to.getUrl());
			stm.setString(2, to.getName());
			stm.setInt(3, to.getIdProduct());
			stm.setInt(4, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void delete(ProductPhoto to) throws Exception {
		String sqlUpdate = "UPDATE product_photo SET deleted_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public ProductPhoto find(int id) throws Exception {
		ProductPhoto to = new ProductPhoto();
		String sqlSelect = "SELECT * FROM product_photo WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setUrl(rs.getString("url"));
					to.setName(rs.getString("name"));
					to.setIdProduct(rs.getInt("id_product"));
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
	
	public ArrayList<ProductPhoto> list() throws Exception  {
		ArrayList<ProductPhoto> photos = new ArrayList<ProductPhoto>();
		String sqlSelect = "SELECT * FROM product_photo WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					ProductPhoto to = new ProductPhoto(
							rs.getInt("id"),
							rs.getString("url"),
							rs.getString("name"),
							rs.getInt("id_product"),
							rs.getTimestamp("created_at"),
							rs.getTimestamp("updated_at"),
							rs.getTimestamp("deleted_at")
					);
					photos.add(to);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return photos;
	}
	
	public ProductPhoto findByIdProduct(int idProduct) throws Exception {
		ProductPhoto to = new ProductPhoto();
		String sqlSelect = "SELECT * FROM product_photo WHERE id_product = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, idProduct);
			
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setUrl(rs.getString("url"));
					to.setName(rs.getString("name"));
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
	
	public ArrayList<ProductPhoto> findAllPhotosByIdProduct(int idProduct) throws Exception {
		ArrayList<ProductPhoto> photos = new ArrayList<ProductPhoto>();
		//ProductPhoto to = new ProductPhoto();
		String sqlSelect = "SELECT * FROM product_photo WHERE id_product = ? and deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, idProduct);
			
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					ProductPhoto to = new ProductPhoto(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("url"),
							rs.getInt("id_product"),
							rs.getTimestamp("created_at"),
							rs.getTimestamp("updated_at"),
							rs.getTimestamp("deleted_at")
					);
					photos.add(to);
				}
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return photos;
	}
	
	public void deletePhotos(String ids) throws Exception {
		String sqlUpdate = "UPDATE product_photo SET deleted_at = NOW() WHERE id in ("+ids+")";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
