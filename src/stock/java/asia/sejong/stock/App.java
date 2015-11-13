package asia.sejong.stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

import asia.sejong.csv.CsvManager;
import asia.sejong.csv.MyStock;

// http://blog.k11i.biz/2014/09/java-utf-8.html
public class App {
	public static void main(String[] args) {
		Properties prop = new Properties();
		InputStream is = null;
		InputStreamReader isr = null;
		try {
			is = App.class.getResourceAsStream("/stock.properties");
			isr = new InputStreamReader(is, "UTF-8");
            BufferedReader reader = new BufferedReader(isr);
            prop.load(reader);
			for ( Object key : prop.keySet() ) {
				System.out.println(key + ","+ prop.get(key));
			}
			
			System.out.println("..............");
			
			List<MyStock> records = CsvManager.readCsvFile(MyStock.class, "/MyStock.csv", MyStock.getFileHeaderMapping());
			System.out.println(records);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(isr);
		}
	}
}
