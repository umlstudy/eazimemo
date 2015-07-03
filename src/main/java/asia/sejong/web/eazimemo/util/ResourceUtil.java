package asia.sejong.web.eazimemo.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.IOUtils;

public class ResourceUtil {
	
	public static String read(Class<?> clazz, String fileName)  {
		try {
			return read(clazz, fileName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw ExceptionUtil.getRuntimeException(e);
		}
	}

	public static String read(Class<?> clazz, String fileName, String charset) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		String line = null;
		try {
			br = new BufferedReader(new InputStreamReader(clazz.getResourceAsStream(fileName), charset));
			while ( ( line = br.readLine() ) != null ) {
				sb.append(line);
				sb.append("\n");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(br);
		}
		return sb.toString();
	}
	
	public static void write(String filePath, String fileName, String content)  {
		write(filePath, fileName, content, "UTF-8");
	}
	
	public static void write(String filePath, String fileName, String content, String charset) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath + "\\" + fileName), charset));
			bw.write(content);
			bw.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(bw);
		}
	}
}
