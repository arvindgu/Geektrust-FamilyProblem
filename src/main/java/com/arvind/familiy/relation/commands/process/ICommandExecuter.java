package com.arvind.familiy.relation.commands.process;

import com.arvind.familiy.relation.commands.ICommand;

public interface ICommandExecuter {

	String execute(ICommand command);
}