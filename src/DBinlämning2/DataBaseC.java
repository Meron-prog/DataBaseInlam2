package DBinlämning2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DataBaseC {

        public static void main(String[] args) {
            connectToAndQueryDatabase();
        }

        public static void connectToAndQueryDatabase()  {
            try {
                Properties p = new Properties();
                p.load(new FileInputStream("src/DBinlämning2/database2.properties"));
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(p.getProperty("connectionString"),
                        p.getProperty("name"),
                        p.getProperty("password"));
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT* FROM inlämning2.katagorier");
                while(rs.next()){
                    int id= rs.getInt("id");
                    String namn= rs.getString("namn");
                    System.out.println("id: " + id + "namn: "+ namn);
                }

            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }


