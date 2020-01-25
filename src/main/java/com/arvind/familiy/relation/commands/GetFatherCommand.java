package com.arvind.familiy.relation.commands;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class GetFatherCommand implements ICommand{
	
	private String[] commandInputArray;
	
	public void setCommandInputArray(String[] commandInputArray){
		this.commandInputArray = commandInputArray;
	}
	
	@Override
	public String runCommand() {
		String name = commandInputArray[1];
		FamilyMember son = FamilyCache.INSTANCE.getMemberFromCache(name);
		String result = Constants.NONE;
		
		if(son != null && son.getFather() != null) 
		{
			result = son.getFather().getName();
		}
		return result;
	}
}
