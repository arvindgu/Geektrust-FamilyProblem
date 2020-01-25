package com.arvind.familiy.relation.commands.process;

import com.arvind.familiy.relation.commands.ICommand;

/**
 * @author Arvind Gupta
 */
public class FamilyTreeCommandExecuter implements ICommandExecuter {
	
	@Override
	public String execute(ICommand command) {
		return command.runCommand();
	}
}
