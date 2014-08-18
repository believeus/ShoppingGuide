package com.etech.webutil;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		System.out.println("---"); 
		File file = new File("/home/ztx/program/"+"aaaaa"+"/a.txt");
		File parent = file.getParentFile();
		if (parent != null && !parent.exists()) {
			parent.mkdir();
		}
		file.createNewFile();
	}
}
