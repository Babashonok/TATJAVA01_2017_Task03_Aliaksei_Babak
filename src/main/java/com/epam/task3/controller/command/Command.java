package com.epam.task3.controller.command;

/**
 *  Defines behavior for any command input execution
 */
public interface Command {
    /**
     * handle request String and execute command according String array Value
     * @param request split input parameters
     * @param tagCount
     * @return response
     */
    String execute(String[] request, int tagCount);
}