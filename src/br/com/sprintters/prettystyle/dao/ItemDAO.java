package br.com.sprintters.prettystyle.dao;
package br.com.sprintters.prettystyle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAO {

	public void create(Item item) {		
		String sqlInsert = "INSERT INTO item (quantity, id_product, created_at) values (?, ?, now())";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, item.getQuantity());
			stm.setInt(2, item.getIdProduct());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void update(Item item) {
		String sqlUpdate = "UPDATE item SET quantity = ?, id_product = ?, updated_at = now() where id = ?";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setInt(1, item.getQuantity());
			stm.setInt(2, item.getIdProduct());
			stm.setInt(3, item.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete(Item item) {
		String sqlUpdate = "UPDATE item SET deleted_at = now() where id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, item.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Item find(int id) {
		Item item = new Item();
		String sqlSelect = "SELECT * FROM item where item.id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					item.setId(rs.getInt("id"));
					item.setQuantity(rs.getInt("quantity"));
					item.setIdProduct(rs.getInt("id_product"));
					item.setCreatedAt(rs.getTimestamp("created_at"));
					item.setUpdatedAt(rs.getTimestamp("updated_at"));
					item.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
				else {
					item.setId(0);
					item.setQuantity(0);
					item.setIdProduct(0);
					item.setCreatedAt(null);
					item.setUpdatedAt(null);
					item.setDeletedAt(null);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return item;
	}
	
	public ArrayList<Item> list() throws Exception  {
		ArrayList<Item> items = new ArrayList<Item>();
		String sqlSelect = "SELECT * FROM item WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Item item = new Item(
						rs.getInt("id"),
						rs.getInt("quantity"),
						rs.getInt("id_product"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
						
					);
					items.add(item);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return items;
	}
}
