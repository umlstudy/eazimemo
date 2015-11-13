package asia.sejong.web.eazimemo.web;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import asia.sejong.csv.CsvManager;
import asia.sejong.csv.MyStock;
import asia.sejong.web.eazimemo.util.DateUtil;

@Controller
@RequestMapping("/stock")
public class StockController {
	
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
	
	public static void main(String...args) {
		new StockController().stockList();
	}
}
