package br.com.sprintters.prettystyle.dao;
package br.com.sprintters.prettystyle.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MarkDAO {
	
	public void create(Mark mark) {
		String sqlInsert = "INSERT INTO mark (name, created_at) values (?, now())";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString(1, mark.getName());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Mark mark) {
		String sqlUpdate = "UPDATE mark SET name = ?, updated_at = now() where id = ?";
		
		try(Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, mark.getName());
			stm.setInt(2, mark.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Mark mark) {
		String sqlUpdate = "UPDATE mark SET deleted_at = now() where id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, mark.getId());
			stm.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Mark find(int id) {
		Mark mark = new Mark();
		String sqlSelect = "SELECT * FROM mark where mark.id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					mark.setId(rs.getInt("id"));
					mark.setName(rs.getString("name"));
					mark.setCreatedAt(rs.getTimestamp("created_at"));
					mark.setUpdatedAt(rs.getTimestamp("updated_at"));
					mark.setDeletedAt(rs.getTimestamp("deleted_at"));
				}
				else {
					mark.setId(0);
					mark.setName(null);
					mark.setCreatedAt(null);
					mark.setUpdatedAt(null);
					mark.setDeletedAt(null);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return mark;
	}
		
	
	public ArrayList<Mark> list() throws Exception  {
		ArrayList<Mark> marks = new ArrayList<Mark>();
		String sqlSelect = "SELECT * FROM mark WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Mark mark = new Mark(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
					);
					marks.add(mark);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return marks;
	}
}


