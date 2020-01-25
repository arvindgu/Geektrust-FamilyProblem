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
public class GetBrotherInLawCommandTest {

	@BeforeClass
	public static void setUp() {
		IFamilyTreeCommandProcessor commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		new FillData(commandProcessor).fillDdata();
	}

	@Test
	public void getBrotherInLaweWithEmptyName(){
		ICommand relationshipCommand = CommandFactory.getCommand("BROTHER-IN-LAW");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "", "BROTHER-IN-LAW"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assertSame(Constants.PERSON_NOT_FOUND, output);
	}
	
	@Test
	public void getBrotherInLawWithNonExistingName(){
		ICommand relationshipCommand = CommandFactory.getCommand("BROTHER-IN-LAW");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "NonExistingName", "BROTHER-IN-LAW"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assertSame(Constants.PERSON_NOT_FOUND, output);
	}
	
	@Test
	public void getBrotherInLawSpouseBrothers(){
		ICommand relationshipCommand = CommandFactory.getCommand("BROTHER-IN-LAW");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "Vyan", "BROTHER-IN-LAW"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assert(output.equals("Chit Ish Vich Aras"));
	}
	
	
	@Test
	public void getBrotherInLawHusbandOfSiblings(){
		ICommand relationshipCommand = CommandFactory.getCommand("BROTHER-IN-LAW");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] commandArray = {"GET_RELATIONSHIP", "Satvy", "BROTHER-IN-LAW"};
		relationshipCommand.setCommandInputArray(commandArray);
		String output= commandExecuter.execute(relationshipCommand);
		assert(output.equals("Vyas"));
	}
	
	

}
