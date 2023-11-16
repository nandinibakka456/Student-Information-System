package com.dao;

//RegistrationDAOImpl.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dto.RegistrationDTO;

public class RegistrationDAOImpl implements RegistrationDAO {
 private DBConnectionManager connectionManager;

 public RegistrationDAOImpl() {
     connectionManager = new DBConnectionManager();
 }

 @Override
 public boolean registerUser(RegistrationDTO registrationDTO) {
     Connection connection = connectionManager.getConnection();
     PreparedStatement preparedStatement = null;

     try {
         String sql = "INSERT INTO register_info (name, email, password) VALUES (?, ?, ?)";
         preparedStatement = connection.prepareStatement(sql);
         preparedStatement.setString(1, registrationDTO.getName());
         preparedStatement.setString(2, registrationDTO.getEmail());
         preparedStatement.setString(3, registrationDTO.getPassword());

         int rowsAffected = preparedStatement.executeUpdate();
         return rowsAffected > 0;
     } catch (SQLException e) {
         e.printStackTrace();
         return false;
     } finally {
         try {
             if (preparedStatement != null) {
                 preparedStatement.close();
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         connectionManager.closeConnection();
     }
 }

}
