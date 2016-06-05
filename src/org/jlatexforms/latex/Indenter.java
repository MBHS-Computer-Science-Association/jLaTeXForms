package org.jlatexforms.latex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Indenter {
	private static Map<Integer, String> prefixes;
	
	static {
		prefixes = new HashMap<>();
	}
	
	public static String getIndent(int indent) {
		if (prefixes.get(indent) != null) {
			return prefixes.get(indent);
		} else {
			String prefix = "";
			for (int i = 0; i < indent; i++)
				prefix += "    ";
			prefixes.put(indent, prefix);
			return prefix;
		}
	}
}
