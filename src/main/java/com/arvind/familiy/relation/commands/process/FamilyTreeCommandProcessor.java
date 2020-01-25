package com.arvind.familiy.relation.commands.process;

import com.arvind.familiy.relation.commands.CommandFactory;
import com.arvind.familiy.relation.commands.ICommand;
import com.arvind.familiy.util.Constants;

/**
 * @author Arvind Gupta
 */
public class FamilyTreeCommandProcessor implements IFamilyTreeCommandProcessor {
	
	private ICommandExecuter commandExecuter;
	
	
	public FamilyTreeCommandProcessor(ICommandExecuter commandExecuter){
		this.commandExecuter = commandExecuter;
	}
	
	public boolean isValidCommand(String[] input) {
		if(!Constants.allowedCommands.contains(input[0])) {
			return false;
		}
		
		if(input[0].equals(Constants.GET_RELATIONSHIP) || input[0].equals(Constants.ADD_SPOUSE)) {
			if(input.length != 3) {
				return false;
			}
		}
		else if(input[0].equals(Constants.ADD_CHILD) && input.length != 4) {
			return false;
		}
		return true;
	}
	
	@Override
	public String processCommand(String commandILine) {
		
		System.out.println(commandILine );
		
		String[] commandOptions = commandILine.trim().split("\\s+");
		
		//Remove the spaces from start/end
		for(int i=0;  i<commandOptions.length;i++) {
			commandOptions[i] = commandOptions[i].trim();
		}
		
		commandOptions[0] = commandOptions[0].toUpperCase();
		
		if(commandOptions[0].equals(Constants.GET_RELATIONSHIP) || commandOptions[0].equals(Constants.ADD_CHILD)) {
			commandOptions[commandOptions.length-1] = commandOptions[commandOptions.length-1].toUpperCase();
		}
		
		//Validate the Command and Process it
		if(!isValidCommand(commandOptions)) {
			return Constants.INVALID_COMMAND;
		}
		else 
		{
			if("GET_RELATIONSHIP".equals(commandOptions[0])) 
			{
				ICommand command = CommandFactory.getCommand(commandOptions[2]);
				if(command == null ) {
					return Constants.INVALID_COMMAND;
				}
				command.setCommandInputArray(commandOptions);
				return commandExecuter.execute(command);
			}
			else if(Constants.ADD_CHILD.equals(commandOptions[0]) || Constants.ADD_SPOUSE.equals(commandOptions[0])) {
				ICommand command = CommandFactory.getCommand(commandOptions[0]);
				if(command == null ) {
					return Constants.INVALID_COMMAND;
				}
				command.setCommandInputArray(commandOptions);
				return commandExecuter.execute(command);
			}
			return Constants.INVALID_COMMAND;
		}
	}
}
