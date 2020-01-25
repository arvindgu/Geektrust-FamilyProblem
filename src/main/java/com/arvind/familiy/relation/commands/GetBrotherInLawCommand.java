package com.arvind.familiy.relation.commands;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class GetBrotherInLawCommand implements ICommand{
	
	private String[] commandInputArray;
	
	public void setCommandInputArray(String[] commandInputArray) {
		this.commandInputArray = commandInputArray;
	}

	@Override
	public String runCommand() {
		String name = commandInputArray[1];
		FamilyMember familyMember = FamilyCache.INSTANCE.getMemberFromCache(name);
		StringBuilder sb = new StringBuilder();
		String result = Constants.PERSON_NOT_FOUND;
		
		if(familyMember != null ) 
		{
			//######################
			//Get Spouse’s brothers
			//######################
			// From the Spouse Mother
			// Get the Spouse Siblings
			// Filter the brothers and print
			//========================================================
			//Get the Spouse
			FamilyMember spouse = familyMember.getSpouse();
			if( spouse!= null && spouse.getMother() != null && !spouse.getMother().getChilds().isEmpty()) {		
				spouse.getMother().getChilds().stream()
				.filter(fm -> fm.getGender().equals(Constants.MALE) && !fm.getName().equalsIgnoreCase(spouse.getName()))
				.forEach(brotherInLaw -> sb.append(brotherInLaw.getName() + " "));
			}
				
			//############################
			////Get Husbands of siblings
			//############################
			// Get the person's Siblings, Remove the person from the Sibling list
			// Filter and get only Female siblings
			// Print their Spouse (Husband) name
			//========================================================
			
			if(familyMember.getMother() != null && familyMember.getMother().getChilds().isEmpty()) {
				familyMember.getMother().getChilds().stream()
				.filter( fm -> fm.getGender().equals(Constants.FEMALE) && fm.getSpouse() !=null 
					&& !fm.getName().equalsIgnoreCase(familyMember.getName()))
				.forEach(husbandOfSibling -> sb.append(husbandOfSibling.getSpouse().getName() + " "));
			}
			String people = sb.toString().trim();
			result = people.isEmpty() ? Constants.NONE : people;
			
		}
		return result;
	}
}
