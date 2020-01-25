package com.arvind.familiy.relation.commands;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class GetSpouseCommand implements ICommand{

	private String[] commandInputArray;
	
	public void setCommandInputArray(String[] commandInputArray){
		this.commandInputArray = commandInputArray;
	}
	
	@Override
	public String runCommand() {
		String name = commandInputArray[1];
		String result = Constants.NONE;
		FamilyMember familyMember = FamilyCache.INSTANCE.getMemberFromCache(name);
		if(familyMember != null
				&& familyMember.getSpouse() != null) {
				result = familyMember.getSpouse().getName();
		}
		return result;
	}
}
