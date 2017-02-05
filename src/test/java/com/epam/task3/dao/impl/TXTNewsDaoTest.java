package com.epam.task3.dao.impl;

import com.epam.task3.bean.News;
import com.epam.task3.dao.NewsDao;

import com.epam.task3.dao.exception.DAOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TXTNewsDaoTest {

    NewsDao newsDAOTxt;

    @BeforeMethod
    public void setUp(){
        newsDAOTxt = new TXTNewsDao();
    }
    @DataProvider(name = "InvalidNewsData")
    public Object[][] getInvalidNewsData() {
        return new Object[][] {
                {new News()},
                {null}
        };
    }

    @Test(dataProvider = "InvalidNewsData", expectedExceptions = DAOException.class)
    public void testNegativeNewsAdding(News news) throws Exception {
        newsDAOTxt.addNews(news);
    }
    @Test( expectedExceptions = DAOException.class)
    public void testEmptyRequest() throws Exception {
        newsDAOTxt.getNewsByTag(new String[]{}, 5);
    }
    @Test( expectedExceptions = DAOException.class)
    public void testNullValueRequest() throws Exception {
        newsDAOTxt.getNewsByTag(new String[]{null,null,null}, 5);
    }
}