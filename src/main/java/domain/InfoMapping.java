package domain;

public class InfoMapping {
    private int lectureNum;
    private String lectureName;
    private String majorName;
    private String professor;
    private int bookNum;
    private int grade;
    private String bookName;
    private String bookAuthor;
    private String bookPub;
    private int bookPrice;
    private String imageURL;

    public InfoMapping(int lectureNum, String lectureName, String majorName, String professor, int bookNum, int grade,
                       String bookName, String bookAuthor, String bookPub, int bookPrice, String imageURL) {
        this.lectureNum = lectureNum;
        this.lectureName = lectureName;
        this.majorName = majorName;
        this.professor = professor;
        this.bookNum = bookNum;
        this.grade = grade;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPub = bookPub;
        this.bookPrice = bookPrice;
        this.imageURL = imageURL;
    }

    public int getLectureNum() {
        return lectureNum;
    }

    public String getLectureName() {
        return lectureName;
    }

    public String getMajorName() {
        return majorName;
    }

    public String getProfessor() {
        return professor;
    }

    public int getBookNum() {
        return bookNum;
    }

    public int getGrade() {
        return grade;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookPub() {
        return bookPub;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public String getImageURL() {
        return imageURL;
    }
}
