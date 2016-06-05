package org.jlatexforms.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jlatexforms.latex.Document;
import org.jlatexforms.latex.Itemize;
import org.jlatexforms.latex.LineList;
import org.jlatexforms.latex.Option;
import org.jlatexforms.latex.Package;
import org.jlatexforms.latex.Part;
import org.jlatexforms.latex.Section;
import org.jlatexforms.latex.Subsection;

public class KeyComparisonsRunner {
	public static Document getDocumentSkeleton() {
		Document res = new Document("article");
		Package geometry = new Package("geometry");
		geometry.setOptions("margin=1in");
		res.add(geometry);

		res.add(new Option("letterpaper"));
		res.add(new Option("10pt"));

		LineList header = new LineList();
		header.addln("\\setcounter{secnumdepth}{-1}\n");
		header.addln("Thai Nguyen\n");
		header.addln("Mr. Scott Martin\n");
		header.addln("AP World History GT - 1\n");
		header.addln("21 May 2016\n");
		res.add(header);
		header.addln("\\footnotesize");
		return res;
	}

	public static void main(String[] args) throws IOException {
		Document doc = getDocumentSkeleton();

		BufferedReader in = new BufferedReader(new FileReader("APWH Testing/input.txt"));
		int T = Integer.parseInt(in.readLine());
		while (T-->0) {
			int N = Integer.parseInt(in.readLine());
			Part part = new Part(in.readLine());
			doc.add(part);
			while (N-->0) {
				String splits[] = in.readLine().split("\\s+");
				int S = Integer.parseInt(splits[0]);
				int D = Integer.parseInt(splits[1]);
				Section sec;
				boolean isSpecial = splits.length > 2;
				
				String topic1 = null;
				String topic2 = null;
				
				
				if (isSpecial) {
					sec = new Section(in.readLine());
				} else {
					splits = in.readLine().split(",\\s");
					topic1 = splits[0];
					topic2 = splits[1];
					sec = new Section(topic1 + " versus " + topic2);
				}
				part.add(sec);
				Subsection subsecsim = new Subsection("Similarities");
				Subsection subsecdiff = new Subsection("Differences");
				sec.add(subsecsim);
				sec.add(subsecdiff);
				Itemize sim = new Itemize();
				Itemize diff = new Itemize();
				subsecsim.add(sim);
				subsecdiff.add(diff);

				while (S-->0) {
					splits = in.readLine().split(",\\s"); // should have reason, detail, detail, analysis
					if (isSpecial)
						sim.addItem(makeSim(splits[0], splits[1], splits[2], splits[3], splits[4], splits[5]));
					else
					  sim.addItem(makeSim(topic1, topic2, splits[0], splits[1], splits[2], splits[3]));
				}

				while (D-->0) {
					splits = in.readLine().split(",\\s"); // should have reason, detail, detail, analysis
					if (isSpecial)
						diff.addItem(makeDiff(splits[0], splits[1], splits[2], splits[3], splits[4], splits[5]));
					else
					  diff.addItem(makeDiff(topic1, topic2, splits[0], splits[1], splits[2], splits[3]));
				}
			}
		}

		doc.generateDocument(new File("APWH Testing/keycomps.tex"));
		in.close();
	}

	public static String makeSim(String t1, String t2, String r, String d1, String d2, String a) {
		String line = t1 + " and " + t2 + " were similar in " + r + ".";
		line += " " + t1 + " had " + d1 + ", and similarly " + t2 + " had " + d2 + ".";
		line += " " + "This key similarity between the two can be wholeheartedly explained because " + a + ".";
		return line;
	}

	public static String makeDiff(String t1, String t2, String r, String d1, String d2, String a) {
		String line = t1 + " and " + t2 + " were different in " + r + ".";
		line += " " + t1 + " had " + d1 + ", and instead " + t2 + " had " + d2 + ".";
		line += " " + "This striking juxtaposition can be explained by the awesome fact because " + a + ".";
		return line;
	}
}
