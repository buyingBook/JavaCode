package persistence;

import domain.Book;
import domain.Lecture;
import domain.Major;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class LectureRepository {
    private static LectureRepository instance;
    private static DataSource ds;
    private LectureRepository() {

    }
    public static LectureRepository getInstance() {
        if(instance==null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
                return instance = new LectureRepository();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return instance;
    }
    public Lecture findById(int id){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql1 = "SELECT * FROM lecture WHERE bookNum = " + id;
        Lecture lecturetarget = null;
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
                String name = rs.getString(2);
                String major = rs.getString(3);
                String professor = rs.getString(4);
                int grade = rs.getInt(6);
                lecturetarget = new Lecture(cid, name, major, professor, id, grade);
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

    public ArrayList<Lecture> findLecturesByIdAndGrade(Major major) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Lecture> lecs = new ArrayList<Lecture>();

        String sql = "SELECT * FROM lecture WHERE majorName = '" + major.getMajorName() + "'";

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
                String professor = rs.getString(4);
                int bookNum = rs.getInt(5);
                int grade = rs.getInt(6);
                Lecture post = new Lecture(id, name, major.getMajorName(), professor, bookNum, grade);
                lecs.add(post);
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
        return lecs;
    }
}
