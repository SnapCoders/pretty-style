package br.com.sprintters.prettystyle.dao;
package br.com.sprintters.prettystyle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCategoryDAO {
	public void create(ProductCategory prodCat) {
		String sqlInsert = "INSERT INTO product_category (id, id_product, id_category, created_at) values (?,?,?, now())";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, prodCat.getId());
			stm.setInt(2, prodCat.getIdProduct());
			stm.setInt(3, prodCat.getIdCategory());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(ProductCategory prodCat) {
		String sqlUpdate = "UPDATE product_category SET id_product = ?, id_category, updated_at = now() where id = ?";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setInt(1, prodCat.getIdProduct());
			stm.setInt(2, prodCat.getIdCategory());
			stm.setInt(3, prodCat.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(ProductCategory prodCat) {
		String sqlDelete = "DELETE FROM product_category WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, prodCat.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ProductCategory find(int id) {
		ProductCategory prodCat = new ProductCategory();
		String sqlSelect = "SELECT * FROM product_category where id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					prodCat.setId(rs.getInt("id"));
					prodCat.setIdProduct(rs.getInt("id_product"));
					prodCat.setIdCategory(rs.getInt("id_category"));
					prodCat.setCreatedAt(rs.getTimestamp("created_at"));
					prodCat.setUpdatedAt(rs.getTimestamp("updated_at"));

				}
				else {
					prodCat.setId(0);
					prodCat.setIdProduct(0);
					prodCat.setIdCategory(0);
					prodCat.setCreatedAt(null);
					prodCat.setUpdatedAt(null);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return prodCat;
	}
		
	
	public ArrayList<ProductCategory> list() throws Exception  {
		ArrayList<ProductCategory> prodsCat = new ArrayList<ProductCategory>();
		String sqlSelect = "SELECT * FROM product_category";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					ProductCategory prodCat = new ProductCategory(
						rs.getInt("id"),
						rs.getInt("id_product"),
						rs.getInt("id_category"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at")
					);
					prodsCat.add(prodCat);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return prodsCat;
	}
}
