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
public class GetFatherCommandTest {

	@BeforeClass
	public static void setUp() {
		IFamilyTreeCommandProcessor commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		new FillData(commandProcessor).fillDdata();
	}

	@Test
	public void getFatherOfEmptyPersonName(){
		ICommand relationshipCommand = CommandFactory.getCommand("FATHER");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "", "FATHER"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assertSame(Constants.NONE, output);
	}
	
	@Test
	public void getFatherOfNonExistingMember(){
		ICommand relationshipCommand = CommandFactory.getCommand("FATHER");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "NonExistingName", "FATHER"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assertSame(Constants.NONE, output);
	}
	
	@Test
	public void getFatherOfDaughter(){
		ICommand relationshipCommand = CommandFactory.getCommand("FATHER");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "Jnki", "FATHER"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assert(output.equals("Aras"));
	}
	
	
	@Test
	public void getFatherOfSon(){
		ICommand relationshipCommand = CommandFactory.getCommand("FATHER");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "Laki", "FATHER"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assert(output.equals("Arit"));
	}
	
	
	@Test
	public void getFatherOfFamilyRootFemale(){
		ICommand relationshipCommand = CommandFactory.getCommand("FATHER");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "Anga", "FATHER"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assertSame(Constants.NONE, output);
	}
	
	@Test
	public void getFatherOfFamilyRootMale(){
		ICommand relationshipCommand = CommandFactory.getCommand("FATHER");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "Shan", "FATHER"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assertSame(Constants.NONE, output);
	}

}
