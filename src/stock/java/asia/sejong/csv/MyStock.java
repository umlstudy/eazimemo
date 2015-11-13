package asia.sejong.csv;

import com.google.gson.GsonBuilder;

public class MyStock {
	// CSV file header
	private static final String[] FILE_HEADER_MAPPING = { "hname", "ownCnt",
			"ownCnt2", "yesterdayCnt", "todayCnt", "buyOnePrice",
			"nowOnePrice", "profit", "profitRate", "buyPrice", "nowPrice",
			"shcode", "hname2", "rentDay", "profitRateDetail" };

	private String hname;
	private long ownCnt;
	private long ownCnt2;
	private long yesterdayCnt;
	private long todayCnt;
	private long buyOnePrice;
	private long nowOnePrice;
	private long profit;
	private double profitRate;
	private long buyPrice;
	private long nowPrice;
	private String shcode;
	private String hname2;
	private String rentDay;
	private long profitRateDetail;
	private String chartUrl;

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public long getOwnCnt() {
		return ownCnt;
	}

	public void setOwnCnt(long ownCnt) {
		this.ownCnt = ownCnt;
	}

	public long getOwnCnt2() {
		return ownCnt2;
	}

	public void setOwnCnt2(long ownCnt2) {
		this.ownCnt2 = ownCnt2;
	}

	public long getYesterdayCnt() {
		return yesterdayCnt;
	}

	public void setYesterdayCnt(long yesterdayCnt) {
		this.yesterdayCnt = yesterdayCnt;
	}

	public long getTodayCnt() {
		return todayCnt;
	}

	public void setTodayCnt(long todayCnt) {
		this.todayCnt = todayCnt;
	}

	public long getBuyOnePrice() {
		return buyOnePrice;
	}

	public void setBuyOnePrice(long buyOnePrice) {
		this.buyOnePrice = buyOnePrice;
	}

	public long getNowOnePrice() {
		return nowOnePrice;
	}

	public void setNowOnePrice(long nowOnePrice) {
		this.nowOnePrice = nowOnePrice;
	}

	public long getProfit() {
		return profit;
	}

	public void setProfit(long profit) {
		this.profit = profit;
	}

	public double getProfitRate() {
		return profitRate;
	}

	public void setProfitRate(double profitRate) {
		this.profitRate = profitRate;
	}

	public long getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(long buyPrice) {
		this.buyPrice = buyPrice;
	}

	public long getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(long nowPrice) {
		this.nowPrice = nowPrice;
	}

	public String getShcode() {
		return shcode;
	}

	public void setShcode(String shcode) {
		this.shcode = shcode;
	}

	public String getHname2() {
		return hname2;
	}

	public void setHname2(String hname2) {
		this.hname2 = hname2;
	}

	public String getRentDay() {
		return rentDay;
	}

	public void setRentDay(String rentDay) {
		this.rentDay = rentDay;
	}

	public long getProfitRateDetail() {
		return profitRateDetail;
	}

	public void setProfitRateDetail(long profitRateDetail) {
		this.profitRateDetail = profitRateDetail;
	}

	public static String[] getFileHeaderMapping() {
		return FILE_HEADER_MAPPING;
	}
	
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}
	
	public String getShcode2() {
		return shcode.replace("\'", "");
	}

	public String getChartUrl() {
		return chartUrl;
	}

	public void setChartUrl(String chartUrl) {
		this.chartUrl = chartUrl;
	}
}
