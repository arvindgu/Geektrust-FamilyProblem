package com.arvind.familiy.junit.tests;

import static org.junit.Assert.*;

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
public class AddSpouseCommandTest {
	
	@BeforeClass
	public static void setUp() {
		IFamilyTreeCommandProcessor commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		new FillData(commandProcessor).fillDdata();
	}
	
	@Test
	public void testAddingSpouseWithEmptyNames(){
		ICommand addCommand = CommandFactory.getCommand("ADD_SPOUSE");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] spouseDetails = {"ADD_SPOUSE", "", ""};
		addCommand.setCommandInputArray(spouseDetails);
		String output= commandExecuter.execute(addCommand);
		assertSame(Constants.SPOUSE_ADDITION_FAILED, output);
	}
	
	@Test
	public void  testAddingSpouseToWithNullName(){
		ICommand addCommand = CommandFactory.getCommand("ADD_SPOUSE");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] spouseDetails = {"ADD_SPOUSE", null, "Amba"};
		addCommand.setCommandInputArray(spouseDetails);
		String output= commandExecuter.execute(addCommand);
		assertSame(Constants.SPOUSE_ADDITION_FAILED, output);
	}
	
	@Test
	public void  testAddingSpouseToWithEmptyName(){
		ICommand addCommand = CommandFactory.getCommand("ADD_SPOUSE");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] spouseDetails = {"ADD_SPOUSE", "Chit", ""};
		addCommand.setCommandInputArray(spouseDetails);
		String output= commandExecuter.execute(addCommand);
		assertSame(Constants.SPOUSE_ADDITION_FAILED, output);
	}
	
	@Test
	public void testAddingSpouseWithNullName(){
		ICommand addCommand = CommandFactory.getCommand("ADD_SPOUSE");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		
		String[] spouseDetails = {"ADD_SPOUSE", "Chit", null};
		addCommand.setCommandInputArray(spouseDetails);
		String output= commandExecuter.execute(addCommand);
		assertSame(Constants.SPOUSE_ADDITION_FAILED, output);
	}
	
	
	@Test
	public void testAddingSpouseToNonExistingPerson(){
		ICommand addCommand = CommandFactory.getCommand("ADD_SPOUSE");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] spouseDetails = {"ADD_SPOUSE", "PersonNotPresent", "Amba"};
		addCommand.setCommandInputArray(spouseDetails);
		String output= commandExecuter.execute(addCommand);
		assertSame(Constants.PERSON_NOT_FOUND, output);
	}
	
	@Test
	public void testAddingCorrectSpouseInfo(){
		ICommand addCommand = CommandFactory.getCommand("ADD_SPOUSE");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] spouseDetails = {"ADD_SPOUSE", "Vasa", "Vina"};
		addCommand.setCommandInputArray(spouseDetails);
		String output= commandExecuter.execute(addCommand);
		assertSame(Constants.SPOUSE_ADDITION_SUCCEEDED, output);
	}

}
