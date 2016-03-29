package updateJIRA;

import java.io.Serializable;

public class Transition implements Serializable{
	
	private static final long serialVersionUID = 4715565261636636205L;
	
	private String id;
	private String name;
	private TransitionDetails to;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TransitionDetails getTo() {
		return to;
	}
	public void setTo(TransitionDetails to) {
		this.to = to;
	}
	
	

}
