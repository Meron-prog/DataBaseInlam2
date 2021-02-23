package repositories;

import DBTabels.Inehåll;
import DBTabels.Märke;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InehållRepository {

    private Connection connection;

    public InehållRepository(Connection connection) {

        this.connection = connection;
    }
    public List<Inehåll> getAllMarksInStock() {
        List<Inehåll> inehåll = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM inehåll");

            while(rs.next()){
                int id= rs.getInt("id");
                int produktid= rs.getInt("produktid");
                int Ordersid= rs.getInt("ordersid");
                inehåll.add(new Inehåll(id, produktid,Ordersid,null,null));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return inehåll;
    }

}
