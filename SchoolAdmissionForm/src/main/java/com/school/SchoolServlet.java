package com.school;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SchoolServlet
 */
@WebServlet("/SchoolServlet")
public class SchoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchoolServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//System.out.println("Hello world");
		
		String name = request.getParameter("name");
		System.out.println(name);
		String std = request.getParameter("std");
		System.out.println(std);
		String dob = request.getParameter("dob");
		System.out.println(dob);
		String age = request.getParameter("age");
		System.out.println(age);
		String gender = request.getParameter("gender");
		System.out.println(gender);
		String[] lang = request.getParameterValues("lang");
		
		for(String i : lang) {
			System.out.println(i);
		}
		
		String fname = request.getParameter("fname");
		System.out.println(fname);
		String mobilenum = request.getParameter("mobilenum");
		System.out.println(mobilenum);
		String email = request.getParameter("email");
		System.out.println(email);
		
		String ans = "";
		for(String i : lang) {
			 ans += i+" ";
		}
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","Java2023#");    
		System.out.println(con);
		
		Statement stmt=con.createStatement();  
		
		stmt.executeUpdate("insert into studentdb.studentregistration (name, section, dob, age, gender, languages, fathername, mobilenumber, email) values ('"+name+"','"+std+"','"+dob+"',"+age+",'"+gender+"','"+ans+"','"+fname+"','"+mobilenum+"','"+email+"')");
	    //stmt.executeUpdate("delete from  studentdb.studentregistration where studentId=3");
	    //stmt.executeUpdate("update studentdb.studentregistration set languages='Hindi Tamil' where studentId = 3");
		
		//response.getWriter().append("Name: "+name).append(" ").append("Class: "+std);
		ResultSet rs = stmt.executeQuery("select * from studentdb.studentregistration");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		
		sb.append("<style>\r\n"
				+ "        table,th,td{\r\n"
				+ "        border:1px solid black;\r\n"
				+ "        border-collapse: collapse;\r\n"
				+ "        }\r\n"
				+ "   </style>");
		
		sb.append("</head>");
		
		sb.append("<body>");
		
		sb.append("<br><br>");
		sb.append("<h1 style=\"text-align:center;\">ABC Matriculation Higher Secondary School</h1>");
		sb.append("<center>");
		sb.append("<table>\r\n"
				+ "    <caption style=\"text-align:left\"><b>Student Details</b></caption>\r\n"
				+ "    <tr>\r\n"
				+ "        <td>Name:</td>\r\n"
				+ "        <td>"+name+"</td>\r\n"
				+ "    </tr>\r\n"
				+ "    <tr>\r\n"
				+ "        <td>Class:</td>\r\n"
				+ "        <td>"+std+"</td>\r\n"
				+ "    </tr>\r\n"
				+ "    <tr>\r\n"
				+ "        <td>Date Of Birth:</td>\r\n"
				+ "        <td>"+dob+"</td>\r\n"
				+ "    </tr>\r\n"
				+ "    <tr>\r\n"
				+ "        <td>Age:</td>\r\n"
				+ "        <td>"+age+"</td>\r\n"
				+ "    </tr>\r\n"
				+ "    <tr>\r\n"
				+ "        <td>Gender:</td>\r\n"
				+ "        <td>"+gender+"</td>\r\n"
				+ "    </tr>\r\n"
				+ "    <tr>\r\n"
				+ "        <td>Language Known:</td>\r\n<td>");
		/*String ans = "";
	for(String i : lang) {
		 ans = i+" ";
	}*/
		sb.append(" "+ans+"</td></tr>\r\n"
				+ "    <tr>\r\n"
				+ "        <td>Father Name:</td>\r\n"
				+ "        <td>"+fname+"</td>\r\n"
				+ "    </tr>\r\n"
				+ "    <tr>\r\n"
				+ "        <td>Mobile Number:</td>\r\n"
				+ "        <td>"+mobilenum+"</td>\r\n"
				+ "    </tr>\r\n"
				+ "    <tr>\r\n"
				+ "        <td>Email:</td>\r\n"
				+ "        <td>"+email+"</td>\r\n"
				+ "    </tr>\r\n"
				+ "\r\n"
				+ "</table>");
		
		sb.append("</center>");
		
	   System.out.println("Data of select command");
		
		sb.append("<br><br><center><table>");
		sb.append("<tr><th>Name</th><th>Class</th><th>Date Of Birth</th><th>Age</th><th>Gender</th><th>Language Known</th><th>Father Name</th><th>Mobile Number</th><th>Email</th></tr>");
		while(rs.next()) {
			
			String nam = rs.getString("name");
			String st = rs.getString("section");
			String db = rs.getString("dob");
			String ag = rs.getString("age");
			String gen = rs.getString("gender");
			String lan = rs.getString("languages");
			String fn = rs.getString("fathername");
			String mn = rs.getString("mobilenumber");
			String em = rs.getString("email");
			sb.append("<tr><td>"+nam+"</td><td>"+st+"</td><td>"+db+"</td><td>"+ag+"</td><td>"+gen+"</td><td>"+lan+"</td><td>"+fn+"</td><td>"+mn+"</td><td>"+em+"</td></tr>");
			
		}
		sb.append("</table></center>");
		
		sb.append("</body>");
		
		sb.append("</html>");
		
		pw.append(sb);
		pw.flush();
		
		}catch (Exception ex) {
			
			ex.printStackTrace();
			
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
