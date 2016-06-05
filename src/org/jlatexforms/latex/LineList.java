package org.jlatexforms.latex;

import java.util.LinkedList;
import java.util.List;

public class LineList implements IndentableComponent {
	private List<CharSequence> lines;
	
	public LineList() {
		lines = new LinkedList<>();
	}

	public LineList(CharSequence line) {
		this();
		lines.add(line);
	}

	public void add(CharSequence line) {
		lines.add(line.toString());
	}
	
	public void addln(CharSequence line) {
		lines.add(line.toString() + "\n");
	}
	
	public StringBuilder write() {
		return write(0);
	}
	
	public StringBuilder write(int indent) {
		String prefix = Indenter.getIndent(indent);
		StringBuilder output = new StringBuilder();
		for (CharSequence line : lines)
			output.append(prefix).append(line);
		return output;
	}
}
