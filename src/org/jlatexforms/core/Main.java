package org.jlatexforms.core;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Main {
	
	public static void scanFile(File texFile) {
		
	}
	
	public static List<File> searchDirectory(File directory) {
		List<File> fileList = new LinkedList<>();
//		File[] files = directory.listFiles();
//		if (files != null) {
//			for (File f : files) {
//				if (f.getName().endsWith(".tex")) {
//					fileList.add(f);
//				}
//			}
//		}
		return fileList;
	}
	
	public static void main(String[] args) {
//		new Main();
//		List<File> fileList = searchDirectory(new File("\\"));
//		for (File f : fileList) {
//			System.out.println(f);
//		}
	}

}
