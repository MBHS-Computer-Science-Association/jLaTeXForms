package org.jlatexforms.latex;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractPartition implements IndentableComponent {
	private List<Component> components;
	private String componentName;
	private String title;
	private boolean listed;
	
	protected AbstractPartition(String componentName, String title) {
		this(componentName, title, true);
	}
	
	protected AbstractPartition(String componentName, String title, boolean listed) {
		this.componentName = componentName;
		this.title = title;
		this.components = new LinkedList<>();
		this.listed = listed;
	}
	
	public void setListed(boolean listed) {
		this.listed = listed;
	}
	
	public boolean isListed() {
		return listed;
	}
	
	public void addln(CharSequence line) {
		components.add(new LineList(line));
	}
	
	public void add(Component component) {
		components.add(component);
	}

	public StringBuilder write() {
		return write(0);
	}

	public StringBuilder write(int indent) {
		String prefix = Indenter.getIndent(indent);
		StringBuilder output = new StringBuilder();
		output.append(prefix).append("\\").append(componentName).append(listed?"":"*").append("{").append(title).append("}\n");

		for (Component c : components) {
			if (c instanceof IndentableComponent) {
				output.append(((IndentableComponent) c).write(indent + 1));
			} else {
				output.append(c.write());
			}
		}

		return output;
	}
}
