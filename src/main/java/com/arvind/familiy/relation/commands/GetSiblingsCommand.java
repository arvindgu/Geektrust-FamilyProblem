package com.arvind.familiy.relation.commands;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class GetSiblingsCommand implements ICommand{

	private String[] commandInputArray;
	
	public void setCommandInputArray(String[] commandInputArray){
		this.commandInputArray = commandInputArray;
	}
	
	@Override
	public String runCommand() {
		String name = commandInputArray[1];
		FamilyMember familyMember = FamilyCache.INSTANCE.getMemberFromCache(name);
		String result = Constants.PERSON_NOT_FOUND;
		StringBuilder sb = new StringBuilder();
		
		if(familyMember != null) {
				
			if(familyMember.getMother() != null && familyMember.getMother().getChilds().size() > 0)
			{
				familyMember.getMother().getChilds().stream()
					.filter(fm -> !fm.getName().equals(name))	
					.forEach( sibling -> sb.append(sibling.getName() + " "));
			}
			String people = sb.toString().trim();
			result = people.isEmpty() ? Constants.NONE : people;
		}
		return result;
	}
}
