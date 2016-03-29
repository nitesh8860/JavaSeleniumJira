package updateJIRA;

import java.io.Serializable;

public class CreateIssue implements Serializable{
	
	private static final long serialVersionUID = 7588192347513255704L;
	
	private String id;
	private String key;
	private String self;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	
	
	
	

}
