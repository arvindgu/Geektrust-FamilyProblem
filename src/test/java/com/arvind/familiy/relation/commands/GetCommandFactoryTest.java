package com.arvind.familiy.relation.commands;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.arvind.familiy.util.Constants;

public class GetCommandFactoryTest {

	@Test
	public void testGetBrotherInLawCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand(Constants.BROTHER_IN_LAW);
		assertTrue(relationshipCommand instanceof GetBrotherInLawCommand);
	}
	
	@Test
	public void testGetChildrenCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand(Constants.CHILDREN);
		assertTrue(relationshipCommand instanceof GetChildrenCommand);
	}
	
	@Test
	public void testGetDaughterCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand(Constants.DAUGHTER);
		assertTrue(relationshipCommand instanceof GetDaughterCommand);
	}
	
	@Test
	public void testGetFatherCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand(Constants.FATHER);
		assertTrue(relationshipCommand instanceof GetFatherCommand);
	}
	
	@Test
	public void testGetFatherInLawCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand(Constants.FATHER_IN_LAW);
		assertTrue(relationshipCommand instanceof GetFatherInLawCommand);
	}
	
	@Test
	public void testGetMaternalAuntCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand(Constants.MATERNAL_AUNT);
		assertTrue(relationshipCommand instanceof GetMaternalAuntCommand);
	}
	
	@Test
	public void testGetMaternalUncleCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand(Constants.MATERNAL_UNCLE);
		assertTrue(relationshipCommand instanceof GetMaternalUncleCommand);
	}
	
	
	@Test
	public void testGetMotherCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand(Constants.MOTHER);
		assertTrue(relationshipCommand instanceof GetMotherCommand);
	}
	
	
	@Test
	public void testGetMotherInLawCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand(Constants.MOTHER_IN_LAW);
		assertTrue(relationshipCommand instanceof GetMotherInLawCommand);
	}
	
	@Test
	public void testGetPaternalAuntCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand(Constants.PATERNAL_AUNT);
		assertTrue(relationshipCommand instanceof GetPaternalAuntCommand);
	}
	
	@Test
	public void testGetPaternalUncleCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand(Constants.PATERNAL_UNCLE);
		assertTrue(relationshipCommand instanceof GetPaternalUncleCommand);
	}
	
	@Test
	public void testGetSiblingsCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand(Constants.SIBLINGS);
		assertTrue(relationshipCommand instanceof GetSiblingsCommand);
	}
	
	
	@Test
	public void testGetSisterInLawCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand(Constants.SISTER_IN_LAW);
		assertTrue(relationshipCommand instanceof GetSisterInLawCommand);
	}
	
	
	@Test
	public void testGetSonCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand(Constants.SON);
		assertTrue(relationshipCommand instanceof GetSonCommand);
	}
	
	
	@Test
	public void testGetSpouseCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand(Constants.SPOUSE);
		assertTrue(relationshipCommand instanceof GetSpouseCommand);
	}
	
	
	@Test
	public void testNotSupportedGetCommand() {
		ICommand relationshipCommand = CommandFactory.getCommand("GET_BROTHER");
		assertTrue(relationshipCommand == null);
	}
	
	@Test
	public void testAddChildCommand() {
		ICommand addMemberCommand = CommandFactory.getCommand(Constants.ADD_CHILD);
		assertTrue(addMemberCommand instanceof AddChildCommand);
	}
	
	@Test
	public void testAddSpouseCommand() {
		ICommand addMemberCommand = CommandFactory.getCommand(Constants.ADD_SPOUSE);
		assertTrue(addMemberCommand instanceof AddSpouseCommand);
	}
	
	@Test
	public void testNotSupportedAddCommand() {
		ICommand addMemberCommand = CommandFactory.getCommand("ADD_BROTHER");
		assertTrue(addMemberCommand == null);
	}

}
