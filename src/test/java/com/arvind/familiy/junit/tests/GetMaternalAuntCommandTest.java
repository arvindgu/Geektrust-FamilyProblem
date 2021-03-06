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
public class GetMaternalAuntCommandTest {

	@BeforeClass
	public static void setUp() {
		IFamilyTreeCommandProcessor commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		new FillData(commandProcessor).fillDdata();
	}

	@Test
	public void getMaternalAuntByEmptyName(){
		ICommand relationshipCommand = CommandFactory.getCommand("MATERNAL-AUNT");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "", "MATERNAL-AUNT"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assertSame(Constants.PERSON_NOT_FOUND, output);
	}
	
	@Test
	public void getMaternalAuntOfNonExistingMember(){
		ICommand relationshipCommand = CommandFactory.getCommand("MATERNAL-AUNT");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "NonExistingName", "MATERNAL-AUNT"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assertSame(Constants.PERSON_NOT_FOUND, output);
	}
	
	
	
	@Test
	public void getMaternalAuntByCorrectName(){
		ICommand relationshipCommand = CommandFactory.getCommand("MATERNAL-AUNT");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "Yodhan", "MATERNAL-AUNT"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assert(output.equals("Tritha"));
	}

	
	@Test
	public void getMaternalAuntOfAPersonWhoseMaternalUncleNotPresent(){
		ICommand relationshipCommand = CommandFactory.getCommand("MATERNAL-AUNT");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "Lavnya", "MATERNAL-AUNT"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assertSame(Constants.NONE, output);
	}

}
