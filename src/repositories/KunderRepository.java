package repositories;

import DBTabels.Kunder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KunderRepository {

    private Connection connection;

    public KunderRepository(Connection connection) {
        this.connection = connection;
    }

    public Kunder getCustomer(String userName, String password) {
        try {
            Statement stmt= connection.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from inlämning2.Kunder where Användernamn = '" + userName + "' and Lösenord = '" + password + "'");
            //ResultSet rs= stmt.executeQuery("Select * from Kunder");
            rs.next();
            int id= rs.getInt("id");
            String fornamn= rs.getString("Förnamn");
            String efternamn= rs.getString("Efternamn");
            String ort= rs.getString("Ort");
            String anvandarnamn= rs.getString("Användernamn");
            String losenord= rs.getString("Lösenord");

            return new Kunder(id, fornamn, efternamn, ort, anvandarnamn, losenord, null, null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
