package domain;

import java.sql.Date;

public class BuyBook {

    private int memberId;
    private int bookNum;
    private int isBuy;
    private int count;
    private String bookName;
    private String bookAuthor;
    private String bookPub;
    private int bookPrice;
    private String imageURL;
    private Date buyDate;

    public BuyBook(int memberId, int bookNum, int isBuy, int count, Date buyDate) {
        this.memberId = memberId;
        this.bookNum = bookNum;
        this.isBuy = isBuy;
        this.count = count;
        this.buyDate = buyDate;
    }

    public BuyBook(String bookName , String bookAuthor , String bookPub, int bookPrice, String imageURL, Date buyDate )
    {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPub = bookPub;
        this.bookPrice = bookPrice;
        this.imageURL = imageURL;
        this.buyDate = buyDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPub() {
        return bookPub;
    }

    public void setBookPub(String bookPub) {
        this.bookPub = bookPub;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public int getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(int isBuy) {
        this.isBuy = isBuy;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
