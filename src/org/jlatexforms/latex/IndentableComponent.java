package org.jlatexforms.latex;

public interface IndentableComponent extends Component {
	public  StringBuilder write(int indent);
}
