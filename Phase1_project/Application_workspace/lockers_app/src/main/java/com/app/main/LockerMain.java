package com.app.main;


import java.util.Scanner;

import com.app.bo.impl.FileBOImpl;
import com.app.config.PathConfig;
import com.app.exception.BusinessException;
import com.app.listfiles.ListFiles;

public class LockerMain {
	
	public static void main(String[] args) {
		
		int ch = 0;
		int choice = 0;
		
		String fname = "";
		String srcPath ="";
		Scanner scanner = new Scanner(System.in);
		FileBOImpl fileImpl = new FileBOImpl();
		
		do {
			
			System.out.println("\nWelcome to Company Lockers Pvt Ltd.");
			System.out.println("Developed by Davina Pinto,BNP trainee");
			System.out.println("----------------");
			System.out.println("Main Menu");
			System.out.println("----------------");
			System.out.println("1)Display List of Files in Directory ");
			System.out.println("2)Options to manipulate files");
			System.out.println("3)EXIT ");
			System.out.println("----------------");
			System.out.println("Enter your choice:");
			
			try {
				
				ch = Integer.parseInt(scanner.nextLine());
				
			}catch(Exception e) {
				
				System.out.println("No input found");
			}
			
			
			
			switch (ch) {
			case 1:
				ListFiles lf = new ListFiles();
				System.out.println();
				lf.printListFiles(PathConfig.ROOT_PATH);
				System.out.println();
				break;
				
			case 2:
				do {
					
					System.out.println("\nPlease enter one the following options");
					System.out.println("----------------");
					System.out.println("1)Add file to List ");
					System.out.println("2)Delete file from List ");
					System.out.println("3)Search file in List ");
					System.out.println("4)Return to Main Menu");
					System.out.println("----------------");
					System.out.println("Enter your choice:");
					choice = Integer.parseInt(scanner.nextLine());
					
					switch (choice) {
					
					case 1:
						System.out.println("\nAdd file to directory:");
						System.out.println("1) Create new file");
						System.out.println("2) Add file from machine");
						System.out.println("Enter your choice:");
						try {
							
							int io = Integer.parseInt(scanner.nextLine());
							if(io == 1) {
								System.out.println("Enter name of file to be created ");
								fname = scanner.nextLine();
								if(fname!= null) {
									fileImpl.createFileName(fname);
								}else {
									throw new BusinessException("Invalid! Name to be entered");
								}
								
							}else if(io == 2) {
								System.out.println("Enter path of file ");
								srcPath = scanner.nextLine();
								if(srcPath!= null) {
									fileImpl.createFileSrcPath(srcPath);
								}else {
									throw new BusinessException("Invalid! File name should to be entered");
								}
								
							}
							
						}catch(Exception e) {
							System.out.println("No input found");
						}
						
						
												
						break;
						
					case 2:
						
						System.out.println("Delete file from directory:");
						fname = scanner.nextLine();
						if(fname!= null) {
							fileImpl.deleteFileName(fname);
						}else {
							throw new BusinessException("Invalid! File name should to be entered");
						}
						
											
						break;
						
					case 3:
						System.out.println("Search file in directory:");
						fname = scanner.nextLine();
						if(fname!= null) {
							fileImpl.searchFileName(fname);
						}else {
							throw new BusinessException("Invalid! File name should to be entered");
						}
						
						
						break;
						
					case 4:
						System.out.println("Returning to main menu");
						break;
													

					default:
						System.out.println("Invalid option, Please try again");
						break;
					}
					
					
					
				}while(choice!=4);
				
				
				break;
				
			case 3:
				System.out.println("Tankyou for using our application.");
				break;

			default:
				System.out.println("Invalid option, Please try again");
				break;
			}
			
		}while(ch!=3);
		
		
		scanner.close();

		
		
	    
	    
		
	} 
	
	
	
			

}
