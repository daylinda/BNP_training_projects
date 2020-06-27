package com.app.comparator;

import java.io.File;
import java.util.Comparator;

public class FileNameComparator implements Comparator<File> {

	@Override
	public int compare(File f1, File f2) {
		// TODO Auto-generated method stub
		return f1.getName().compareTo(f2.getName());
	}

}
