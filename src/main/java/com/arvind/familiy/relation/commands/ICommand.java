package com.arvind.familiy.relation.commands;

/**
 * @author Arvind Gupta
 */
public interface ICommand {
	String runCommand();
	void setCommandInputArray(String[] commandInputArray);
}
