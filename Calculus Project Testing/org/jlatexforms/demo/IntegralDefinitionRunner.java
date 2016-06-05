package org.jlatexforms.demo;

import java.io.File;
import java.io.IOException;

import org.jlatexforms.latex.Document;
import org.jlatexforms.latex.Section;
import org.jlatexforms.latex.Subsection;
import org.jlatexforms.latex.Package;

public class IntegralDefinitionRunner {
	public static void main(String[] args) {
		Document document = new Document("article");
		document.add(new Package("verbatim"));
		Section definition = new Section("Standard Definition of an Integral");
		Section explanation = new Section("Explanation");
		Subsection ex1 = new Subsection("Example 1");
		Subsection ex2 = new Subsection("Example 2");
		explanation.add(ex1);
		explanation.add(ex2);
		Section assignment = new Section("Homework Assignment");
		document.add(definition);
		document.add(explanation);
		document.add(assignment);
		
		
		
		try {
			File file = new File("Calculus Project Testing/calculus.tex");
			if (!file.exists())
				file.createNewFile();
			document.generateDocument(new File("Calculus Project Testing/calculus.tex"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
