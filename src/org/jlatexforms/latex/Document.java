package org.jlatexforms.latex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Document {
	private List<Component> components;
	private List<Package> packages;
	private Queue<Option> options;
	private String documentClass;

	public Document(String documentClass) {
		components = new LinkedList<>();
		packages = new LinkedList<>();
		options = new LinkedList<>();
		this.documentClass = documentClass;
	}

	public void add(Component c) {
		if (c != null)
			components.add(c);
	}
	
	public void add(Package p) {
		if (p != null)
			packages.add(p);
	}
	
	public void add(Option o) {
		if (o != null)
			options.add(o);
	}

	public void generateDocument(File file) throws IOException {
		file.createNewFile();
		FileWriter fWriter = new FileWriter(file);
		StringBuilder output = new StringBuilder();
		output.append("\\documentclass");
		if (!options.isEmpty())
			output.append('[');
		while (!options.isEmpty()) {
			output.append(options.poll());
			if (!options.isEmpty())
				output.append(", ");
		}
		output.append(']');
		
		output.append('{').append(documentClass).append("}\n");

		for (Package p : packages) {
			output.append("\\usepackage").append(p.getOptions() != null ? '[' + p.getOptions() + "]{" : '{')
					.append(p.getName()).append("}\n");
		}
		
		output.append("\\begin{document}\n");

		for (Component c : components) {
			if (c instanceof IndentableComponent) {
				output.append(((IndentableComponent) c).write(1));
			} else {
				output.append(c.write());
			}
		}

		output.append("\\end{document}\n");
		fWriter.write(output.toString());
		fWriter.close();
	}
}
