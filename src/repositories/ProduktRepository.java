package repositories;

import DBTabels.Produkt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProduktRepository {

    private Connection connection;

    public ProduktRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Produkt> getAllProductsInStock() {
        List<Produkt> products = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM produkt");

            while(rs.next()){
                int id= rs.getInt("id");
                String farg= rs.getString("farg");
                int storlek = rs.getInt("storlek");
                double pris = rs.getDouble("pris");
                int markeid = rs.getInt("märkeid");
                int antalskor = rs.getInt("antalskor");
                products.add(new Produkt(id, farg, storlek, pris, markeid, antalskor,null,null));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }
}
