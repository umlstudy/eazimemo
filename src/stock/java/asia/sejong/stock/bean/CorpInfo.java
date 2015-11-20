package asia.sejong.stock.bean;

public class CorpInfo {
	
	// {"rlist":[
	// {"row_num":"1","cik":"01007356","ifm_nm":"제니퍼소프트","crp_code":" ","crp_rgs_cls":"E","dsm_nm":null}
	// ],"totalPage":1,"totCount":1}

	private String rowNum;
	private String cik;
	private String ifmNm;
	private String crpCode;
	private String crpRgsCls;
	private String dsmNm;

	public String getRowNum() {
		return rowNum;
	}

	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}

	public String getCik() {
		return cik;
	}

	public void setCik(String cik) {
		this.cik = cik;
	}

	public String getIfmNm() {
		return ifmNm;
	}

	public void setIfmNm(String ifmNm) {
		this.ifmNm = ifmNm;
	}

	public String getCrpCode() {
		return crpCode;
	}

	public void setCrpCode(String crpCode) {
		this.crpCode = crpCode;
	}

	public String getCrpRgsCls() {
		return crpRgsCls;
	}

	public void setCrpRgsCls(String crpRgsCls) {
		this.crpRgsCls = crpRgsCls;
	}

	public String getDsmNm() {
		return dsmNm;
	}

	public void setDsmNm(String dsmNm) {
		this.dsmNm = dsmNm;
	}
}
