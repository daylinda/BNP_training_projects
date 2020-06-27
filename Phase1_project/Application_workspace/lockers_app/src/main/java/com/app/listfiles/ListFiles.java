package com.app.listfiles;

import java.io.File;
import java.util.Arrays;

import com.app.comparator.FileNameComparator;

public class ListFiles extends FileNameComparator {
	
	public void printListFiles(String path) {
		
		File folder = new File(path);
		
		File [] files = folder.listFiles();
		
		Arrays.sort(files);
		
		for (File file : files)
        {
            if (file.isFile())
            {
                System.out.println(file.getName());
            }
            else if (file.isDirectory())
            {
                printListFiles(file.getAbsolutePath());
            }
        }
		
		
	}

}
