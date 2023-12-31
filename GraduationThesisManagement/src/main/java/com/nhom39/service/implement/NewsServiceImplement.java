package com.nhom39.service.implement;

import com.nhom39.pojo.News;
import com.nhom39.repository.NewsRepository;
import com.nhom39.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImplement implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> getNews(Map<String, String> params) {
        return this.newsRepository.getNews(params);
    }

    @Override
    public long countNews(Map<String, String> params) {
        return this.newsRepository.countNews(params);
    }

    @Override
    public News getNewsWithAuthorById(int newsId) {
        return newsRepository.getNewsWithAuthorById(newsId);
    }

    @Override
    public Object[] getNewsById(int newsId) {
        return this.newsRepository.getNewsById(newsId);
    }

    @Override
    public boolean addNews(News news, int userId) {
        return this.newsRepository.addNews(news, userId);
    }

    @Override
    public boolean updateNews(int newsId, News news) {
        return this.newsRepository.updateNews(newsId, news);
    }

    @Override
    public boolean deleteNews(int newsId) {
        return this.newsRepository.deleteNews(newsId);
    }
}
