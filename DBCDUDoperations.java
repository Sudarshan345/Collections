package com.reg.studentDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBCDUDoperations {

	public static int createStudent(StudentBean student) {

		Connection connection = DBconnection.getDBconnection();
		Statement stmt;
		int noofRowsInserted = 0;

		try {
			stmt = connection.createStatement();

			String insertQuery = "insert into student_tbl values(" + student.id + ",'" + student.getName()+ "','" + student.getEmail() + "')";

			noofRowsInserted = stmt.executeUpdate(insertQuery);

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return noofRowsInserted;
	}

	public static int updateStudent(StudentBean student) {

		Connection connection = DBconnection.getDBconnection();
		Statement stmt;
		int noofRowsUpdated = 0;

		try {
			stmt = connection.createStatement();

			String updateQuery = "update student_tbl set name='" + student.getName() + "' where id='"
					+ student.getId() + "'";

			noofRowsUpdated = stmt.executeUpdate(updateQuery);

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return noofRowsUpdated;
	}

	public static int deleteStudent(StudentBean student) {

		Connection connection = DBconnection.getDBconnection();
		Statement stmt;
		int noofRowsDeleted = 0;

		try {
			stmt = connection.createStatement();

			String deleteQuery = "delete from student_tbl where id='" + student.getId() + "'";

			noofRowsDeleted = stmt.executeUpdate(deleteQuery);

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return noofRowsDeleted;
	}

	public static List<StudentBean> retriveStudentInfo() {

		List<StudentBean> studentList = new ArrayList<>();

		Connection connection = DBconnection.getDBconnection();
		Statement stmt;
		ResultSet rs;

		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from student_tbl");

			while (rs.next()) {
				StudentBean s = new StudentBean();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				studentList.add(s);

			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;

	}

}
