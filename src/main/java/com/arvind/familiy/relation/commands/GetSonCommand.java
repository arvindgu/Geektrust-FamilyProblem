package com.arvind.familiy.relation.commands;

import java.util.List;
import java.util.stream.Collectors;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class GetSonCommand implements ICommand{

	private String[] input;
	
	public void setCommandInputArray(String[] input){
		this.input = input;
	}
	
	@Override
	public String runCommand() {
		String name = input[1];
		FamilyMember familyMember = FamilyCache.INSTANCE.getMemberFromCache(name);
		String result = Constants.PERSON_NOT_FOUND;
		StringBuilder sb = new StringBuilder();
		
		if(familyMember != null) {
			List<FamilyMember> sons = null;
			FamilyMember spouse = null;
			
			if(familyMember.getGender().equals(Constants.MALE) ) {
				spouse = familyMember.getSpouse();
			}
			else {
				spouse = familyMember;
			}
			
			sons = spouse.getChilds();
			if(!sons.isEmpty()) {
				sons = sons.stream()
						.filter(fm->fm.getGender().equals(Constants.MALE)).collect(Collectors.toList());	
				
				if(!sons.isEmpty()) {
					sons.forEach( son -> sb.append(son.getName() + " "));
				}
			}
			String people = sb.toString().trim();
			result = people.isEmpty() ? Constants.NONE : people; 
		}
		return result;
	}
}
