package org.jlatexforms.latex;

public class Subsection extends AbstractPartition implements Component {
	
	public Subsection(String title) {
		super("subsection", title);
	}

	public Subsection(String title, boolean listed) {
		super("subsection", title, listed);
	}
}
