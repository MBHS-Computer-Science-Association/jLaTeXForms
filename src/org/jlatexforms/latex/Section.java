package org.jlatexforms.latex;

public class Section implements Component {
	private LineList contents;
	private String title;
	public Section(String title) {
		this.title = title;
	}

	public StringBuilder write() {
		StringBuilder output = new StringBuilder();
		output.append("\\section{").append(title).append("}\n");
		output.append(contents.write());
		return output;
	}
}
