package com.arvind.familiy.relation.commands;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class GetPaternalUncleCommand implements ICommand{
	
	private String[] commandInputArray;
	
	public void setCommandInputArray(String[] commandInputArray){
		this.commandInputArray = commandInputArray;
	}
	
	@Override
	public String runCommand() {
		String name = commandInputArray[1];
		FamilyMember familyMember = FamilyCache.INSTANCE.getMemberFromCache(name);
		String result = Constants.PERSON_NOT_FOUND;
		StringBuilder sb= new StringBuilder();
		
		if(familyMember != null) {
			if(familyMember.getFather() != null
				&& familyMember.getFather().getMother()!= null 
				&& familyMember.getFather().getMother().getChilds().size() >0) {
				familyMember.getFather().getMother().getChilds().stream()
					.filter(child-> child.getGender().equalsIgnoreCase(Constants.MALE) && !child.getName().equalsIgnoreCase(familyMember.getFather().getName()))
					.forEach( paternalUncle -> sb.append(paternalUncle.getName() + " "));
			}
			String people = sb.toString().trim();
			result = people.isEmpty() ? Constants.NONE : people;
		}
		return result;
	}

}
