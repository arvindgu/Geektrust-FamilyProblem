package com.arvind.familiy.relation.commands;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class GetMotherCommand implements ICommand{
	
	private String[] commandInputArray;
	
	public void setCommandInputArray(String[] commandInputArray){
		this.commandInputArray = commandInputArray;
	}
	
	@Override
	public String runCommand() {
		String name = commandInputArray[1];
		String result = Constants.NONE;
		FamilyMember son = FamilyCache.INSTANCE.getMemberFromCache(name);
		if(son != null && son.getMother() != null) {
				result = son.getMother().getName();
		}
		return result;
	}
}
