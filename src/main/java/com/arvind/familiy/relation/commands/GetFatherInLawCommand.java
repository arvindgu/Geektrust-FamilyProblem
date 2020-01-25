package com.arvind.familiy.relation.commands;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class GetFatherInLawCommand implements ICommand{

	private String[] commandInputArray;
	
	public void setCommandInputArray(String[] commandInputArray){
		this.commandInputArray = commandInputArray;
	}
	
	@Override
	public String runCommand() {
		String name = commandInputArray[1];
		FamilyMember familyMember = FamilyCache.INSTANCE.getMemberFromCache(name);
		String result = Constants.PERSON_NOT_FOUND;
		if(familyMember != null) {
			if(familyMember.getSpouse().getFather() != null) {
					result  = familyMember.getSpouse().getFather().getName();
			}else {
				result = Constants.NONE;
			}
		}
		return result;
	}
}
