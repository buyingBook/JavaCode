package domain;

import java.sql.Date;
import java.time.LocalDateTime;

public class Board {
    private int id;
    private String title;
    private String writer;
    private String contents;
    private Date regdate;
    private int hit;

    public Board() {
    }

    public Board(int id, String title, String writer, String contents, Date regdate, int hit) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.contents = contents;
        this.regdate = regdate;
        this.hit = hit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", contents='" + contents + '\'' +
                ", regdate=" + regdate +
                ", hit=" + hit +
                '}';
    }
}
