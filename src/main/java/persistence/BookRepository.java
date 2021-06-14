package persistence;

import domain.Book;
import domain.Criteria;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public int totalCount() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM book";
        int cnt = 0;
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
                cnt = rs.getInt(1);
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
        return cnt;
    }


    public int totalCount(String major) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM lecture WHERE majorName='"+major+"'";
        int cnt = 0;
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
                cnt = rs.getInt(1);
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
        return cnt;
    }

    public int totalCount(int grade) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM lecture WHERE grade = " + grade;
        int cnt = 0;
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
                cnt = rs.getInt(1);
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
        return cnt;
    }

    public int totalCount(String major, int grade) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM lecture WHERE majorName = '" + major +
                "' AND grade = " + grade;
        int cnt = 0;
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
                cnt = rs.getInt(1);
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
        return cnt;
    }

    public Book findById(int id){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM book WHERE bookNum = " + id;
        Book booktarget = null;
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
    public ArrayList<Book> findAll(int idx) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM book LIMIT " + idx + ", 5";
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

    public ArrayList<Book> findAll(int idx, String major) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Book> books = new ArrayList<Book>();

        String sql = "SELECT * FROM book JOIN lecture l on book.bookNum = l.bookNum WHERE majorName = '" +major+
                "' LIMIT "+idx+", 5";

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

    public ArrayList<Book> findAll(int idx, int grade) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Book> books = new ArrayList<Book>();

        String sql = "SELECT * FROM book JOIN lecture l on book.bookNum = l.bookNum WHERE grade = " +grade+ " LIMIT "+idx+", 5";

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
    public ArrayList<Book> findAll(int idx, String major, int grade) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Book> books = new ArrayList<Book>();

        String sql = "SELECT * FROM book JOIN lecture l on book.bookNum = l.bookNum WHERE majorName = '" +major+
                "' AND grade = " +grade+ " LIMIT "+idx+", 5";

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
