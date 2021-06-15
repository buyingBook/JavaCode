package persistence;

import domain.BuyBook;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class BuyBookRepository {
    private static BuyBookRepository instance;
    private static DataSource ds;
    private BuyBookRepository() {

    }
    public static BuyBookRepository getInstance() {
        if(instance==null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
                return instance = new BuyBookRepository();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return instance;
    }

    public void inputInfo(BuyBook buy) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO buybook values(?,?,?,?,?)";
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, buy.getMemberId());
            pstmt.setInt(2, buy.getBookNum());
            pstmt.setInt(3, buy.getIsBuy());
            pstmt.setDate(4, buy.getBuydate());
            pstmt.setInt(5, buy.getCount());

            int n = pstmt.executeUpdate();
            System.out.println("EXECUTE: " + buy.toString());
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
