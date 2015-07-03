package dbwork;

import java.util.HashMap;
import java.util.Map;

public class DBWorkUtil {

	private static Map<String, Class<?>> JAVA_MYSQL_TYPEMAP = new HashMap<String, Class<?>>();
	static {
		JAVA_MYSQL_TYPEMAP.put("CHAR",String.class);
		JAVA_MYSQL_TYPEMAP.put("VARCHAR",String.class);
		JAVA_MYSQL_TYPEMAP.put("LONGVARCHAR",String.class);
		JAVA_MYSQL_TYPEMAP.put("MEDIUMTEXT",String.class);
		JAVA_MYSQL_TYPEMAP.put("NUMERIC",java.math.BigDecimal.class);
		JAVA_MYSQL_TYPEMAP.put("DECIMAL",java.math.BigDecimal.class);
		JAVA_MYSQL_TYPEMAP.put("BIT",Boolean.class);
		JAVA_MYSQL_TYPEMAP.put("TINYINT",Byte.class);
		JAVA_MYSQL_TYPEMAP.put("SMALLINT",Short.class);
		JAVA_MYSQL_TYPEMAP.put("INTEGER",Integer.class);
		JAVA_MYSQL_TYPEMAP.put("INT UNSIGNED",Integer.class);
		JAVA_MYSQL_TYPEMAP.put("BIGINT",Long.class);
		JAVA_MYSQL_TYPEMAP.put("REAL",Float.class);
		JAVA_MYSQL_TYPEMAP.put("FLOAT",Double.class);
		JAVA_MYSQL_TYPEMAP.put("DOUBLE",Double.class);
		JAVA_MYSQL_TYPEMAP.put("BINARY",Byte[].class);
		JAVA_MYSQL_TYPEMAP.put("VARBINARY",Byte[].class);
		JAVA_MYSQL_TYPEMAP.put("LONGVARBINARY",Byte[].class);
		JAVA_MYSQL_TYPEMAP.put("DATE",java.sql.Date.class);
		JAVA_MYSQL_TYPEMAP.put("TIME",java.sql.Time.class);
		JAVA_MYSQL_TYPEMAP.put("TIMESTAMP", java.sql.Timestamp.class);
	}
	
	public static final Class<?> getType(String dbType) {
		return JAVA_MYSQL_TYPEMAP.get(dbType.toUpperCase().trim());
	}
	
	public static final String getTypeString(String dbType) {
		return getType(dbType).getSimpleName();
	}
}
