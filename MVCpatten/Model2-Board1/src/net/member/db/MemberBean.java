package net.member.db;

public class MemberBean {
	private String member_id, member_pw, member_email, member_name, member_mempr, member_jumin, member_birth;
	private String[] member_hobby;
	
	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String[] getMember_hobby() {
		return member_hobby;
	}

	public void setMember_hobby(String[] strings) {
		this.member_hobby = strings;
	}

	public String getMember_jumin() {
		return member_jumin;
	}

	public void setMember_jumin(String member_jumin) {
		this.member_jumin = member_jumin;
	}

	public String getMember_birth() {
		return member_birth;
	}

	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}

	public String getMember_mempr() {
		return member_mempr;
	}

	public void setMember_mempr(String member_mempr) {
		this.member_mempr = member_mempr;
	}
}
