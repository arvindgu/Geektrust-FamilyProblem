package com.arvind.familiy.util;

import java.util.HashSet;

/**
 * @author Arvind Gupta
 */
public class Constants {
	
	public static final String MALE = "MALE";
	public static final String FEMALE = "FEMALE";
	
	public static final String INVALID_COMMAND = "Invalid Command or invalid Parameters passed";
	
	
	public static final String NONE = "NONE";
	public static final String PERSON_NOT_FOUND = "PERSON_NOT_FOUND";
	public static final String CHILD_ADDITION_SUCCEEDED = "CHILD_ADDITION_SUCCEEDED";
	public static final String CHILD_ADDITION_FAILED = "CHILD_ADDITION_FAILED";
	public static final String SPOUSE_ADDITION_SUCCEEDED = "SPOUSE_ADDITION_SUCCEEDED";
	public static final String SPOUSE_ADDITION_FAILED = "SPOUSE_ADDITION_FAILED";
	
	public static final String ADD_CHILD = "ADD_CHILD";
	public static final String ADD_SPOUSE = "ADD_SPOUSE";
	
	public static final String GET_RELATIONSHIP = "GET_RELATIONSHIP";
	
	public static final String BROTHER_IN_LAW = "BROTHER-IN-LAW";
	public static final String CHILDREN = "CHILDREN";
	public static final String DAUGHTER = "DAUGHTER";
	public static final String FATHER = "FATHER";
	public static final String MOTHER = "MOTHER";
	public static final String MATERNAL_AUNT = "MATERNAL-AUNT";
	public static final String MATERNAL_UNCLE = "MATERNAL-UNCLE";
	public static final String PATERNAL_AUNT = "PATERNAL-AUNT";
	public static final String PATERNAL_UNCLE = "PATERNAL-UNCLE";
	public static final String SIBLINGS = "SIBLINGS";
	public static final String SISTER_IN_LAW = "SISTER-IN-LAW";
	public static final String SON = "SON";
	public static final String SPOUSE = "SPOUSE";
	public static final String COUSIN = "COUSIN";
	public static final String FATHER_IN_LAW = "FATHER-IN-LAW";
	public static final String MOTHER_IN_LAW = "MOTHER-IN-LAW";
	public static final String GENERATION = "GENERATION";
	
	public static final HashSet<String> relationiShips = new HashSet<String>();
	
	public static final HashSet<String> allowedCommands = new HashSet<String>();
	
	static{
		relationiShips.add("BROTHER-IN-LAW");
		relationiShips.add("CHILDREN");
		relationiShips.add("DAUGHTER");
		relationiShips.add("FATHER");
		relationiShips.add("MATERNAL-AUNT");
		relationiShips.add("MATERNAL-UNCLE");
		relationiShips.add("PATERNAL-AUNT");
		relationiShips.add("PATERNAL-UNCLE");
		relationiShips.add("SIBLING");
		relationiShips.add("SISTER-IN-LAW");
		relationiShips.add("SON");
		relationiShips.add("SPOUSE");
		relationiShips.add("FATHER_IN_LAW");
		relationiShips.add("MOTHER_IN_LAW");
		relationiShips.add("COUSIN");
		relationiShips.add("GENERATION_NO");
		
		allowedCommands.add(GET_RELATIONSHIP);
		allowedCommands.add(ADD_CHILD);
		allowedCommands.add(ADD_SPOUSE);
	}
	
}
