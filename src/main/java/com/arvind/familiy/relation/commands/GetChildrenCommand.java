package com.arvind.familiy.relation.commands;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class GetChildrenCommand implements ICommand{
	
	private String[] commandInputArray;
	
	public void setCommandInputArray(String[] commandInputArray){
		this.commandInputArray = commandInputArray;
	}
	
	@Override
	public String runCommand() {
		String name = commandInputArray[1];
		FamilyMember person = FamilyCache.INSTANCE.getMemberFromCache(name);
		String result = Constants.PERSON_NOT_FOUND;
		StringBuilder sb = new StringBuilder();
		
		if(person != null) {
			
			if(person.getGender().equals(Constants.MALE)) {
				person = person.getSpouse();
			}
			
			if(person != null && !person.getChilds().isEmpty()) {
				person.getChilds().forEach(child -> sb.append(child.getName() + " "));
			}
			String people = sb.toString().trim();
			result = people.isEmpty()? Constants.NONE : people;
		}
		return result;
	}
}
