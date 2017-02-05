package com.epam.task3.controller;


import com.epam.task3.controller.command.CommandName;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * Implements controller layer
 */
public class Controller {
    private final CommandProvider commandProvider = new CommandProvider();
    private static Controller instance;
    private final static String paramDelimeter = " ";

    public static Controller getInstance() {
        if (instance == null) {
            instance = new  Controller();
        }
        return instance;
    }

    private Controller(){
    }

    /**
     * split input String and give it to the command provider
     * @param request input String
     * @return response from executed command
     */
    public String execute(String request) {
        String commandName = request.substring(0, request.indexOf(paramDelimeter)).toUpperCase();
        String [] valuesInQuotes = StringUtils.substringsBetween(request , "\"", "\"");
        return commandProvider.getCommand(commandName).execute(valuesInQuotes, CommandName.valueOf(commandName).getTagCount());
    }

}
