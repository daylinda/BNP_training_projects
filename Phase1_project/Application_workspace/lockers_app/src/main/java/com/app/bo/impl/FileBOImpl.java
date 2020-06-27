package com.app.bo.impl;

//import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
//import java.io.InputStreamReader;

import com.app.bo.FileBO;

public class FileBOImpl implements FileBO {

	@Override
	public void createFileName(String fileName) {
		
		File file = new File("C:\\Users\\davin\\OneDrive\\Desktop\\BNP_Training_Projects\\Phase1_project\\app_textfiles",fileName);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
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
		
		File file = new File("C:\\Users\\davin\\OneDrive\\Desktop\\BNP_Training_Projects\\Phase1_project\\app_textfiles",fileName);
		if(file.exists()) {
			
			file.delete();
			System.out.println(fileName + " deleted");
			
		}else {
			System.out.println("Invalid file name");
		}
		
		
	}

	@Override
	public void searchFileName(String fileName) {
		
		File file = new File("C:\\Users\\davin\\OneDrive\\Desktop\\BNP_Training_Projects\\Phase1_project\\app_textfiles",fileName);
		if(file.exists()) {
			
			System.out.println( file.getName() + " is found at path "+file.getPath());
			
		}else {
			
			System.out.println("File not found");
			
		}
		
		
	}

}
