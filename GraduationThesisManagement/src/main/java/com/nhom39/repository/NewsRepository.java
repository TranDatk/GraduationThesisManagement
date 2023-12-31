package com.nhom39.repository;

import com.nhom39.pojo.News;

import java.util.List;
import java.util.Map;

public interface NewsRepository {
    public List<News> getNews(Map<String, String> params);
    public long countNews(Map<String, String> params);
    public News getNewsWithAuthorById(int newsId);
    public Object[] getNewsById(int newsId);
    public boolean addNews(News news, int userId);
    public boolean updateNews(int newsId, News news);
    public boolean deleteNews(int newsId);
}
