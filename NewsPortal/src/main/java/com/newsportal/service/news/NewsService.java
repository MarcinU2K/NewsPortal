package com.newsportal.service.news;

import com.newsportal.domain.news.News;

public interface NewsService {

	News addNews(News news);

	String removeNewsById(String id);

	News editNewsById(News news, String id);

	Iterable<News> getAllNews();
	
}