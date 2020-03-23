package br.com.sprintters.prettystyle.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.sprintters.prettystyle.model.ProductCategory;

import java.sql.PreparedStatement;

public class ProductCategoryDAO {
	public void insert(ProductCategory to) throws Exception {
		String sqlInsert = "INSERT INTO product_category (id_product, id_category, created_at) VALUES (?, ?, NOW())";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setInt(1, to.getIdProduct());
			stm.setInt(2, to.getIdCategory());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void delete(ProductCategory to) throws Exception {
		String sqlDelete = "DELETE FROM product_category WHERE id_product = ? AND id_category = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
			stm.setInt(1, to.getIdProduct());
			stm.setInt(2, to.getIdCategory());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public ProductCategory find(int idProduct, int idCategory) throws Exception {
		ProductCategory to = new ProductCategory();
		String sqlSelect = "SELECT * FROM product_category WHERE id_product = ? AND id_category = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, idProduct);
			stm.setInt(2, idCategory);
			
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					to.setIdProduct(rs.getInt("id_product"));
					to.setIdCategory(rs.getInt("id_category"));
					to.setCreatedAt(rs.getTimestamp("created_at"));
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return to;
	}
	
	public ArrayList<ProductCategory> list() throws Exception  {
		ArrayList<ProductCategory> prodsCat = new ArrayList<ProductCategory>();
		String sqlSelect = "SELECT * FROM product_category";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					ProductCategory to = new ProductCategory(
						rs.getInt("id_product"),
						rs.getInt("id_category"),
						rs.getTimestamp("created_at")
					);
					prodsCat.add(to);
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
