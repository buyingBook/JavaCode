package domain;

public class Class {
    private int classNum;
    private String className;
    private String majorName;
    private String professer;
    private int bookNum;
    private int grade;

    public Class(int classNum, String className, String majorName, String professer, int bookNum, int grade) {
        this.classNum = classNum;
        this.className = className;
        this.majorName = majorName;
        this.professer = professer;
        this.bookNum = bookNum;
        this.grade = grade;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getProfesser() {
        return professer;
    }

    public void setProfesser(String professer) {
        this.professer = professer;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
