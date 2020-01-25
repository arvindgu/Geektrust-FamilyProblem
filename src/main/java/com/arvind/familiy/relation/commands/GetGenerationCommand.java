package com.arvind.familiy.relation.commands;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

public class GetGenerationCommand implements ICommand {
	String [] commandInputArray ;
	
	public void setCommandInputArray(String[] commandInputArray){
		this.commandInputArray = commandInputArray;
	}
	
	//GET_RELATIONSHIP Yodhan Shawn Generation
	@Override
	public String runCommand() {
		String firstName = commandInputArray[1];
		String secondName = commandInputArray[2];
		
		String result = Constants.PERSON_NOT_FOUND;
		
		FamilyMember familyMember1 = FamilyCache.INSTANCE.getMemberFromCache(firstName);
		
		FamilyMember familyMember2 = FamilyCache.INSTANCE.getMemberFromCache(secondName);
		
		if(familyMember1 == null || familyMember2 == null) {
			return result;
		}
		
		int generationNumber=1;
		
		FamilyMember parent = familyMember1.getFather();
		boolean found= false;
		
		while(parent != null) {
			if(parent.getName().equals(secondName)) {
				found = true;
				break;
			}
			++generationNumber;
			parent = parent.getFather() == null? parent.getSpouse() : parent.getFather();
		}
		
		if(found)
			return generationNumber+"";
		else
			return "0";
		
	}

}
