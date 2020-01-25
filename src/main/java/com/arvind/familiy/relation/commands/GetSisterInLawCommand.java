package com.arvind.familiy.relation.commands;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class GetSisterInLawCommand implements ICommand{

	private String[] commandInputArray;
	
	public void setCommandInputArray(String[] commandInputArray){
		this.commandInputArray = commandInputArray;
	}
	
	@Override
	public String runCommand() {
		String name = commandInputArray[1];
		String result = Constants.PERSON_NOT_FOUND;
		StringBuilder sb = new StringBuilder();
		
		FamilyMember familyMember = FamilyCache.INSTANCE.getMemberFromCache(name);
		
		if(familyMember != null) 
		{
			//######################
			//Get Spouse’s Sisters
			//######################
			// From the Spouse Mother's children List
			// Get the female childs
			// Remove the spouse from  the list
			//========================================================
			FamilyMember spouse = familyMember.getSpouse();
			if( spouse!= null && spouse.getMother() != null 
					&& !spouse.getMother().getChilds().isEmpty()) {
				spouse.getMother().getChilds().stream()
					.filter(fm ->fm.getGender().equals(Constants.FEMALE) && !fm.getName().equalsIgnoreCase(spouse.getName()))
					.forEach(spouseSister -> sb.append(spouseSister.getName() + " "));
			}
			
			//############################
			////Get Wives of siblings
			//############################
			// Get the Male Siblings, Remove the person from the list
			// Print the spouse of each sibling from the list
			//========================================================
			if (familyMember.getMother() != null && !familyMember.getMother().getChilds().isEmpty()) {
				familyMember.getMother().getChilds().stream()
				.filter(child -> child.getGender().equals(Constants.MALE) && child.getSpouse() != null
							&& !child.getName().equalsIgnoreCase(familyMember.getName()))
					.forEach(sibling -> sb.append(sibling.getSpouse().getName() + " "));
			}
			String people = sb.toString().trim();
			result = people.isEmpty() ? Constants.NONE : people;
			
		}
		return result;
	}
}