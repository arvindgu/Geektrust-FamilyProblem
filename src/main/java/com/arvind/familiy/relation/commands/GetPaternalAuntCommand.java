package com.arvind.familiy.relation.commands;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class GetPaternalAuntCommand implements ICommand{
	
	private String[] commandInputArray;
	
	public void setCommandInputArray(String[] commandInputArray){
		this.commandInputArray = commandInputArray;
	}
	
	@Override
	public String runCommand() {
		String name = commandInputArray[1];
		String result = Constants.PERSON_NOT_FOUND;
		StringBuffer sb = new StringBuffer();
		
		FamilyMember familyMember = FamilyCache.INSTANCE.getMemberFromCache(name);
		if(familyMember == null) {
			return result;
		}
		else 
		{
			if (familyMember.getFather() != null 
					&& familyMember.getFather().getMother() != null
					&& familyMember.getFather().getMother().getChilds().size() >0) 
			{
				FamilyMember granfMother = familyMember.getFather().getMother();
				
				granfMother.getChilds().stream()
				.filter(member-> member.getGender().equals(Constants.FEMALE))
				.forEach( paternalAunt -> sb.append(paternalAunt.getName() + " "));
			}
			String people = sb.toString().trim();
			result = people.isEmpty() ? Constants.NONE : people;
		}
		return result;
	}
}
