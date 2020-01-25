package com.arvind.familiy.relation.commands;

import com.arvind.familiy.tree.FamilyCache;
import com.arvind.familiy.tree.FamilyMember;
import com.arvind.familiy.tree.FamilyTree;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class AddChildCommand implements ICommand{
	private String[] commandInputArray;
	
	public void setCommandInputArray(String[] commandInputArray){
		this.commandInputArray = commandInputArray;
	}
	
	@Override
	public String runCommand() {
		String motherName = commandInputArray[1];
		String childName = commandInputArray[2];
		String gender = commandInputArray[3].toUpperCase();
		String result = Constants.CHILD_ADDITION_FAILED;
		
		FamilyMember familyRoot = FamilyTree.INSTANCE.getFamilyRoot();
		
		if( motherName != null && childName != null && gender != null
				&& !motherName.trim().isEmpty()
				&& !gender.trim().isEmpty()
				&& !childName.trim().isEmpty()
				&& !motherName.equalsIgnoreCase(childName))
		{
			if(familyRoot == null) {
				FamilyMember mother = new FamilyMember(motherName, Constants.FEMALE);
				FamilyMember child = new FamilyMember(childName, gender);
				mother.addChild(child);
				child.setMother(mother);
				FamilyTree.INSTANCE.setFamilyRoot(mother);
				FamilyCache.INSTANCE.addMemberToCache(mother);
				FamilyCache.INSTANCE.addMemberToCache(child);
				result = Constants.CHILD_ADDITION_SUCCEEDED;
			}
			else {
				FamilyMember mother = FamilyCache.INSTANCE.getMemberFromCache(motherName);
				
				if(mother == null){
					result = Constants.PERSON_NOT_FOUND;
				}
				else {
					//If the given person gender is Male, or the child with the same name is present, do not add the child
					if (!mother.getGender().equals(Constants.MALE)
							&& FamilyCache.INSTANCE.getMemberFromCache(childName) == null) 
					{
						FamilyMember child = new FamilyMember(childName, gender);
						child.setMother(mother);
						mother.addChild(child);
						//Set the Father of Child, if father is present
						if(mother.getSpouse()!= null) {
							child.setFather(mother.getSpouse());
						}
						//Add the child to cache
						FamilyCache.INSTANCE.addMemberToCache(child);
						result = Constants.CHILD_ADDITION_SUCCEEDED;
					}
				}
			}
		}
		return result;
	}
}

