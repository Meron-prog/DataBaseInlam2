package DBinlämning2;

import clientinterface.KundInterface;
import repositories.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DataBaseC {

        public static void main(String[] args) {
            try {
                Properties p = new Properties();
                p.load(new FileInputStream("src/DBinlämning2/database2.properties"));
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection= DriverManager.getConnection(p.getProperty("connectionString"),
                        p.getProperty("name"),
                        p.getProperty("password"));

                KunderRepository kunderRepository = new KunderRepository(connection);
                ProduktRepository produktRepository = new ProduktRepository(connection);
                MärkeRepository märkeRepository = new MärkeRepository(connection);
                OrderRepository orderRepository = new OrderRepository(connection);
                InehållRepository inehållRepository= new InehållRepository(connection);
                BetygRepository betygRepository= new BetygRepository(connection);
                BetygvärdeRepository betygvärdeRepository= new BetygvärdeRepository(connection);

                KundInterface kundInterface = new KundInterface(kunderRepository, produktRepository, märkeRepository,
                        orderRepository, inehållRepository, betygRepository,betygvärdeRepository);

                kundInterface.start();
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

}


