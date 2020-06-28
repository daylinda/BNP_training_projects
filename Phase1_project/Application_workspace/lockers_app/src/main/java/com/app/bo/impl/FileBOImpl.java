package com.app.bo.impl;


import java.io.File;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.app.bo.FileBO;
import com.app.config.PathConfig;


public class FileBOImpl implements FileBO {

	@Override
	public void createFileName(String fileName) {
		
		File file = new File(PathConfig.ROOT_PATH,fileName);
		
		
		if(!file.exists()) {
			
			try {
				
				file.createNewFile();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}						
			
		}else {
			System.out.println("File with the entered name exits,try again");
		}
			
		
	}

	@Override
	public void deleteFileName(String fileName) {
		
		File file = new File(PathConfig.ROOT_PATH,fileName);
		if(file.exists()) {
			
			file.delete();
			System.out.println(fileName + " deleted");
			
		}else {
			System.out.println("Invalid file name");
		}
		
		
	}

	@Override
	public void searchFileName(String fileName) {
		
		File file = new File(PathConfig.ROOT_PATH,fileName);
		if(file.exists()) {
			
			System.out.println( file.getName() + " is found at path "+file.getPath());
			
		}else {
			
			System.out.println("File not found");
			
		}
		
		
	}

	@Override
	public void createFileSrcPath(String srcPath)  {
		
		Path from = Paths.get(srcPath);
		
		File oldFile = new File(srcPath);
		String name = oldFile.getName();
		
		File newFile = new File(PathConfig.ROOT_PATH,name);
		
		Path to = Paths.get(newFile.getPath());
		
		try {
			Files.copy(from, to,StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid path name");
		}
		
		
		
	}

}
