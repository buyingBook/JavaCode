package persistence;

import domain.Book;
import domain.Main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class MainRepository {
    private static MainRepository instance;
    private static DataSource ds;
    private MainRepository() {

    }
    public static MainRepository getInstance() {
        if(instance==null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
                return instance = new MainRepository();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return instance;
    }
    public Main findById(int id){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql1 = "SELECT (id, bookName, bookAuthor, bookPrice) FROM lecture order by desc " + id;
        Main lecturetarget = null;
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql1);
            while (rs.next()) {
                int cid = rs.getInt(1);
                String bookName = rs.getString(2);
                String bookAuthor = rs.getString(3);
                int bookPrice = rs.getInt(4);
                lecturetarget = new Main(cid, bookName, bookAuthor, bookPrice);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        
        
        return lecturetarget;
    }
//
//    public Main findByContent(int id){
//        Connection conn = null;
//        Statement st = null;
//        ResultSet rs = null;
//        String sql1 = "SELECT (id, title) FROM Content(�Խ������̺�) order by desc";
//        Main Contenttarget = null;
//        try {
//            conn = ds.getConnection();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        try {
//            st = conn.createStatement();
//            rs = st.executeQuery(sql1);
//            while (rs.next()) {
//                int id1 = rs.getInt(1);
//                String title = rs.getString(2);
//                Contenttarget = new Main(id1, title);
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }finally {
//            try {
//                rs.close();
//                st.close();
//                conn.close();
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//
//
//
//        return Contenttarget;
//    }
}
