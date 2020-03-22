package br.com.sprintters.prettystyle.dao;
package br.com.sprintters.prettystyle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductPhoto {

	public void create(ProductPhoto photo) {
		String sqlInsert = "INSERT INTO product_photo (url, name, id_product, created_at) values (?,?,?, now())";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString(1, photo.getUrl());
			stm.setString(2, photo.getName());
			stm.setInt(3, photo.getIdProduct());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(ProductPhoto photo) {
		String sqlUpdate = "UPDATE product_photo SET url = ?,name = ?, id_product = ? ,updated_at = now() where id = ?";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, photo.getUrl());
			stm.setString(2, photo.getName());
			stm.setInt(3, photo.getIdProduct());
			stm.setInt(4, photo.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(ProductPhoto photo) {
		String sqlUpdate = "UPDATE product_photo SET deleted_at = now() where id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, photo.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ProductPhoto find(int id) {
		ProductPhoto photo = new ProductPhoto();
		String sqlSelect = "SELECT * FROM product_photo where product_photo.id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					photo.setId(rs.getInt("id"));
					photo.setUrl(rs.getString("url"));
					photo.setName(rs.getString("name"));
					photo.setIdProduct(rs.getInt("id_product"));
					photo.setCreatedAt(rs.getTimestamp("created_at"));
					photo.setUpdatedAt(rs.getTimestamp("updated_at"));
					photo.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
				else {
					photo.setId(0);
					photo.setUrl(null);
					photo.setName(null);
					photo.setIdProduct(0);
					photo.setCreatedAt(null);
					photo.setUpdatedAt(null);
					photo.setDeletedAt(null);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return photo;
	}
		
	
	public ArrayList<ProductPhoto> list() throws Exception  {
		ArrayList<ProductPhoto> photos = new ArrayList<ProductPhoto>();
		String sqlSelect = "SELECT * FROM product_photo WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					ProductPhoto photo = new ProductPhoto(
							rs.getInt("id"),
							rs.getString("url"),
							rs.getString("name"),
							rs.getInt("id_product"),
							rs.getTimestamp("created_at"),
							rs.getTimestamp("updated_at"),
							rs.getTimestamp("deleted_at")
					);
					photos.add(photo);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return photos;
	}
}
