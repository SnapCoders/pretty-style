package br.com.sprintters.prettystyle.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.Mark;

import java.sql.PreparedStatement;

public class MarkDAO {
	public int insert(Mark to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO mark (name, created_at) VALUES (?, NOW())";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setString(1, to.getName());
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
	
	public void update(Mark to) throws Exception {
		String sqlUpdate = "UPDATE mark SET name = ?, updated_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setString(1, to.getName());
			stm.setInt(2, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void delete(Mark to) throws Exception {
		String sqlDelete = "UPDATE mark SET deleted_at = NOW() WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Mark find(int id) throws Exception {
		Mark to = new Mark();
		String sqlSelect = "SELECT * FROM mark WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.createConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setName(rs.getString("name"));
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
	
	public ArrayList<Mark> list() throws Exception  {
		ArrayList<Mark> marks = new ArrayList<Mark>();
		String sqlSelect = "SELECT * FROM mark WHERE deleted_at IS NULL";
		
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Mark to = new Mark(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"),
						rs.getTimestamp("deleted_at")
					);
					marks.add(to);
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
