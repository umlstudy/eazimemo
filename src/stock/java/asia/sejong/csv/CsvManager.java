package asia.sejong.csv;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;

import asia.sejong.web.eazimemo.util.ExceptionUtil;

public class CsvManager {

	public static <T> List<T> readCsvFile(Class<T> clazz, String csvFilePath, String[] headerMapping) {

		InputStreamReader reader = null;
		CSVParser csvFileParser = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(headerMapping);

		try {

			List<T> records = new ArrayList<T>();
			reader = new InputStreamReader(clazz.getResourceAsStream(csvFilePath), Charset.forName("UTF-8"));
			csvFileParser = new CSVParser(reader, csvFileFormat);
			List<CSVRecord> csvRecords = csvFileParser.getRecords();

			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord csvRecord = csvRecords.get(i);
				T record = clazz.newInstance();
		        BeanUtils.populate(record, csvRecord.toMap());
		        records.add(record);
			}
			
			return records;
		} catch (Exception e) {
			e.printStackTrace();
			throw ExceptionUtil.getRuntimeException(e);
		} finally {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(csvFileParser);
		}
	}
}
