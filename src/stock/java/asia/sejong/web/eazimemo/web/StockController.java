package asia.sejong.web.eazimemo.web;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import asia.sejong.csv.CsvManager;
import asia.sejong.csv.MyStock;
import asia.sejong.web.eazimemo.util.DateUtil;
import asia.sejong.web.eazimemo.util.HttpClientUtil;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	private static final String AUTH_KEY = "cd6db35804fa27a6d94f9476659ec0aeeede155b";

	private static final Gson GSON_LOWER_CASE_WITH_UNDERSCORES = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
	private static final Gson GSON = new GsonBuilder().create();
	
	final Logger logger = LoggerFactory.getLogger(StockController.class);
	
	@RequestMapping(method = RequestMethod.GET, value = "/stockList")
	public ModelAndView stockList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/stock/stockList");
		
		List<MyStock> records = CsvManager.readCsvFile(MyStock.class, "/MyStock.csv", MyStock.getFileHeaderMapping());
		for ( MyStock record : records ) {
			String datetime = DateUtil.getString("yyyyMMddhhmm", new Date());
			record.setChartUrl(String.format("http://chart.finance.daum.net/time3/3year/%s-290157.png?date=%s", record.getShcode2(), datetime));
		}
		
		mv.addObject("myStocks", records);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/businessReport")
	public ModelAndView businessReport() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/stock/businessReport");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/businessReportDescriptors")
	public String businessReportDescriptors(String shCode) throws Exception {
		
		String url = "http://dart.fss.or.kr/api/search.json?auth=%s&crp_cd=%s&start_dt=19990101&bsn_tp=A001&bsn_tp=A002&bsn_tp=A003";
		String json = HttpClientUtil.get(String.format(url, AUTH_KEY, shCode));
		BusinessReportDescriptors brDescriptors = GSON_LOWER_CASE_WITH_UNDERSCORES.fromJson(json, BusinessReportDescriptors.class);
		
		return GSON.toJson(brDescriptors);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/businessReportSectionInfo")
	public String businessReportSectionInfo(String rcpNo) throws Exception {
		
		String url = "http://m.dart.fss.or.kr/viewer/main.st?rcpNo=%s";
		String json = HttpClientUtil.get(String.format(url, rcpNo));
		BusinessReportSectionInfo brSectionInfo = GSON.fromJson(json, BusinessReportSectionInfo.class);
		
		return GSON.toJson(brSectionInfo);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/businessReportSectionDetail")
	public String businessReportSectionDetail(String rcpNo, int dcmNo, int eleId) throws Exception {
		
		String url = "http://m.dart.fss.or.kr/report/main.do?rcpNo=%s&dcmNo=%d&eleId=%d";
		String rslt = HttpClientUtil.get(String.format(url, rcpNo, dcmNo, eleId));
		
		return rslt;
	}
	
	public static void main(String...args) throws Exception {
		System.out.println(new StockController().businessReportDescriptors("005930"));
		System.out.println(new StockController().businessReportSectionInfo("20151116000976"));
		System.out.println(new StockController().businessReportSectionDetail("20151116000976", 4854164, 29));
	}
}
