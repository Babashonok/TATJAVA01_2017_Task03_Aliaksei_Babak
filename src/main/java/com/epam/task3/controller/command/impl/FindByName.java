package com.epam.task3.controller.command.impl;

import com.epam.task3.controller.command.Command;
import com.epam.task3.service.CatalogService;
import com.epam.task3.service.exception.LogicException;
import com.epam.task3.service.factory.ServiceFactory;

/**
 * name command realization
 */
public class FindByName implements Command {
    /**
     * handle request String and execute command according String array Value
     *
     * @param request split input parameters
     * @param tagCount
     * @return response
     */
    public String execute(String[] request, int tagCount) {
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            CatalogService catalogService = serviceFactory.getCatalogServiceImpl();
            return catalogService.searchByTag(request, tagCount);
        } catch (LogicException e) {
            return e.getMessage();
        }
    }
}
