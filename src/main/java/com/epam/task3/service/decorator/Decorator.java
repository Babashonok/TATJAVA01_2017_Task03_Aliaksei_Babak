package com.epam.task3.service.decorator;

import com.epam.task3.bean.News;

import java.util.ArrayList;

public class Decorator {
    /**
     *
     * @param newsList arraylist, that contains suited news
     * @return string representation of the arraylist
     */
    public static String decorateSearchingList(ArrayList<News> newsList) {
        StringBuilder stringBuilder = new StringBuilder("List of find units :").append("\n");
        for (News news : newsList) {
            stringBuilder.append("Category : ").append(news.getCategory()).append("  Name : ").append(news.getItemName())
                    .append(" Title : ").append(news.getItemTitle()).append("\n");
        }
        return String.valueOf(stringBuilder);
    }
}
