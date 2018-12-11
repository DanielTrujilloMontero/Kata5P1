/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class DataBaseInteractor {
    
    private Connection connection = null;
    private Statement statement;
    private String url = "";
    
    public DataBaseInteractor(String url) throws SQLException {
        this.url = url;
        connect();
    }
    
    private void connect() throws SQLException {
        connection = DriverManager.getConnection(url);
        statement = connection.createStatement();
    }
    
    public void createTable(String sql) throws SQLException {
        statement.execute(sql);
    }
    
    public void insertInTable(List<String> list) throws SQLException {
        Iterator<String> iterator = list.iterator();
        String text = "";
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO EMAIL(Mail) VALUES(?)");
        while(iterator.hasNext()) {
            text = iterator.next();
            preparedStatement.setString(1, text);
            preparedStatement.execute();
        }
        
    }
    
    public void executeQuery(String query) throws SQLException {
        ResultSet result = statement.executeQuery(query);
        try {
            while(result.next()) {
                System.out.println(result.getInt("Id") + "\t" + 
                        result.getString("Mail") + "\t");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
