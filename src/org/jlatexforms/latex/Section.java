package org.jlatexforms.latex;

public class Section extends AbstractPartition implements Component {
	
	public Section(String title) {
		super("section", title);
	}
	
	public Section(String title, boolean listed) {
		super("section", title, listed);
	}
}
