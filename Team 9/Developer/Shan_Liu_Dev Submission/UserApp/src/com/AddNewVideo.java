package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;  
/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/addVideoServlet")

 

public class AddNewVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","TEST1234567");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String file = request.getParameter("video_file");
		String catagories = request.getParameter("Catagories");
		String region = request.getParameter("Region");
		String tags = request.getParameter("tags");
		
		//Integer channelId = request.getParameter("channelID");
		
		
		try {
			Statement stmt = connection.createStatement();
			//we need single quote to surrond each filed
			int result = stmt.executeUpdate("insert into user values('"+file+"' ,'"+catagories+"' , '"+region+"', '"
			+tags+"')");
			
			
//			int result = prediction(String catagories, string region, String tags);   // Python file  
			
			PrintWriter out = response.getWriter();
			
			if(result > 0) {
				out.print("<h1>Video CREATED</h1>");
			}else {
				out.print("<h1>ERROR Creating the User</h1>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
