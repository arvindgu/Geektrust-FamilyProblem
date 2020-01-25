package com.arvind.familiy.junit.tests;

import static org.junit.Assert.assertSame;

import org.junit.BeforeClass;
import org.junit.Test;

import com.arvind.familiy.relation.commands.CommandFactory;
import com.arvind.familiy.relation.commands.ICommand;
import com.arvind.familiy.relation.commands.process.FamilyTreeCommandExecuter;
import com.arvind.familiy.relation.commands.process.FamilyTreeCommandProcessor;
import com.arvind.familiy.relation.commands.process.IFamilyTreeCommandProcessor;
import com.arvind.familiy.util.Constants;
import com.arvind.familiy.util.FillData;

/**
 * @author Arvind Gupta
 */
public class GetCousinCommandTest {

	@BeforeClass
	public static void setUp() {
		IFamilyTreeCommandProcessor commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		new FillData(commandProcessor).fillDdata();
	}

	@Test
	public void getCousinByEmptyName(){
		ICommand relationshipCommand = CommandFactory.getCommand("COUSIN");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "", "COUSIN"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assertSame(Constants.PERSON_NOT_FOUND, output);
	}
	
	@Test
	public void getCousinOfNonExistingMember(){
		ICommand relationshipCommand = CommandFactory.getCommand("COUSIN");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "NonExistingName", "COUSIN"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assertSame(Constants.PERSON_NOT_FOUND, output);
	}
	
	
	@Test
	public void getMaternalSideCousins(){
		ICommand relationshipCommand = CommandFactory.getCommand("COUSIN");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "Atya", "COUSIN"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assert(output.equals("Dritha Tritha Vritha Vila Chika Jnki Ahit"));
	}

	
	@Test
	public void getPaternalSideCousins(){
		ICommand relationshipCommand = CommandFactory.getCommand("COUSIN");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "Tritha", "COUSIN"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assert(output.equals("Vila Chika Jnki Ahit Asva Vyas Atya"));
	}

	
}
