package org.jlatexforms.latex;

public abstract class AbstractEnvironment implements IndentableComponent {
	String componentName;
	
	protected AbstractEnvironment(String componentName) {
		this.componentName = componentName;
	}

	protected StringBuilder beginTag() {
		return beginTag(0);
	}
	
	protected StringBuilder beginTag(int indent) {
		return new StringBuilder(Indenter.getIndent(indent)).append("\\begin{").append(componentName).append("}\n");
	}

	protected StringBuilder endTag() {
		return endTag(0);
	}
	protected StringBuilder endTag(int indent) {
		return new StringBuilder(Indenter.getIndent(indent)).append("\\end{").append(componentName).append("}\n");
	}
}
