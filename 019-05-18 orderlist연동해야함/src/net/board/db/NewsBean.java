package net.board.db;

import java.sql.Date;

public class NewsBean {
	private int NEWS_NUM;
	private String NEWS_NAME;
	private String NEWS_CONTENTS;
	private int NEWS_READCOUNT;
	private Date NEWS_DATE;
	
	public int getNEWS_NUM() {
		return NEWS_NUM;
	}
	public void setNEWS_NUM(int nEWS_NUM) {
		NEWS_NUM = nEWS_NUM;
	}
	public String getNEWS_NAME() {
		return NEWS_NAME;
	}
	public void setNEWS_NAME(String nEWS_NAME) {
		NEWS_NAME = nEWS_NAME;
	}
	public String getNEWS_CONTENTS() {
		return NEWS_CONTENTS;
	}
	public void setNEWS_CONTENTS(String nEWS_CONTENTS) {
		NEWS_CONTENTS = nEWS_CONTENTS;
	}
	public int getNEWS_READCOUNT() {
		return NEWS_READCOUNT;
	}
	public void setNEWS_READCOUNT(int nEWS_READCOUNT) {
		NEWS_READCOUNT = nEWS_READCOUNT;
	}
	public Date getNEWS_DATE() {
		return NEWS_DATE;
	}
	public void setNEWS_DATE(Date nEWS_DATE) {
		NEWS_DATE = nEWS_DATE;
	}
}
