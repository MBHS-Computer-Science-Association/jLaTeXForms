package org.jlatexforms.latex;

public class Package {
	private String name;
	private String options;
	
	public Package(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getOptions() {
		return options;
	}
	
	public void setOptions(String options) {
		this.options = options;
	}
}
