package updateJIRA;

import java.io.Serializable;
import java.util.List;

public class Transitions implements Serializable{
	
	private static final long serialVersionUID = 1086334644415631550L;
	
	private String expand;
	private List transitions;
	
	public String getExpand() {
		return expand;
	}
	public void setExpand(String expand) {
		this.expand = expand;
	}
	public List getTransitions() {
		return transitions;
	}
	public void setTransitions(List transitions) {
		this.transitions = transitions;
	}
	
}
