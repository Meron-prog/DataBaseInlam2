package repositories;

import DBTabels.Märke;
import DBTabels.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderRepository {
    private Connection connection;

    public OrderRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Orders> getAllOrdersFromKund(int kundID) {
        List<Orders> orders = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders where kundid =" + kundID);

            while(rs.next()){
                int ID= rs.getInt("id");
                int kundid= rs.getInt("kundid");
                Date datum= rs.getDate("Datum");
                String status= rs.getString("Status");
                orders.add(new Orders(ID,kundid,datum,null,null, status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }

    public List<Orders> getCurrentOrdersFromKund(int kundID) {
        List<Orders> orders = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders where kundid =" + kundID + " and Status = 'Pågående'");

            while(rs.next()){
                int ID= rs.getInt("id");
                int kundid= rs.getInt("kundid");
                Date datum= rs.getDate("Datum");
                String status= rs.getString("Status");
                orders.add(new Orders(ID,kundid,datum,null,null, status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }

    public void setOrderToBestalld(int ordersId) {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE ORDERS set Status = 'Beställd' where ID = ?");
            stmt.setInt(1, ordersId);
            int returnvalue = stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


