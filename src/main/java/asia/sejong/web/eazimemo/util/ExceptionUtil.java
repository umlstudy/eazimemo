package asia.sejong.web.eazimemo.util;

public class ExceptionUtil {
	
	public static String getCauseMessage(Throwable t) {
		String msg = null;
		if ( t == null ) {
			return null;
		}
		
		msg = getMessage(t);
		while ( t.getCause() != null ) {
			t = t.getCause();
			String tmpMsg = getMessage(t);
			if ( !StringUtil.isEmpty(tmpMsg) ) {
				msg = tmpMsg;
			}
		}
		
		return msg;
	}
	
	public static String getMessage(Throwable t) {
		if ( t == null ) {
			return null;
		}
		
		if ( t.getMessage() != null ) {
			return t.getMessage();
		}
		
		return t.getClass().getSimpleName();
	}
	
	public static RuntimeException getRuntimeException(Exception e) {
		if ( e instanceof RuntimeException ) {
			return  (RuntimeException)e;
		} else {
			return new RuntimeException(e);
		}
	}
}
