package org.jlatexforms.latex;

public abstract class AbstractInlineFormatter implements Component {
	private String contents;
	private String componentName;
	
	public AbstractInlineFormatter (String componentName) {
		this.componentName = componentName;
	}
	
	protected AbstractInlineFormatter(String componentName, String contents) {
		this(componentName);
		setContents(contents);
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public StringBuilder write() {
		StringBuilder output = new StringBuilder();
		output.append("\\").append(componentName).append("{").append(contents != null ? contents : "").append("}");
		return output;
	}
}
