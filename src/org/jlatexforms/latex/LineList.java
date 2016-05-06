package org.jlatexforms.latex;

import java.util.LinkedList;
import java.util.List;

public class LineList {
	private List<String> lineList;
	private int indent;
	
	public LineList() {
		indent = 0;
		lineList = new LinkedList<>();
	}
	
	public void setIndent(int indent) {
		this.indent = indent;
	}
	
	public StringBuilder write() {
		return write(indent);
	}
	
	public StringBuilder write(int indent) {
		String prefix = "";
		for (int i = 0; i < indent; i++)
			prefix += "    ";
		
		StringBuilder output = new StringBuilder();
		
		for (String line : lineList) {
			output.append(prefix).append(line).append("\n");
		}
		
		return output;
	}
}
