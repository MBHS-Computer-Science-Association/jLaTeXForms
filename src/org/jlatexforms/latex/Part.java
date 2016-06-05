package org.jlatexforms.latex;

public class Part extends AbstractPartition implements Component {
	
	public Part(String title) {
		super("part", title);
	}

	public Part(String title, boolean listed) {
		super("part", title, listed);
	}
}
