package com.epam.task3.service.impl;

import com.epam.task3.bean.News;
import com.epam.task3.dao.NewsDao;
import com.epam.task3.dao.exception.DAOException;
import com.epam.task3.dao.factory.DAOFactory;
import com.epam.task3.service.CatalogService;
import com.epam.task3.service.decorator.Decorator;
import com.epam.task3.service.exception.LogicException;

import java.util.ArrayList;

/**
 * Created by Aliaksei_Babak on 1/30/2017.
 */
public class CatalogServiceImpl implements CatalogService{


    @Override
    public void addNews(News news) throws LogicException {
        if (news == null || news.getCategory() == null || news.getItemName() == null || news.getItemTitle() == null) {
            throw new LogicException("News can't be added. Some of the parameters nas null values");
        }
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            NewsDao newsDao = daoFactory.getTXTNewsDAO();
            newsDao.addNews(news);
        } catch (DAOException e) {
            throw new LogicException(e.getMessage());
        }

    }

    /**
     * Method returns list of news, found by definite title in request
     *
     * @param request
     * @param tagCount
     */
    @Override
    public String searchByTag(String[] request, int tagCount) throws LogicException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            NewsDao newsDao = daoFactory.getTXTNewsDAO();
            ArrayList<News> newsList = newsDao.getNewsByTag(request, tagCount);
            return Decorator.decorateSearchingList(newsList);
        } catch (DAOException e) {
            throw new LogicException(e.getMessage());
        }
    }


}
