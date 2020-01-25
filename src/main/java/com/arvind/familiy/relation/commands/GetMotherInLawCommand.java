package com.arvind.familiy.relation.commands;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class GetMotherInLawCommand implements ICommand{

	private String[] commandInputArray;
	
	public void setCommandInputArray(String[] commandInputArray){
		this.commandInputArray = commandInputArray;
	}
	
	@Override
	public String runCommand() {
		String name = commandInputArray[1];
		String result = Constants.PERSON_NOT_FOUND;
		FamilyMember familyMember = FamilyCache.INSTANCE.getMemberFromCache(name);
		if(familyMember != null) {
			if( familyMember.getSpouse() != null 
				&& familyMember.getSpouse().getMother() != null) 
			{
				result = familyMember.getSpouse().getMother().getName() ;
			}else {
				result = Constants.NONE;
			}
		}
		return result;
	}
}
