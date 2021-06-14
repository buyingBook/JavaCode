package domain;

public class Book {
    private int bookNum;
    private String bookName;
    private String bookAuthor;
    private String bookPub;
    private int bookPrice;
    private String imageURL;

    public Book(int bookNum, String bookName, String bookAuthor, String bookPub, int bookPrice, String imageURL) {
        this.bookNum = bookNum;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPub = bookPub;
        this.bookPrice = bookPrice;
        this.imageURL = imageURL;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookNum=" + bookNum +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPub='" + bookPub + '\'' +
                ", bookPrice=" + bookPrice +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
