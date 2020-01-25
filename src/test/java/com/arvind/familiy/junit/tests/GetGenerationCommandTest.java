package com.arvind.familiy.junit.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.arvind.familiy.relation.commands.CommandFactory;
import com.arvind.familiy.relation.commands.ICommand;
import com.arvind.familiy.relation.commands.process.FamilyTreeCommandExecuter;
import com.arvind.familiy.relation.commands.process.FamilyTreeCommandProcessor;
import com.arvind.familiy.relation.commands.process.IFamilyTreeCommandProcessor;
import com.arvind.familiy.util.Constants;
import com.arvind.familiy.util.FillData;

public class GetGenerationCommandTest {

	@BeforeClass
	public static void setUp() {
		IFamilyTreeCommandProcessor commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		new FillData(commandProcessor).fillDdata();
	}

	@Test
	public void testWithEmptyFamilyMember() {
		ICommand generationCommand = CommandFactory.getCommand("GENERATION");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] childDetails = {"GET_RELATIONSHIP", "", "", "GENERATION"};
		generationCommand.setCommandInputArray(childDetails);
		String output= commandExecuter.execute(generationCommand);
		assertEquals(Constants.PERSON_NOT_FOUND, output);
	}
	
	@Test
	public void testWithEmptyFamilyMember1() {
		ICommand generationCommand = CommandFactory.getCommand("GENERATION");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] childDetails = {"GET_RELATIONSHIP", "Yodhan", "", "GENERATION"};
		generationCommand.setCommandInputArray(childDetails);
		String output= commandExecuter.execute(generationCommand);
		assertEquals(Constants.PERSON_NOT_FOUND, output);
	}
	
	@Test
	public void testWithEmptyFamilyMember2() {
		ICommand generationCommand = CommandFactory.getCommand("GENERATION");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] childDetails = {"GET_RELATIONSHIP", "", "Shawn", "GENERATION"};
		generationCommand.setCommandInputArray(childDetails);
		String output= commandExecuter.execute(generationCommand);
		assertEquals(Constants.PERSON_NOT_FOUND, output);
	}
	
	@Test
	public void testWithTwoCorrectFamilyMemberRelation() {
		ICommand generationCommand = CommandFactory.getCommand("GENERATION");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] childDetails = {"GET_RELATIONSHIP", "Yodhan", "Shan", "GENERATION"};
		generationCommand.setCommandInputArray(childDetails);
		String output= commandExecuter.execute(generationCommand);
		assertEquals("4", output);
	}
	
	

}
