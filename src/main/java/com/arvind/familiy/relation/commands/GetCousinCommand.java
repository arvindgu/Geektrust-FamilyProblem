package com.arvind.familiy.relation.commands;

import java.util.ArrayList;
import java.util.List;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class GetCousinCommand implements ICommand{

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
		List<FamilyMember> cousinList = new ArrayList<FamilyMember>();
		
		if(familyMember != null) {
			
			//Get Maternal cousins 
			if(familyMember.getMother()!= null) {
				FamilyMember grandMother = familyMember.getMother().getMother();
				if(grandMother != null) 
				{
					List<FamilyMember> motherSiblings = grandMother.getChilds();
						motherSiblings.stream()
							.filter(sibling ->  !sibling.getName().equalsIgnoreCase(familyMember.getMother().getName()))
							.forEach 
								( maternalSibling -> 
									{
										if(maternalSibling.getGender().equalsIgnoreCase(Constants.MALE) && maternalSibling.getSpouse() != null)  
											cousinList.addAll(maternalSibling.getSpouse().getChilds());
										else 
											cousinList.addAll(maternalSibling.getChilds());
									} 
								);
				}
			}
			
			//Get Paternal cousins 
			if(familyMember.getFather() != null
					&& familyMember.getFather().getMother()!= null 
					&& familyMember.getFather().getMother().getChilds().size() > 0) 
				{
					familyMember.getFather().getMother().getChilds().stream()
						.filter(child-> !child.getName().equalsIgnoreCase(familyMember.getFather().getName()))
						.forEach
							( paternalSibling -> 
								{
									if(paternalSibling.getGender().equalsIgnoreCase(Constants.MALE) && paternalSibling.getSpouse() != null)  
										cousinList.addAll(paternalSibling.getSpouse().getChilds());
									else 
										cousinList.addAll(paternalSibling.getChilds());
								}  
							);
				}
			
			if(!cousinList.isEmpty()) {
				for(FamilyMember member : cousinList) {
					sb.append(member.getName() + " ");
				}
				return sb.toString().trim();
			}

			return Constants.NONE;
		}
		return result;
	}
}
