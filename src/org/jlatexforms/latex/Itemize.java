package org.jlatexforms.latex;

import java.util.LinkedList;
import java.util.List;

public class Itemize extends AbstractEnvironment implements IndentableComponent {
	private List<CharSequence> items;
	
	public Itemize() {
		super("itemize");
		items = new LinkedList<>();
	}
	
	public void addItem(CharSequence item) {
		items.add(item);
	}
	
	public StringBuilder write() {
		return write(0);
	}

	public StringBuilder write(int indent) {
		if (items.isEmpty())
			return new StringBuilder();
		String prefix = Indenter.getIndent(indent + 1);
		StringBuilder result = beginTag(indent);
		for (CharSequence item : items) {
			result.append(prefix).append("\\item ").append(item).append('\n');
		}
		return result.append(endTag(indent));
	}
}
