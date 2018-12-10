/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

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
        DataBaseInteractor dbi = new DataBaseInteractor(url);
        
        dbi.createTable("CREATE TABLE IF NOT EXISTS EMAIL (" + 
                "Id integer PRIMARY KEY AUTOINCREMENT," + 
                "Mail text NOT NULL); ");
        dbi.insertInTable("TestText3");
        dbi.executeQuery("SELECT * FROM EMAIL");
    }
    
}
