package asia.sejong.web.eazimemo.web;

import java.util.List;

public class BusinessReportDescriptors {
	private String errCode;
	private String errMsg;
	private int pageNo;
	private int pageSet;
	private int totalCount;
	private int totalPage;
	
	private List<BusinessReportDescriptor> list;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSet() {
		return pageSet;
	}

	public void setPageSet(int pageSet) {
		this.pageSet = pageSet;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<BusinessReportDescriptor> getList() {
		return list;
	}

	public void setList(List<BusinessReportDescriptor> list) {
		this.list = list;
	}
}
