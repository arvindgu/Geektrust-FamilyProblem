package com.arvind.familiy.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import com.arvind.familiy.relation.commands.process.FamilyTreeCommandExecuter;
import com.arvind.familiy.relation.commands.process.FamilyTreeCommandProcessor;
import com.arvind.familiy.relation.commands.process.IFamilyTreeCommandProcessor;

/**
 * @author Arvind Gupta
 */
public class FillData {
	
	private IFamilyTreeCommandProcessor commandProcessor;
	
	private static PrintStream previous  = System.out;
	private static ByteArrayOutputStream baos;
	private static PrintStream ps;
	
	
	public FillData(IFamilyTreeCommandProcessor commandProcessor) {
		this.commandProcessor = commandProcessor;
	}
	
	private void disableConsolePrint() {
		baos = new ByteArrayOutputStream();
		ps = new PrintStream(baos);
		System.setOut(ps);
	}
	
	private void enableConsolePrint() {
		try {
			System.setOut(previous);
			if(ps!= null) {
				ps.close();
			}
			if (baos!= null) {
				baos.close();
			}
		}catch(IOException io) {
			io.printStackTrace();
		}
	}
	
	public final void fillDdata() {
		
		boolean disableConsolePrint = true;
		
		if(disableConsolePrint) {
			disableConsolePrint();
		}
		
		commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		
		//Start the family tree with Queen Anga as shown in problem's Family Tree picture
				
		System.out.println(commandProcessor.processCommand("ADD_CHILD Anga Chit Male"));
		System.out.println(commandProcessor.processCommand("ADD_CHILD Anga Ish Male"));
		System.out.println(commandProcessor.processCommand("ADD_CHILD Anga Vich Male"));
		System.out.println(commandProcessor.processCommand("ADD_CHILD Anga Aras Male"));
		System.out.println(commandProcessor.processCommand("ADD_CHILD Anga Satya Female"));
		
		System.out.println(commandProcessor.processCommand("ADD_SPOUSE Anga Shan"));

		System.out.println(commandProcessor.processCommand("ADD_SPOUSE Chit Amba"));
		System.out.println(commandProcessor.processCommand("ADD_SPOUSE Vich Lika"));
		System.out.println(commandProcessor.processCommand("ADD_SPOUSE Aras Chitra"));
		System.out.println(commandProcessor.processCommand("ADD_SPOUSE Satya Vyan"));

		System.out.println(commandProcessor.processCommand("ADD_CHILD Amba Dritha Female"));
		System.out.println(commandProcessor.processCommand("ADD_CHILD Amba Tritha Female"));
		System.out.println(commandProcessor.processCommand("ADD_CHILD Amba Vritha Male"));

		System.out.println(commandProcessor.processCommand("ADD_SPOUSE Dritha Jaya"));
		System.out.println(commandProcessor.processCommand("ADD_CHILD Dritha Yodhan Male"));

		System.out.println(commandProcessor.processCommand("ADD_CHILD Lika Vila Female"));
		System.out.println(commandProcessor.processCommand("ADD_CHILD Lika Chika Female"));
		

		System.out.println(commandProcessor.processCommand("ADD_CHILD Chitra Jnki Female"));
		System.out.println(commandProcessor.processCommand("ADD_CHILD Chitra Ahit Male"));

		System.out.println(commandProcessor.processCommand("ADD_SPOUSE Jnki Arit"));

		System.out.println(commandProcessor.processCommand("ADD_CHILD Jnki Laki Male"));
		System.out.println(commandProcessor.processCommand("ADD_CHILD Jnki Lavnya Female"));

		System.out.println(commandProcessor.processCommand("ADD_CHILD Satya Asva Male"));
		System.out.println(commandProcessor.processCommand("ADD_CHILD Satya Vyas Male"));
		System.out.println(commandProcessor.processCommand("ADD_CHILD Satya Atya Female"));

		System.out.println(commandProcessor.processCommand("ADD_SPOUSE Asva Satvy"));
		System.out.println(commandProcessor.processCommand("ADD_SPOUSE Vyas Krpi"));

		System.out.println(commandProcessor.processCommand("ADD_CHILD Krpi Kriya Male"));
		System.out.println(commandProcessor.processCommand("ADD_CHILD Krpi Krithi Female"));
		
		System.out.println(commandProcessor.processCommand("ADD_CHILD Satvy Vasa Male"));
		
		System.out.println(commandProcessor.processCommand("ADD_SPOUSE Yodhan Yodhani"));
		
		if(disableConsolePrint) {
			enableConsolePrint();
		}
	}
}
