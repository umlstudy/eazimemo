package asia.sejong.stock.bean;

import java.util.List;

public class PageItem<T> {

	private List<T> rlist;
	private int totalPage;
	private int totCount;

	public List<T> getRlist() {
		return rlist;
	}

	public void setRlist(List<T> rlist) {
		this.rlist = rlist;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotCount() {
		return totCount;
	}

	public void setTotCount(int totCount) {
		this.totCount = totCount;
	}
}