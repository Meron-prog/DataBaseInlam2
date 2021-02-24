package repositories;

import DBTabels.Inehåll;
import DBTabels.Märke;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InehållRepository {

    private Connection connection;

    public InehållRepository(Connection connection) {

        this.connection = connection;
    }
    public List<Inehåll> getOrdersInehåll(int orderid) {
        List<Inehåll> inehåll = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM inehåll where Ordersid = " + orderid);

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

    public String addToOrder(int produktId, int kunderId, int orderID) {
        try {

            String query = "call AddToCart(?, ?, ?, ?)";
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setInt(1,produktId);

            if(orderID == -1) {
                stmt.setNull(2, Types.INTEGER);
            } else {
                stmt.setInt(2, orderID);
            }
            stmt.setInt(3,kunderId);
            stmt.registerOutParameter(4, Types.VARCHAR);

            ResultSet rs = stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            return "Ett fel inträffade, det gick inte lägga till skorna i ordern, prova igen.";
        }
        return "Skor lades till i order.";
    }
}
