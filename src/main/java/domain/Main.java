package domain;

public class Main{
	private int id;
    private int bookNum;
    private String bookName;
    private String bookAuthor;
    private String bookPub;
    private int bookPrice;
    private String title;
    private String contents;

    public Main(int bookNum, String bookName, String bookAuthor, int bookPrice) {
        this.bookNum = bookNum;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;

    }
    
    public Main(int id, String title) {
    	this.id = id;
    	this.title = title;

    }
    
    public Main(int bookNum, String bookName, String bookAuthor, String bookPub, int bookPrice, String title, String contents) {
        this.bookNum = bookNum;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPub = bookPub;
        this.bookPrice = bookPrice;
        this.title = title;
        this.contents = contents;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
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
    
    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookNum=" + bookNum +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPub='" + bookPub + '\'' +
                ", bookPrice=" + bookPrice + ", title=" + title 
                + ", contents=" + contents + '}';
    }
}
