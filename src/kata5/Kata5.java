/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class Kata5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:Kata5P1.DB";
        Connection connection = null;
        connection = DriverManager.getConnection(url);
        
        String sql = "SELECT * FROM PEOPLE";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        try {
            while(result.next()) {
                System.out.println(result.getInt("Id") + "\t" + 
                        result.getString("Name") + "\t" +
                        result.getString("Apellidos") + "\t" +
                        result.getString("Departamento") + "\t");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
