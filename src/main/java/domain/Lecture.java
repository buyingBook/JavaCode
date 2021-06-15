package domain;

public class Lecture {
    private int lectureNum;
    private String lectureName;
    private String majorName;
    private String professor;
    private int bookNum;
    private int grade;

    public Lecture(String majorName, int grade) {
        this.majorName = majorName;
        this.grade = grade;
    }

    public Lecture(int lectureNum, String lectureName, String majorName, String professor, int bookNum, int grade) {
        this.lectureNum = lectureNum;
        this.lectureName = lectureName;
        this.majorName = majorName;
        this.professor = professor;
        this.bookNum = bookNum;
        this.grade = grade;
    }

    public int getLectureNum() {
        return lectureNum;
    }

    public void setLectureNum(int lectureNum) {
        this.lectureNum = lectureNum;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfesser(String professor) {
        this.professor = professor;
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
