package br.com.sprintters.prettystyle.dao;
package br.com.sprintters.prettystyle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO {

	public void create(Category category) {
		String sqlInsert = "INSERT INTO category (name, color) values (?, ?)";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString(1, category.getName());
			stm.setString(2, category.getColor());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Category category) {
		String sqlUpdate = "UPDATE category SET name = ?, color = ?, updated_at = now() where category.id = ?";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, category.getName());
			stm.setString(2, category.getColor());
			stm.setInt(3, category.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Category category) {
		String sqlUpdate = "UPDATE category SET deleted_at = now() where id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, category.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Category find(int id) {
		Category category = new Category();
		String sqlSelect = "SELECT * FROM category where category.id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					category.setId(rs.getInt("id"));
					category.setName(rs.getString("name"));
					category.setColor(rs.getString("color"));
					category.setCreatedAt(rs.getTimestamp("created_at"));
					category.setUpdatedAt(rs.getTimestamp("updated_at"));
					category.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
				else {
					category.setId(0);
					category.setName(null);
					category.setColor(null);
					category.setCreatedAt(null);
					category.setUpdatedAt(null);
					category.setDeletedAt(null);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return category;
	}
		
	
	public ArrayList<Category> list() throws Exception  {
		ArrayList<Category> categories = new ArrayList<Category>();
		String sqlSelect = "SELECT * FROM category WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Category category = new Category(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("color"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
					);
					categories.add(category);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return categories;
	}
}
