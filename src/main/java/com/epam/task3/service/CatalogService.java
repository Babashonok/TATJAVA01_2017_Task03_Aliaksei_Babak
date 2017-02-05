package com.epam.task3.service;

import com.epam.task3.bean.News;
import com.epam.task3.service.exception.LogicException;

import java.util.ArrayList;

/**
 * describes behavior of the CatalogService Entity
 */
public interface CatalogService {
    /**
     * add news to the file
     * @param news self-created news
     * @throws LogicException
     */
    void addNews(News news) throws LogicException;

    /**
     * find all search suited entities
     * @param request splitted user input
     * @param tagCount
     * @return string representation of the news list
     * @throws LogicException
     */
    String searchByTag(String[] request, int tagCount) throws LogicException;

}
