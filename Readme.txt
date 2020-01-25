Assumptions:
============
- As per the commands given, I have assumed that each person in the family will have unique name.
- Since it is not mentioned how to add spouse, I have provided ADD_SPOUSE command to add spouse and some more GET_RELATIONSHIP command. 
  
How it works:
=============
- At very first addition of child, the family root starts with adding both child and mother. 
- Spouse can be added to mother by ADD_SPOUSE command.
- After that family tree can be spawned by adding more childs and their spouses
- The code creates the family tree as shown on the problem picture by filling the data, from FillData.java class.
- More family members can be added via running the program and specifying ADD_CHILD and ADD_SPOUSE commands.
- Also the relationship can be queried with GET_RELATIONSHIP command specifying in text file.


****************
Program Logic :
****************

From the logic perspectives, I have implemented it in O(1) time complexity to have best performance, 
even when family tree can contains millions of people.
Any ADD/GET operation will give O(1) time complexity.

Also for my OOPS knowledge, please consider the design patterns I have used in my code.
	- Factory Design Pattern
	- Singleton Design Pattern
	- Command Design Pattern


As any family member in the tree :
     if Male, can be Son, Father, Brother, Husband, Brother-In-Law, Maternal Uncle, Parental Uncle etc.
     if Female, can be Daughter, Mother, Wife, Sister, Sister-in-Law, Maternal Aunt, Paternal Aunt etc. 

With Inheritance, the Members hierarchy can be created by having classes like Male, Female,  Mother, Father, Son, Daughter, Spouse  etc. 
However I believe this will introduce more complexity while adding them in family tree and assigning their relationship and later finding them via GET_RELATIONSHIP commands.

Hence I have used One FamilyMember class to represent all. 
Hence my program uses only one "Model" class FamilyMember.java.

FamilyMember.java - This class abstracts the a family member details as name, gender, mother, father, spouse, child list etc. and it represents a family member in tree connected with other members.
A child/spouse is get added to tree by creating its object and setting the mother and adding it to the mother's child list.

With the first entry, by calling ADD_CHILD, family root is created and set in FamilyTree.


FamilyCache.java - This is a Singleton class, which caches all the member's reference in a HashMap for quick search.

Command Design Pattern is used to create below commands.

Supported Commands are: I have added some more commands other than listed in problem statement.
	AddChild 
	AddSpouse
	GetBrotherInLaw
	GetChildren
	GetDaughter
	GetFather
	GetMaternalAunt
	GetMaternalUncle
	GetPaternalAunt
	GetPaternalUncle
	GetSiblings
	GetSisterInLaw
	GetSon
	GetSpouse
	GetMotherInLawCommand 
	GetFatherInLawCommand
	GetMotherCommand
	GetFatherCommand
	GetGeneration


Factory Design Pattern is used to create above Command classes. There is factory class CommandFactory.java

FamilyTreeCommandExecuter is used to invoke above commands. 

FamilyTreeCommandProcessor - Validate and Process the command.

FamilyTreeCommandProcessor calls the command Factory to get the Add/Get command based on the input.
The CommandProcessor uses CommandExecuter to execute the command. 
Each command print out the results on the console.

FillData - Creates the family tree as shown in problem picture and fills the data in family tree.
The FillData has switch to stop displaying the default insertion command in console.

FamilyTreeRunner - Reads the text file, line by line and invokes CommandProcessor to execute the commands listed in input file.

Test Cases:
==========
Junit is used for testing and its dependency is added in pom.xml file.


######
Note: 
######
Multiple if/else are required to validate the conditions and provide the correct output when a person is already added/not present,
or when the operation is succeeded or failed.


