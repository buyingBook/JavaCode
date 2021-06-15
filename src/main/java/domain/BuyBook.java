package domain;

import java.sql.Date;

public class BuyBook {
    int memberId;
    int bookNum;
    int isBuy;
    Date buydate;
    int count;

    public BuyBook(int memberId, int bookNum, int isBuy, Date buydate, int count) {
        this.memberId = memberId;
        this.bookNum = bookNum;
        this.isBuy = isBuy;
        this.buydate = buydate;
        this.count = count;
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

    public Date getBuydate() {
        return buydate;
    }

    public void setBuydate(Date buydate) {
        this.buydate = buydate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BuyBook{" +
                "memberId=" + memberId +
                ", bookNum=" + bookNum +
                ", isBuy=" + isBuy +
                ", buydate=" + buydate +
                ", count=" + count +
                '}';
    }
}
