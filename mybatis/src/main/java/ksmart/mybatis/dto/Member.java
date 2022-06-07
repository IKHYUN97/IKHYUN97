package ksmart.mybatis.dto;

public class Member {
	private String MemberId;
	private String MemberPw;
	private String MemberLevel;
	private String MemberEmail;
	private String MemberName;
	@Override
	public String toString() {
		return "Member [MemberId=" + MemberId + ", MemberPw=" + MemberPw + ", MemberLevel=" + MemberLevel
				+ ", MemberEmail=" + MemberEmail + ", MemberName=" + MemberName + ", MemberAddr=" + MemberAddr
				+ ", MemberRegDate=" + MemberRegDate + "]";
	}
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	public String getMemberPw() {
		return MemberPw;
	}
	public void setMemberPw(String memberPw) {
		MemberPw = memberPw;
	}
	public String getMemberLevel() {
		return MemberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		MemberLevel = memberLevel;
	}
	public String getMemberEmail() {
		return MemberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		MemberEmail = memberEmail;
	}
	public String getMemberName() {
		return MemberName;
	}
	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
	public String getMemberAddr() {
		return MemberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		MemberAddr = memberAddr;
	}
	public String getMemberRegDate() {
		return MemberRegDate;
	}
	public void setMemberRegDate(String memberRegDate) {
		MemberRegDate = memberRegDate;
	}
	private String MemberAddr;
	private String MemberRegDate;
}
