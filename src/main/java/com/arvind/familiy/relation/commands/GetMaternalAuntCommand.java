package com.arvind.familiy.relation.commands;

import java.util.List;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class GetMaternalAuntCommand implements ICommand {
	
	private String[] commandInputArray;
	
	public void setCommandInputArray(String[] commandInputArray){
		this.commandInputArray = commandInputArray;
	}
	
	@Override
	public String runCommand() {
		String name = commandInputArray[1];
		FamilyMember familyMember = FamilyCache.INSTANCE.getMemberFromCache(name);
		String result = Constants.PERSON_NOT_FOUND;
		StringBuilder sb = new StringBuilder();
		
		if(familyMember != null) {
			if(familyMember.getMother()!= null) {
				FamilyMember grandMother = familyMember.getMother().getMother();
				if(grandMother != null) {
					List<FamilyMember> motherSiblings = grandMother.getChilds();
					if (motherSiblings.size() > 1) {
						motherSiblings.stream()
							.filter(member -> member.getGender().equals(Constants.FEMALE)
									&& !member.getName().equalsIgnoreCase(familyMember.getMother().getName()))
							.forEach(item -> sb.append(item.getName() + " "));
					} 
				} 
			}
			String people = sb.toString().trim();
			result = people.isEmpty() ? Constants.NONE : people;
		}
		return result;
	}

}
