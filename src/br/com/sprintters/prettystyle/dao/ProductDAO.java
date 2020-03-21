package br.com.sprintters.prettystyle.dao;
package br.com.sprintters.prettystyle.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {

	public void create(Product prod) {		
		String sqlInsert = "INSERT INTO product (name, description, price, id_mark, created_at) values (?, ?, ?, ?, now())";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString(1, prod.getName());
			stm.setString(2, prod.getDescription());
			stm.setDouble(3, prod.getPrice());
			stm.setInt(4, prod.getIdMark());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void update(Product prod) {
		String sqlUpdate = "UPDATE product SET name = ?, description = ?, price = ?, id_mark = ?, updated_at = now() where id = ?";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, prod.getName());
			stm.setString(2, prod.getDescription());
			stm.setDouble(3, prod.getPrice());
			stm.setInt(4, prod.getIdMark);
			stm.setInt(5, prod.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete(Product prod) {
		String sqlUpdate = "UPDATE product SET deleted_at = now() where id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, prod.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Product find(int id) {
		Product prod = new Product();
		String sqlSelect = "SELECT * FROM product where product.id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					prod.setId(rs.getInt("id"));
					prod.setName(rs.getString("name"));
					prod.setDescription(rs.getString("description"));
					prod.setPrice(rs.getDouble("price"));
					prod.setIdMark(rs.getInt("id_mark"));
					prod.setCreatedAt(rs.getTimestamp("created_at"));
					prod.setUpdatedAt(rs.getTimestamp("updated_at"));
					prod.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
				else {
					prod.setId(0);
					prod.setName(null);
					prod.setDescription(null);
					prod.setPrice(null);
					prod.setIdMark(0);
					prod.setCreatedAt(null);
					prod.setUpdatedAt(null);
					prod.setDeletedAt(null);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return prod;
	}
	
	public ArrayList<Product> list() throws Exception  {
		ArrayList<Product> products = new ArrayList<Product>();
		String sqlSelect = "SELECT * FROM product WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Product prod = new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getDouble("price"),
						rs.getInt("id_mark"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
						
					);
					products.add(prod);
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
