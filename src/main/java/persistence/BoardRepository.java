package persistence;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.*;

import domain.Board;
import domain.Major;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static java.time.LocalTime.now;

public class BoardRepository {
    private static BoardRepository instance;
    private static DataSource ds;
    private BoardRepository() {

    }
    public static BoardRepository getInstacne() {
        if(instance==null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
                return instance = new BoardRepository();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return instance;
    }
    public void save(Board board){
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO BOARD(writer, title, contents, regdate, hit) values(?,?,?,?,?)";
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, board.getWriter());
            pstmt.setString(2, board.getTitle());
            pstmt.setString(3, board.getContents());
            pstmt.setDate(4, board.getRegdate());
            pstmt.setInt(5, board.getHit());

            int n = pstmt.executeUpdate();
            System.out.println("EXECUTE: " + board.toString());
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

    public void delete(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "DELETE FROM board WHERE boardId = ?";
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            int n = pstmt.executeUpdate();
            System.out.println(n);
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
    public Board findById(int id){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Board post = null;
        String sql = "SELECT * FROM BOARD WHERE boardId = " + id;
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
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String contents = rs.getString("contents");
                Date regdate = rs.getDate("regdate");
                int hit = rs.getInt("hit");
                post = new Board(id,title,writer,contents,regdate,hit);
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
        return post;
    }

    public ArrayList<Board> findAll() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM BOARD";
        ArrayList<Board> boards = new ArrayList<Board>();
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
                int id = rs.getInt("boardId");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String contents = rs.getString("contents");
                Date regdate = rs.getDate("regdate");
                int hit = rs.getInt("hit");
                Board posts = new Board(id,title,writer,contents,regdate,hit);
                boards.add(posts);
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

    public ArrayList<Board> findAll(int idx) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM board LIMIT " + idx + ", 10";
        ArrayList<Board> boards = new ArrayList<Board>();
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
                String title = rs.getString(2);
                String writer = rs.getString(3);
                String contents = rs.getString(4);
                Date reg = rs.getDate(5);
                int hit = rs.getInt(6);
                Board post = new Board(id, title, writer, contents, reg, hit);
                boards.add(post);
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

    public int totalCount() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM board";
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

    public ArrayList<Board> findByOwnId(String ownid) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM board WHERE writer='" + ownid + "'";
        ArrayList<Board> boards = new ArrayList<Board>();
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
                String title = rs.getString(2);
                String contents = rs.getString(4);
                Date reg = rs.getDate(5);
                int hit = rs.getInt(6);
                Board post = new Board(id, title, ownid, contents, reg, hit);
                boards.add(post);
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
