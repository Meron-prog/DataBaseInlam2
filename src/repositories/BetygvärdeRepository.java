package repositories;


import DBTabels.Betygvärde;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BetygvärdeRepository {

    private Connection connection;

    public BetygvärdeRepository(Connection connection) {

        this.connection = connection;
    }

    public List<Betygvärde> getBetygvärde() {
        List<Betygvärde> betygvärdes = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM betygvärde");

            while (rs.next()) {
                int id = rs.getInt("id");
                String värde=rs.getString("värde");
                int siffervärde = rs.getInt("siffervärde");
                betygvärdes.add(new Betygvärde(id, siffervärde, värde,null, null));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return betygvärdes;
    }
}
