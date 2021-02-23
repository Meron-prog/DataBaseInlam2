package repositories;

import DBTabels.Märke;
import DBTabels.Produkt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MärkeRepository {

    private Connection connection;

    public MärkeRepository(Connection connection) {
        this.connection = connection;
    }
    public List<Märke> getAllMarksInStock() {
        List<Märke> märkes = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM märke");

            while(rs.next()){
                int id= rs.getInt("id");
                String namn= rs.getString("namn");
                märkes.add(new Märke(id, namn,null,null));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return märkes;
    }
}


