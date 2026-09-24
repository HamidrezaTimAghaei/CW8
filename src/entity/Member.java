package entity;

import java.time.Instant;
import java.util.Date;

public class Member {
    private int memberId;
    private String memberName;
    private Date memberDate;

    public Member() {

    }

    public Member(int memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberDate = Date.from(Instant.now());
    }

    public Member(String memberName, Date memberDate) {
        this.memberName = memberName;
        this.memberDate = memberDate;
    }


    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getMemberDate() {
        return memberDate;
    }

    public void setMemberDate(Date memberDate) {
        this.memberDate = memberDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", memberDate=" + memberDate +
                '}';
    }
}
