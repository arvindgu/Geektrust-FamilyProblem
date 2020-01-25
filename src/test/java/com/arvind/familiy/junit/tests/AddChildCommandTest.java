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
public class AddChildCommandTest {
	
	@BeforeClass
	public static void setUp() {
		IFamilyTreeCommandProcessor commandProcessor = new FamilyTreeCommandProcessor(new FamilyTreeCommandExecuter());
		new FillData(commandProcessor).fillDdata();
	}
	
	
	@Test
	public void testAddingChildWithEmptyDetails(){
		//ICommand addCommand = CommandFactory.getCommand("ADD_CHILD");
		ICommand addCommand = CommandFactory.getCommand("ADD_CHILD");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] childDetails = {"ADD_CHILD", "", "", ""};
		addCommand.setCommandInputArray(childDetails);
		String output= commandExecuter.execute(addCommand);
		assertSame(Constants.CHILD_ADDITION_FAILED, output);
	}
	
	
	//Test Adding a child with empty mother name
	@Test
	public void  testAddingChildWithEmptyMotherName(){
		ICommand addCommand = CommandFactory.getCommand("ADD_CHILD");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] childDetails = {"ADD_CHILD", "", "Chit", "Male"};
		addCommand.setCommandInputArray(childDetails);
		String output= commandExecuter.execute(addCommand);
		assertSame(Constants.CHILD_ADDITION_FAILED, output);
	}
	
	
	@Test
	public void testAddingChildWithEmptyName(){
		ICommand addCommand = CommandFactory.getCommand("ADD_CHILD");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] childDetails = {"ADD_CHILD", "", "", "Male"};
		addCommand.setCommandInputArray(childDetails);
		String output= commandExecuter.execute(addCommand);
		assertSame(Constants.CHILD_ADDITION_FAILED, output);
	}
	
	
	@Test
	public void testAddingChildWithEmptyGender(){
		ICommand addCommand = CommandFactory.getCommand("ADD_CHILD");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] childDetails = {"ADD_CHILD", "Anga", "Chit", ""};
		addCommand.setCommandInputArray(childDetails);
		String output= commandExecuter.execute(addCommand);
		assertSame(Constants.CHILD_ADDITION_FAILED, output);
	}
	
	
	@Test
	public void testAddingChildByFatherName(){
		ICommand addCommand = CommandFactory.getCommand("ADD_CHILD");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] childDetails = {"ADD_CHILD", "Shan", "ShanJunior", "Male"};
		addCommand.setCommandInputArray(childDetails);
		String output= commandExecuter.execute(addCommand);
		assertSame(Constants.CHILD_ADDITION_FAILED, output);
	}
	
	
	@Test
	public void testAddingChildWithSameMotherName(){
		ICommand addCommand = CommandFactory.getCommand("ADD_CHILD");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] childDetails = {"ADD_CHILD", "Anga", "Anga", "Male"};
		addCommand.setCommandInputArray(childDetails);
		String output= commandExecuter.execute(addCommand);
		assertSame(Constants.CHILD_ADDITION_FAILED, output);
	}
	
	
	@Test
	public void testAddingChildWhenMotherNotPresentInFamilyTree(){
		ICommand addCommand = CommandFactory.getCommand("ADD_CHILD");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] childDetails = {"ADD_CHILD", "MotherNotPresent", "Anga", "Male"};
		addCommand.setCommandInputArray(childDetails);
		String output= commandExecuter.execute(addCommand);
		assertSame(Constants.PERSON_NOT_FOUND, output);
	}
	
		
	@Test
	public void testAddingChildThatIsAlreadyPresentWithSameName(){
		ICommand addCommand = CommandFactory.getCommand("ADD_CHILD");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] childDetails = {"ADD_CHILD", "Anga", "Chit", "Male"};
		addCommand.setCommandInputArray(childDetails);
		String output= commandExecuter.execute(addCommand);
		assertSame(Constants.CHILD_ADDITION_FAILED, output);
	}
			
	@Test
	public void testAddingChildWithAllInfo(){
		ICommand addCommand = CommandFactory.getCommand("ADD_CHILD");
		FamilyTreeCommandExecuter commandExecuter = new FamilyTreeCommandExecuter();
		String[] childDetails = {"ADD_CHILD", "Tritha", "Peter", "Male"};
		addCommand.setCommandInputArray(childDetails);
		String output= commandExecuter.execute(addCommand);
		assertSame(Constants.CHILD_ADDITION_SUCCEEDED, output);
		
		ICommand relationshipCommand2 = CommandFactory.getCommand("CHILDREN");
		FamilyTreeCommandExecuter commandExecuter2 = new FamilyTreeCommandExecuter();
		String[] commandArray2 = {"GET_RELATIONSHIP", "Tritha", "CHILDREN"};
		relationshipCommand2.setCommandInputArray(commandArray2);
		String output2= commandExecuter2.execute(relationshipCommand2);
		assert(output2.equals("Peter"));
	}
	
}
