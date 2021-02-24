package repositories;

import DBTabels.Betyg;
import DBTabels.Märke;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BetygRepository {

    private Connection connection;

    public BetygRepository(Connection connection) {
        this.connection = connection;
    }

    public double getMedelbetygForProduct(int productId) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select medel_betygsvärde("+productId+")");

            rs.next();
            return rs.getDouble(1);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public List<Betyg> getAllBetygForProduct(int produktId) {
        List<Betyg> betyg = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM betyg where produktid = "+ produktId+ "");

            while(rs.next()){
                int id= rs.getInt("id");
                int BetygvärdeID = rs.getInt("betygvärdeid");
                String komment= rs.getString("komment");
                int produktid= rs.getInt("produktid");
                int  kundid = rs.getInt("kundid");
                betyg.add(new Betyg(id,BetygvärdeID, produktid, kundid, komment,null,null));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return betyg;
    }

}

