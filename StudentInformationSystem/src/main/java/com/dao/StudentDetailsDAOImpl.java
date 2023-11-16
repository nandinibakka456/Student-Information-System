package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Student;

public class StudentDetailsDAOImpl implements StudentDetailsDAO {

	private final DBConnectionManager connectionManager;

	public StudentDetailsDAOImpl() {
		connectionManager = new DBConnectionManager();
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();

		try {

			Connection connection = connectionManager.getConnection();
			String sql = "SELECT * FROM Studentdetails";

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("Name");
				String email = resultSet.getString("email");
				String phoneNumber = resultSet.getString("phone_number");
				String college = resultSet.getString("College");
				String degree = resultSet.getString("Degree");
				String branch = resultSet.getString("Branch");

				Student student = new Student(id, name, email, phoneNumber, college, degree, branch);
				students.add(student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}

	public Student getStudentById(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Student student = null;

		try {
			connection = connectionManager.getConnection();
			String sql = "SELECT * FROM studentdetails WHERE id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				student = new Student();
				student.setId(resultSet.getInt("id"));
				student.setName(resultSet.getString("name"));
				student.setEmail(resultSet.getString("email"));
				student.setPhoneNumber(resultSet.getString("phone_number"));
				student.setCollege(resultSet.getString("college"));
				student.setDegree(resultSet.getString("Degree"));
				student.setBranch(resultSet.getString("Branch"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return student;
	}

	@Override
	public boolean updateStudent(Student student) {
		try (Connection connection = new DBConnectionManager().getConnection()) {
			String sql = "UPDATE studentdetails SET name=?, email=?, phone_number=?, college=?, degree=?, branch=? WHERE id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, student.getName());
				statement.setString(2, student.getEmail());
				statement.setString(3, student.getPhoneNumber());
				statement.setString(4, student.getCollege());
				statement.setString(5, student.getDegree());
				statement.setString(6, student.getBranch());
				statement.setInt(7, student.getId());

				int rowsUpdated = statement.executeUpdate();
				return rowsUpdated > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addStudent(Student student) {
		try (Connection connection = new DBConnectionManager().getConnection()) {
			String sql = "INSERT INTO studentdetails (id, name, email, phone_number, college, degree, branch) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setInt(1, student.getId());
				statement.setString(2, student.getName());
				statement.setString(3, student.getEmail());
				statement.setString(4, student.getPhoneNumber());
				statement.setString(5, student.getCollege());
				statement.setString(6, student.getDegree());
				statement.setString(7, student.getBranch());

				int rowsUpdated = statement.executeUpdate();
				return rowsUpdated > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteStudent(int id) {

		try (Connection connection = new DBConnectionManager().getConnection()) {
			String sql = "DELETE FROM studentdetails WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setInt(1, id);
				int rowsUpdated = statement.executeUpdate();
				return rowsUpdated > 0;

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}

}
