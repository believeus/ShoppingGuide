package com.etech.webutil;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		/*System.out.println("---"); 
		File file = new File("/home/ztx/program/"+"aaaaa"+"/a.txt");
		File parent = file.getParentFile();
		if (parent != null && !parent.exists()) {
			parent.mkdir();
		}
		file.createNewFile();*/
		
		String[] strs = {"1","2","3","4","5","6"};
		String str = "";
		for (int i = 0; i < strs.length; i++) {
			if (i == strs.length -1) {
				str += strs[i];
			}else {
				str += strs[i] +",";
			}
			
		}
		System.out.println(str);
	}
}
