package com.arvind.familiy.tree;

import java.util.HashMap;

/**
 * Singleton Class
 * This class is used to cache the references of FamilyMember objects.
 * 
 * @author Arvind Gupta
 */
public enum FamilyCache implements IFamilyCache {
	
	INSTANCE;
		
	private HashMap<String, FamilyMember> familyMemberCache = new HashMap<String, FamilyMember>();
		
	@Override
	public HashMap<String, FamilyMember> getFamilyMemberCache() {
		return familyMemberCache;
	}
	

	//Assumed that the family members names are unique
	@Override
	public void addMemberToCache(FamilyMember familyMember ){				
		familyMemberCache.put(familyMember.getName(), familyMember);
	}
	
	
	@Override
	public synchronized FamilyMember getMemberFromCache(String name) {
		return familyMemberCache.get(name);
	}
	
	@Override
	public synchronized FamilyMember getMemberFromCache(FamilyMember familyMember) {
		return familyMemberCache.get(familyMember.getName());		
	}

}
