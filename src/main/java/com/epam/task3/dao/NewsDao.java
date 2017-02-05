package com.epam.task3.dao;

import com.epam.task3.bean.News;
import com.epam.task3.dao.exception.DAOException;

import java.util.ArrayList;

/**
 * describes behavior of the NewsDAO Entity
 */
public interface NewsDao {
    /**
     * write information about new news in the file
     * @param news self-created news
     * @throws DAOException
     */
    void addNews(News news) throws DAOException;

    /**
     * read information from the file
     * @param request tag to find correct information
     * @param tagCount
     * @return arraylist of found news
     * @throws DAOException
     */
    ArrayList<News> getNewsByTag(String[] request, int tagCount) throws DAOException;

}
