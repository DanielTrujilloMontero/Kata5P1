/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import view.MailListReader;

/**
 *
 * @author Daniel
 */
public class Kata5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        String url = "jdbc:sqlite:Kata5P1.DB";
        DataBaseInteractor dbi = new DataBaseInteractor(url);
        
        List<String> mailsList = MailListReader.read("email.txt");
        
        dbi.createTable("CREATE TABLE IF NOT EXISTS EMAIL (" + 
                "Id integer PRIMARY KEY AUTOINCREMENT," + 
                "Mail text NOT NULL); ");
        dbi.insertInTable(mailsList);
        dbi.executeQuery("SELECT * FROM EMAIL");
    }
    
}
