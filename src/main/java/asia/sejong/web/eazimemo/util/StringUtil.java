package asia.sejong.web.eazimemo.util;


public class StringUtil {

	public static String toString(Object object) {
		if ( object == null ) return "";
		return object.toString();
	}

	public static boolean isEmpty(String string) {
		return !(string != null && string.trim().length()>0);
	}
	
	public static String toPascalCase(String str) {
		return str.substring(0,1).toUpperCase() + str.substring(1);
	}
}
