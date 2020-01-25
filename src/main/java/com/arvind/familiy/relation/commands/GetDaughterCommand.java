package com.arvind.familiy.relation.commands;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class GetDaughterCommand implements ICommand{
	
	private String[] commandInputArray;
	
	public void setCommandInputArray(String[] commandInputArray){
		this.commandInputArray = commandInputArray;
	}
	
	@Override
	public String runCommand() {
		String name = commandInputArray[1];
		
		String result = Constants.PERSON_NOT_FOUND;
		StringBuilder sb = new StringBuilder();
		
		FamilyMember spouse = FamilyCache.INSTANCE.getMemberFromCache(name);
		
		if(spouse != null ) 
		{
			if(spouse.getGender().equals(Constants.MALE) ) {
				spouse = spouse.getSpouse();
			}
			
			if(spouse != null && !spouse.getChilds().isEmpty()) {
				spouse.getChilds().stream().filter(fm -> fm.getGender().equalsIgnoreCase(Constants.FEMALE))
				.forEach(daughter -> sb.append(daughter.getName() + " "));
				//result = sb.toString().trim();
			}
			String people = sb.toString().trim();
			result = people.isEmpty() ? Constants.NONE : people;
		}
		return result;
	}
}
