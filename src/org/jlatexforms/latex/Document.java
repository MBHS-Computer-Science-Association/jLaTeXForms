package org.jlatexforms.latex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Document {
	private List<Component> components;
	private List<Package> packages;
	private String documentClass;
	
	public Document(String documentClass) {
		components = new LinkedList<>();
		this.documentClass = documentClass;
	}
	
	public void add(Component c) {
		components.add(c);
	}
	
	public void generateDocument(File file) throws IOException {
		FileWriter fWriter = new FileWriter(file);
		StringBuilder output = new StringBuilder();
		output.append("\\documentclass{").append(documentClass).append("}\n");
		output.append("\\begin{document}\n");
		
		
		
		output.append("\\end{document}\n");
		fWriter.write(output.toString());
	}
}
