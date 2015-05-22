package asia.sejong.web.eazimemo.web.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class JsonResult {

	private Throwable error;
	private Object result;
	
	private JsonResult() {
	}
	
	public static final JsonResult createError(Throwable error) {
		return new JsonResult().setError(error);
	}

	public static final JsonResult create(Object result) {
		return new JsonResult().setResult(result);
	}

	public Throwable getError() {
		return error;
	}

	public JsonResult setError(Throwable error) {
		this.error = error;
		return this;
	}

	public Object getResult() {
		return result;
	}

	public JsonResult setResult(Object result) {
		this.result = result;
		return this;
	}
}
