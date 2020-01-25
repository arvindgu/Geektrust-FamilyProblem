package com.arvind.familiy.relation.commands.process;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class FamilyTreeCommandProcessorTest {


	@Test
	public void testInvalidCommand() {
		FamilyTreeCommandProcessor  commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		String []command = {"DO_NOT_ADD_CHILD"};
		assertFalse(commandProcessor.isValidCommand(command));
	}
	
	@Test
	public void testInvalidOptionsforGetRelationshipCommand() {
		FamilyTreeCommandProcessor  commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		String []command = {"GET_RELATIONSHIP Atya Sister-In-Law ABC"};
		assertFalse(commandProcessor.isValidCommand(command));
	}
	
	@Test
	public void testInvalidOptionsforAddSpouseCommand() {
		FamilyTreeCommandProcessor  commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		String []command = {"ADD_SPOUSE Atya  Vane ABC"};
		assertFalse(commandProcessor.isValidCommand(command));
	}
	
	@Test
	public void testInvalidOptionsforAddChildCommand() {
		FamilyTreeCommandProcessor  commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		String []command = {"ADD_CHILD Atya"};
		assertFalse(commandProcessor.isValidCommand(command));
	}
	
	@Test
	public void testInvalidOptionsforAddChildCommand2() {
		FamilyTreeCommandProcessor  commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		String []command = {"ADD_CHILD Atya Vane"};
		assertFalse(commandProcessor.isValidCommand(command));
	}
	
	@Test
	public void testInvalidOptionsforAddChildCommand3() {
		FamilyTreeCommandProcessor  commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		String []command = {"ADD_CHILD Atya Vane Male XYZ "};
		assertFalse(commandProcessor.isValidCommand(command));
	}
	
	@Test
	public void testIProcessCommand1() {
		FamilyTreeCommandProcessor  commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		String command = "GET_CHILD Atya Vane Male XYZ ";
		assertFalse(!commandProcessor.processCommand(command).equals(Constants.INVALID_COMMAND));
	}
}
