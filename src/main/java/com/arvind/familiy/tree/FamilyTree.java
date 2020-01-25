package com.arvind.familiy.tree;

/**
 * @author Arvind Gupta
 */
public enum FamilyTree {
	
	INSTANCE;
	private FamilyMember root;
	
	public FamilyMember getFamilyRoot() {
		return root;
	}
	
	public void setFamilyRoot(FamilyMember familyMember) {
		this.root = familyMember;
	}
	
}

