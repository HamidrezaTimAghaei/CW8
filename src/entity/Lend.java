package entity;

import java.util.Date;

public class Lend {
    private int lendId;
    private Date lendDate;
    private Date returnDate;
    private int bookId;
    private int memberId;

    public Lend(int lendId, Date lendDate, Date returnDate, int bookId, int memberId) {

        this.lendId = lendId;
        this.lendDate = lendDate;
        this.returnDate = returnDate;
        this.bookId = bookId;
        this.memberId = memberId;
    }


    public int getLendId() {
        return lendId;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setLendId(int lendId) {
        this.lendId = lendId;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
