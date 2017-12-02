package com.newsportal.repository.news;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.newsportal.domain.news.News;

@Repository
public interface NewsRepository extends CrudRepository<News, String> {

}