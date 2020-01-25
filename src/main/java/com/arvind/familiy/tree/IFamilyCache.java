package com.arvind.familiy.tree;

import java.util.HashMap;

/**
 * @author Arvind Gupta
 */
public interface IFamilyCache {
	
	HashMap<String, FamilyMember> getFamilyMemberCache() ;

	void addMemberToCache(FamilyMember familyMember );
	
	FamilyMember getMemberFromCache(String name);
	
	FamilyMember getMemberFromCache(FamilyMember familyMember);
}
