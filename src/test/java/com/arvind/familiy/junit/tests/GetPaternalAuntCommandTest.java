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
public class GetPaternalAuntCommandTest {

	@BeforeClass
	public static void setUp() {
		IFamilyTreeCommandProcessor commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		new FillData(commandProcessor).fillDdata();
	}

	@Test
	public void getPaternalAuntByEmptyName(){
		ICommand relationshipCommand = CommandFactory.getCommand("PATERNAL-AUNT");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "", "PATERNAL-AUNT"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assertSame(Constants.PERSON_NOT_FOUND, output);
	}
	
	@Test
	public void getPaternalAuntOfNonExistingMember(){
		ICommand relationshipCommand = CommandFactory.getCommand("PATERNAL-AUNT");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "NonExistingName", "PATERNAL-AUNT"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assertSame(Constants.PERSON_NOT_FOUND, output);
	}
	
	
	
	@Test
	public void getPaternalAuntByCorrectName(){
		ICommand relationshipCommand = CommandFactory.getCommand("PATERNAL-AUNT");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "Krithi", "PATERNAL-AUNT"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assert(output.equals("Atya"));
	}

	
	@Test
	public void getPaternalAuntOfAPersonWhosePaternalUncleNotPresent(){
		ICommand relationshipCommand = CommandFactory.getCommand("PATERNAL-AUNT");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "Yodhan", "PATERNAL-AUNT"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assertSame(Constants.NONE, output);
	}

}
