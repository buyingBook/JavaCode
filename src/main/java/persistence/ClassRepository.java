package persistence;

import domain.Book;
import domain.Class;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class ClassRepository {
    private static ClassRepository instance;
    private static DataSource ds;
    private ClassRepository() {

    }
    public static ClassRepository getInstance() {
        if(instance==null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
                return instance = new ClassRepository();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return instance;
    }

    public Book findById(Long id){
        return null;
    }

    public ArrayList<Class> findAll() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM BOARD";
        ArrayList<Class> boards = new ArrayList<Class>();
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {

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
        return boards;
    }
}
