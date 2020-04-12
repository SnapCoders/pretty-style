package br.com.sprintters.prettystyle.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

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
				}
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
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return products;
	}
}
