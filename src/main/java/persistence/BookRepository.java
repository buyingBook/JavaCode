package persistence;

import domain.Book;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class BookRepository {
    private static BookRepository instance;
    private static DataSource ds;
    private BookRepository() {

    }
    public static BookRepository getInstance() {
        if(instance==null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
                return instance = new BookRepository();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return instance;
    }

    public Book findById(int id){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql1 = "SELECT * FROM book WHERE bookNum = " + id;
        Book booktarget = null;
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
                String name = rs.getString(2);
                String author = rs.getString(3);
                String pub = rs.getString(4);
                int price = rs.getInt(5);
                String url = rs.getString(6);
                booktarget = new Book(id, name, author, pub, price, url);
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
        return booktarget;
    }

    public ArrayList<Book> findAll() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM book";
        ArrayList<Book> books = new ArrayList<Book>();
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
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String author = rs.getString(3);
                String pub = rs.getString(4);
                int price = rs.getInt(5);
                String url = rs.getString(6);
                Book post = new Book(id, name, author, pub, price, url);
                books.add(post);
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
        return books;
    }
}
