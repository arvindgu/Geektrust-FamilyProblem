package com.arvind.misc.test;

import java.net.URL;

import com.arvind.familiytree.main.FamilyTreeRunner;

/**
 * Test cases for Family Tree problem.
 * 
 * @author Arvind Gupta
 */

public class FamilyTreeTest 
{
	public static void main(String args[]) {
		
		FamilyTreeTest ft = new FamilyTreeTest();
		URL url = ft.getClass().getResource("testScenarios.txt");
		
		testInvalidInputFile(url.getPath());
		
		testCorrectInputFile(url.getPath());
	}
	
	static void testInvalidInputFile(String fileName) {
		String args [] = {fileName+"Invalid"};
		FamilyTreeRunner.main(args);
	}
	
	static void testCorrectInputFile(String fileName) {
		String args [] = {fileName};
		FamilyTreeRunner.main(args);
	}
}

