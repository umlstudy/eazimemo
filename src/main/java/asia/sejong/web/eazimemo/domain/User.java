package asia.sejong.web.eazimemo.domain;

public class User {

	private String userId;
private String password;
private Byte enabled;

	
	public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Byte getEnabled() {
	return enabled;
}

public void setEnabled(Byte enabled) {
	this.enabled = enabled;
}


}
