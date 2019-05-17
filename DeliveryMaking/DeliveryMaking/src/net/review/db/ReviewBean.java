package net.review.db;

import java.sql.Date;

public class ReviewBean {
	private int REVIEW_NUM;
	private String REVIEW_SUBJECT;
	private String REVIEW_NAME;
	private String REVIEW_PASS;
	private String REVIEW_CONTENTS;
	private int REVIEW_RE_REF;
	private int REVIEW_RE_LEV;
	private int REVIEW_RE_SEQ;
	private Date REVIEW_DATE;
	private int REVIEW_READCOUNT;

	public int getREVIEW_NUM() {
		return REVIEW_NUM;
	}

	public void setREVIEW_NUM(int rEVIEW_NUM) {
		REVIEW_NUM = rEVIEW_NUM;
	}

	public String getREVIEW_SUBJECT() {
		return REVIEW_SUBJECT;
	}

	public void setREVIEW_SUBJECT(String rEVIEW_SUBJECT) {
		REVIEW_SUBJECT = rEVIEW_SUBJECT;
	}

	public String getREVIEW_NAME() {
		return REVIEW_NAME;
	}

	public void setREVIEW_NAME(String rEVIEW_NAME) {
		REVIEW_NAME = rEVIEW_NAME;
	}

	public String getREVIEW_CONTENTS() {
		return REVIEW_CONTENTS;
	}

	public void setREVIEW_CONTENTS(String rEVIEW_CONTENTS) {
		REVIEW_CONTENTS = rEVIEW_CONTENTS;
	}

	public int getREVIEW_RE_REF() {
		return REVIEW_RE_REF;
	}

	public void setREVIEW_RE_REF(int rEVIEW_RE_REF) {
		REVIEW_RE_REF = rEVIEW_RE_REF;
	}

	public int getREVIEW_RE_LEV() {
		return REVIEW_RE_LEV;
	}

	public void setREVIEW_RE_LEV(int rEVIEW_RE_LEV) {
		REVIEW_RE_LEV = rEVIEW_RE_LEV;
	}

	public int getREVIEW_RE_SEQ() {
		return REVIEW_RE_SEQ;
	}

	public void setREVIEW_RE_SEQ(int rEVIEW_RE_SEQ) {
		REVIEW_RE_SEQ = rEVIEW_RE_SEQ;
	}

	public Date getREVIEW_DATE() {
		return REVIEW_DATE;
	}

	public void setREVIEW_DATE(Date rEVIEW_DATE) {
		REVIEW_DATE = rEVIEW_DATE;
	}

	public int getREVIEW_READCOUNT() {
		return REVIEW_READCOUNT;
	}

	public void setREVIEW_READCOUNT(int rEVIEW_READCOUNT) {
		REVIEW_READCOUNT = rEVIEW_READCOUNT;
	}

	public String getREVIEW_PASS() {
		return REVIEW_PASS;
	}

	public void setREVIEW_PASS(String rEVIEW_PASS) {
		REVIEW_PASS = rEVIEW_PASS;
	}

}