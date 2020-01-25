package com.arvind.familiytree.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.arvind.familiy.relation.commands.process.FamilyTreeCommandExecuter;
import com.arvind.familiy.relation.commands.process.FamilyTreeCommandProcessor;
import com.arvind.familiy.relation.commands.process.IFamilyTreeCommandProcessor;
import com.arvind.familiy.util.FillData;

/**
 * @author Arvind Gupta
 */
public class FamilyTreeRunner 
{
    public static void main( String[] args )
    {
    	String filePath = null;
    	boolean isFilePathValid = false;
    	
    	if(args != null && args.length == 1) {
    		if(new File(args[0]).exists()) {
    			filePath = args[0];
    			isFilePathValid = true;
    		}
    	}
    	
    	if(!isFilePathValid) {
    		System.out.println("Invalid File Location: Please provide correct file location");
    	}
    	else {
    		try {
    			//Create family tree as shown in problem
    			createDefaultFamilyTree();
    			
    	    	BufferedReader reader = new BufferedReader(new FileReader(filePath));
	    		String line = reader.readLine();
	    		
	    		while(line != null){
	    			if(!line.trim().isEmpty()) {
	    				//if(!line.startsWith("#")) {
	    				IFamilyTreeCommandProcessor  commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
	    				String result  = commandProcessor.processCommand(line);
	    				System.out.println(result);
	    				//}
	    			}
	    			line = reader.readLine();
	    		}
	    		reader.close();
    		}catch(IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    
    /*
     * Creates the family tree with the data as shown the problem's family tree picture
     */
    public static void createDefaultFamilyTree() {
    	IFamilyTreeCommandProcessor commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		new FillData(commandProcessor).fillDdata();
    }
}
