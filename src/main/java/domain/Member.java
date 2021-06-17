package domain;

public class Member {
    private int memberId;		//id
    private String memberPwd;	//pwd
    private String memberNo;	//학번
    private String memberName;	//이름
    private String memberMajor;	//학과
    private int memberYear;		//학년
    private boolean isManage;	//관리자여s부

    public Member()
    {

    }
    public Member(int memberId, String memberPwd, String memberNo, String memberName, String memberMajor, int memberYear)
    {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.memberMajor = memberMajor;
        this.memberYear = memberYear;
    }
    public int getMemberId() {
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public String getMemberPwd() {
        return memberPwd;
    }
    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }
    public String getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public String getMemberMajor() {
        return memberMajor;
    }
    public void setMemberMajor(String memberMajor) {
        this.memberMajor = memberMajor;
    }
    public int getMemberYear() {
        return memberYear;
    }
    public void setMemberYear(int memberYear) {
        this.memberYear = memberYear;
    }
    public boolean isManage() {
        return isManage;
    }
    public void setManage(boolean isManage) {
        this.isManage = isManage;
    }


}
