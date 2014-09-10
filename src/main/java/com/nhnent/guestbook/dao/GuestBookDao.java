package com.nhnent.guestbook.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.nhnent.guestbook.model.GuestBook;

@Repository
public class GuestBookDao {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public void insert(GuestBook guestBook) {
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
					.getConnection(
							"jdbc:mysql://127.0.0.1:3306/guestbook?useUnicode=true&characterEncoding=euckr",
							"root", "0415");
			java.sql.Statement st = null;
			st = con.createStatement();
			String query = " insert into guestbook (email, password, content, create_date)"
					+ " values (?, ?, ?, ?)";
			Calendar cal = Calendar.getInstance();
			Date date = new Date(cal.getTimeInMillis());
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, guestBook.getEmail());
			preparedStmt.setString(2, guestBook.getPassword());
			preparedStmt.setString(3, guestBook.getContent());
			preparedStmt.setDate(4, date);
			preparedStmt.execute();
			preparedStmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getListSize() {
		Connection con;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager
					.getConnection(
							"jdbc:mysql://127.0.0.1:3306/guestbook?useUnicode=true&characterEncoding=euckr",
							"root", "0415");

			String query = "SELECT * FROM guestbook";

			// create the java statement
			java.sql.Statement st = con.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);
			int rowCount = 0;
			if (rs.last()) {
				rowCount = rs.getRow();
				rs.beforeFirst();
			}
			System.out.println(rowCount);
			while (rs.next()) {
				System.out.println("ddd");
			}
			return rowCount;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;


	}

	public List<GuestBook> getGuestBookList() {
		Connection con;
		List<GuestBook> guestBookList = new ArrayList<GuestBook>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager
					.getConnection(
							"jdbc:mysql://127.0.0.1:3306/guestbook?useUnicode=true&characterEncoding=euckr",
							"root", "0415");

			String query = "SELECT * FROM guestbook";
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				GuestBook guestBook = new GuestBook(rs.getString("email"),rs.getString("password"),rs.getString("content"),rs.getDate("create_date"));
				guestBookList.add(guestBook);
			}
			System.out.println(guestBookList.size());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return guestBookList;
	}

}
