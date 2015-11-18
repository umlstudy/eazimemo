package asia.sejong.web.eazimemo.web;

import java.util.List;

public class BusinessReportToc {
	// table of concepts

	private int dcmNo;
	private int eleId;
	private int parent;
	private int tagId;
	private String tagNm;
	private int offset;
	private int length;
	private String tocText;
	private int level;

	private List<BusinessReportToc> toc;

	public int getDcmNo() {
		return dcmNo;
	}

	public void setDcmNo(int dcmNo) {
		this.dcmNo = dcmNo;
	}

	public int getEleId() {
		return eleId;
	}

	public void setEleId(int eleId) {
		this.eleId = eleId;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagNm() {
		return tagNm;
	}

	public void setTagNm(String tagNm) {
		this.tagNm = tagNm;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getTocText() {
		return tocText;
	}

	public void setTocText(String tocText) {
		this.tocText = tocText;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<BusinessReportToc> getToc() {
		return toc;
	}

	public void setToc(List<BusinessReportToc> toc) {
		this.toc = toc;
	}
}
