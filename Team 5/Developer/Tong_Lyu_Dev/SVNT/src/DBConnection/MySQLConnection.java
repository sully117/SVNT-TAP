package DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.Tag;
import entity.Tag.TagBuilder;

public class MySQLConnection {
	private Connection conn;

	public MySQLConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("YOUR_URL");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	public List<Tag> getPopularTags(String startTime, String endTime, String region) {
		if (conn == null) {
			System.err.println("DB connection failed!");
		}
		
		List<Tag> res = new ArrayList<>();
		try {
			String sql = "SELECT * FROM tags WHERE time >= (?) AND time <= (?) AND region = (?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, startTime);
			stmt.setString(2, endTime);
			stmt.setString(3, region);
			ResultSet rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				TagBuilder builder = new TagBuilder();
				builder.setTag(rs.getString("tag"));
				builder.setViews(rs.getInt("views"));
				builder.setLikes(rs.getInt("likes"));
				builder.setDislikes(rs.getInt("disLikes"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
}
