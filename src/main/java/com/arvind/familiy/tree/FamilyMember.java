package com.arvind.familiy.tree;

import java.util.ArrayList;

/**
 * @author Arvind Gupta
 */
public class FamilyMember {
	
	private String name;
	private String gender;
	private FamilyMember mother;
	private FamilyMember father;
	private FamilyMember spouse;
	private ArrayList<FamilyMember> childs = new ArrayList<FamilyMember>();
	
	public FamilyMember(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public String getGender() {
		return gender;
	}
	
	
	
	public FamilyMember getMother() {
		return mother;
	}
	public void setMother(FamilyMember mother) {
		this.mother = mother;
	}
	
	
	public FamilyMember getFather() {
		return father;
	}
	public void setFather(FamilyMember father) {
		this.father = father;
	}
	
	
	public FamilyMember getSpouse() {
		return spouse;
	}
	public void setSpouse(FamilyMember spouse) {
		this.spouse = spouse;
	}
	
	
	public ArrayList<FamilyMember> getChilds() {
		return childs;
	}
	public void addChild(FamilyMember child) {
		this.getChilds().add(child);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((mother == null) ? 0 : mother.getName().hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FamilyMember other = (FamilyMember) obj;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (mother == null) {
			if (other.mother != null)
				return false;
		} else if (!mother.getName().equals(other.mother.getName()))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
