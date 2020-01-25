package com.arvind.familiy.relation.commands;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class AddSpouseCommand implements ICommand{
	
	private String[] commandInputArray;
	
	public void setCommandInputArray(String[] commandInputArray){
		this.commandInputArray = commandInputArray;
	}
	
	@Override
	public String runCommand() {
		String personName = commandInputArray[1];
		String spouseName = commandInputArray[2];
		
		final FamilyMember spouse;
		String result = Constants.SPOUSE_ADDITION_FAILED;
		
		if(personName!=null && !personName.trim().isEmpty() 
			&& 	spouseName!= null && !spouseName.trim().isEmpty() 
			&& !personName.equals(spouseName)
			) 
		{
			FamilyMember person = FamilyCache.INSTANCE.getMemberFromCache(personName);
			
			if(person == null) {
				result = Constants.PERSON_NOT_FOUND;
			}
			else if (person.getSpouse() == null ) 
			{
				if (person.getGender().equalsIgnoreCase(Constants.FEMALE)) {
					spouse = new FamilyMember(spouseName, Constants.MALE);
					//Set the Father to all the childs
					person.getChilds().forEach( child -> child.setFather(spouse) );
				}else {
					 spouse = new FamilyMember(spouseName, Constants.FEMALE);
				}
				//Set the spouse to one another
				person.setSpouse(spouse);
				spouse.setSpouse(person);
				FamilyCache.INSTANCE.addMemberToCache(spouse);
				result = Constants.SPOUSE_ADDITION_SUCCEEDED;
			}
		}
		return result;
	}
}
