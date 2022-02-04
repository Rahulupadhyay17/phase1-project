package mypackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyClass {
	public static String errormsg="There is an error. Kindly contact admin";
	public static final String path = "C:\\Users\\Dell\\Desktop\\JAVA classes\\phase 1 - OOPS\\Final Project Phase 1\\Allfiles";
    
	static Scanner obj = new Scanner(System.in);
    
	public static void main(String[] args)
	{
		
		int ch;
		do
		{
		showMenu();
		System.out.println("Enter your option");
		ch=Integer.parseInt(obj.nextLine());
		
		switch(ch)
		{
		case 1:displayAllFiles();
		break;
		case 2:addFile();
		break;
		case 3:deleteFile();
		break;
		case 4:searchFile();
		break;
		case 5:System.exit(0);
		break;
		default:System.out.println("Your entered option is incorrect");
		break;
		}
		
		}
		while(ch>0 & ch<=5);
		obj.close();
			
		
		
	}	
	

	public static void showMenu()
	{
		System.out.println("\t\t########################################");
		System.out.println("\t\t\tLockedMe.com");
		System.out.println("\t\t\tdesigned by Rahul Upadhyay");
		System.out.println("\t\t########################################");
		
		System.out.println("\t\t\t1. Dispaly all Files");
		System.out.println("\t\t\t2. Add File");
		System.out.println("\t\t\t3. Delete File");
		System.out.println("\t\t\t4. Search File");
		System.out.println("\t\t\t5. Exit");
	}
	
	public static void displayAllFiles()
	{
		try
		{
		File f = new File(path);
		File[] list = f.listFiles();
		if(list.length==0) 
		{
			System.out.println("There is no file in the folder");
		}
		else 
		{
		for(var l:list)
		{
			System.out.println(l.getName());
		}
		}
		}
		catch (Exception ex)
		{
			System.out.println(errormsg);
		}
	}
	
	public static void addFile()
	{
		try
		{
		String name;
		int lc;
		System.out.println("Enter the name of the to be added");
		name = obj.nextLine();
		
		
		
		File f = new File(path+"\\"+name);
		
			{
			if(f.exists()) 
			{
				System.out.println("file already exixts in the folder. Create another file");
			}
			else
			{
				FileWriter fw = new FileWriter(path+"\\"+name);
				System.out.println("Enter the number of lines to be inserted");
				lc = Integer.parseInt(obj.nextLine());
				
				for(int i=1;i<=lc;i++) 
				{
					System.out.println("Enter the line");
					fw.write(obj.nextLine()+"\r\n");
				}
				System.out.println("file added to the folder");	
				fw.close();
			}
			}
			
		
		
		}
		catch(Exception ex)
		{
			System.out.println(errormsg);
		}
		
	}	
	
	public static void deleteFile()
	{
	try
	{
		String name;
		System.out.println("Enter the filename to be deleted");
		name=obj.nextLine();
		
		File f = new File(path+"\\"+name);
		if(f.delete())
			System.out.println("file has been deleted : "+name);
		else
			System.out.println("file not founnd");
		
		
				
	}

    catch(Exception ex)
    {
    	System.out.println("errormsg");
    }
	}
	public static void searchFile()
	{
	try
	{
		String name;
		System.out.println("Enter the filename to be searched");
		name=obj.nextLine();
		
		File f = new File(path+"\\"+name);
		if(f.exists())
			System.out.println("File has been found and file name is : "+name);
		else
			System.out.println("File is not there in the folder");
		
		
		
	}
	catch(Exception ex)
	{
		System.out.println(errormsg);	
	}
}
}
