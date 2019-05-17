package net.notice.db;

import java.sql.Date;

public class NoticeBean {
	private int NOTICE_NUM;
	private String NOTICE_SUBJECT;
	private String NOTICE_CONTENTS;
	private Date NOTICE_DATE;
	private int NOTICE_READCOUNT;
	public int getNOTICE_NUM() {
		return NOTICE_NUM;
	}
	public void setNOTICE_NUM(int nOTICE_NUM) {
		NOTICE_NUM = nOTICE_NUM;
	}
	public String getNOTICE_SUBJECT() {
		return NOTICE_SUBJECT;
	}
	public void setNOTICE_SUBJECT(String nOTICE_SUBJECT) {
		NOTICE_SUBJECT = nOTICE_SUBJECT;
	}
	public String getNOTICE_CONTENTS() {
		return NOTICE_CONTENTS;
	}
	public void setNOTICE_CONTENTS(String nOTICE_CONTENTS) {
		NOTICE_CONTENTS = nOTICE_CONTENTS;
	}
	public Date getNOTICE_DATE() {
		return NOTICE_DATE;
	}
	public void setNOTICE_DATE(Date nOTICE_DATE) {
		NOTICE_DATE = nOTICE_DATE;
	}
	public int getNOTICE_READCOUNT() {
		return NOTICE_READCOUNT;
	}
	public void setNOTICE_READCOUNT(int nOTICE_READCOUNT) {
		NOTICE_READCOUNT = nOTICE_READCOUNT;
	}
}
