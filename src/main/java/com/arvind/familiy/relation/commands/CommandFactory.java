package com.arvind.familiy.relation.commands;

import com.arvind.familiy.util.Constants;

public abstract class CommandFactory {
	
    public static ICommand getCommand(String relationship) {

    	ICommand command = null;

        switch (relationship) {
        		        
            case Constants.BROTHER_IN_LAW:
            	command = new GetBrotherInLawCommand();
                break;

            case Constants.CHILDREN:
            	command = new GetChildrenCommand();
                break;

            case Constants.DAUGHTER:
            	command = new GetDaughterCommand();
                break;
            	
            case Constants.FATHER:
            	command = new GetFatherCommand();
                break;
            	
            case Constants.FATHER_IN_LAW:
            	command = new GetFatherInLawCommand();
                break;
            	
            case Constants.MATERNAL_AUNT:
            	command = new GetMaternalAuntCommand();
                break;
            	
            case Constants.MATERNAL_UNCLE:
            	command = new GetMaternalUncleCommand();
                break;
                
            case Constants.MOTHER:
            	command = new GetMotherCommand();
                break;
                
            case Constants.MOTHER_IN_LAW:
            	command = new GetMotherInLawCommand();
                break;
                
            case Constants.PATERNAL_AUNT:
            	command = new GetPaternalAuntCommand();
                break;
            	
            case Constants.PATERNAL_UNCLE:
            	command = new GetPaternalUncleCommand();
                break;
            	
            case Constants.SIBLINGS:
            	command = new GetSiblingsCommand();
                break;
            	
            case Constants.SISTER_IN_LAW:
            	command = new GetSisterInLawCommand();
                break;
            	
            case Constants.SON:
            	command = new GetSonCommand();
                break;
            	
            case Constants.SPOUSE:
            	command = new GetSpouseCommand();
                break;
                
            case Constants.COUSIN:
            	command = new GetCousinCommand();
                break;
                
            case Constants.ADD_CHILD:
            	command = new AddChildCommand();
		        break;
		
		    case Constants.ADD_SPOUSE:
		    	command = new AddSpouseCommand();
		        break;
		        
		    case Constants.GENERATION:
		    	command = new GetGenerationCommand();
		        break;
        }
        return command;
        
    }    
    
    /*public static IFindGeneration getGenerationCommand(String command) {
    	IFindGeneration generationCommmand = null;
    	if(command.equals(Constants.GENERATION)) {
    		generationCommmand =  new GetGenerationCommand();
    	}
    	return generationCommmand;
    }*/
    
}
