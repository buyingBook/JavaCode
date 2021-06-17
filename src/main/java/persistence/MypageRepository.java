package persistence;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.BuyBook;
import domain.Member;

public class MypageRepository {
	private static MypageRepository instance;
	private static DataSource ds;

	private MypageRepository() {

	}

	public static MypageRepository getInstacne() {
		if (instance == null) {
			try {
				Context context = new InitialContext();
				ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
				return instance = new MypageRepository();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	// 로그인 검증
	public boolean checkLogin(String id , String pwd) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE memberId = ?";
		boolean check = false;

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				
				String passwd = rs.getString("memberPwd");
				if (pwd.equals(passwd))
				{
					check = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}
	
	
	
	
	// 내정보 조회
	public Member getMyInfo(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE memberId = ?";
		Member member = new Member();

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				member.setMemberId(rs.getInt("memberId"));
				member.setMemberPwd(rs.getString("memberPwd"));
				member.setMemberNo(rs.getString("memberNo"));
				member.setMemberName(rs.getString("memberName"));
				member.setMemberMajor(rs.getString("memberMajor"));
				member.setMemberYear(rs.getInt("memberYear"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	// 구매목록 조회
	public ArrayList<BuyBook> getPurchaseList(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 구매 시간 추가
		String sql = "SELECT book.bookName , book.bookAuthor , book.bookPub , book.bookPrice , book.imageURL , buybook.buyDate FROM book, buybook WHERE book.bookNum = buybook.bookNumber AND buybook.memberId = ? AND buybook.isBuy = 1";
		ArrayList<BuyBook> purchaseList = new ArrayList<BuyBook>();

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				String bookName = rs.getString("bookName");
				String bookAuthor = rs.getString("bookAuthor");
				String bookPub = rs.getString("bookPub");
				int bookPrice = rs.getInt("bookPrice");
				String imageURL = rs.getString("imageURL");
				Date buyDate = rs.getDate("buyDate");
				BuyBook purchase = new BuyBook(bookName, bookAuthor, bookPub, bookPrice, imageURL, buyDate);
				purchaseList.add(purchase);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return purchaseList;
	}

	// 장바구니 조회
	public ArrayList<BuyBook> getShoppingList(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 구매 시간 추가
		String sql = "SELECT book.bookName , book.bookAuthor , book.bookPub , book.bookPrice , book.imageURL , buybook.buyDate FROM book, buybook WHERE book.bookNum = buybook.bookNumber AND buybook.memberId = ? AND buybook.isBuy = 0";
		ArrayList<BuyBook> shoppingList = new ArrayList<BuyBook>();

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				String bookName = rs.getString("bookName");
				String bookAuthor = rs.getString("bookAuthor");
				String bookPub = rs.getString("bookPub");
				int bookPrice = rs.getInt("bookPrice");
				String imageURL = rs.getString("imageURL");
				Date buyDate = rs.getDate("buyDate");
				BuyBook shopping = new BuyBook(bookName, bookAuthor, bookPub, bookPrice, imageURL, buyDate);
				shoppingList.add(shopping);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return shoppingList;
	}
	
	// 게시글 조회?

}
