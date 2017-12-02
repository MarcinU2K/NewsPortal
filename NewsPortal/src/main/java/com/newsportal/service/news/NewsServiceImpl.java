package com.newsportal.service.news;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.newsportal.domain.general.Section;
import com.newsportal.domain.general.SubSection;
import com.newsportal.domain.news.News;
import com.newsportal.repository.news.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private NewsRepository newsRepository;

	@Override
	public News addNews(News news) {
		log.info("about to add news");

		if (news == null) {
			log.error("addNews(): Empty body");
			throw new IllegalArgumentException();
		}

		News newNews = new News();
		newNews.setMainTitle(news.getMainTitle());
		newNews.setShortDesc(news.getShortDesc());
		newNews.setNewsContent(news.getNewsContent());
		newNews.setImage(news.getImage());
		newNews.setPublicationDate(new Date());

		if (StringUtils.isEmpty(news.getSection())) {

			newNews.setSection(Section.UNASSIGNED);

		} else {

			newNews.setSection(news.getSection());
		}

		if (StringUtils.isEmpty(news.getSubSection())) {

			newNews.setSubSection(SubSection.UNASSIGNED);

		} else {

			newNews.setSubSection(news.getSubSection());
		}

		return newsRepository.save(newNews);
	}

	@Override
	public String removeNewsById(String id) {
		log.info("about to remove news");

		News savedNews = newsRepository.findOne(id);

		if (savedNews == null) {
			throw new IllegalArgumentException("News not found");
		}

		newsRepository.delete(savedNews);
		return "DELETED";
	}

	@Override
	public News editNewsById(News news, String id) {
		log.info("about to edit news");

		if (news == null) {
			throw new IllegalArgumentException("Incoming body null");
		}

		News savedNews = newsRepository.findOne(id);

		dataEdit(news, savedNews);

		return newsRepository.save(savedNews);
	}

	private void dataEdit(News news, News savedNews) {
		if (savedNews == null) {
			throw new IllegalArgumentException("News not found in DB");
		}

		if (!(StringUtils.isEmpty(news.getMainTitle()) || news.getMainTitle().equals(savedNews.getMainTitle()))) {
			savedNews.setMainTitle(news.getMainTitle());
			log.info("new MainTitle is: " + savedNews.getMainTitle());
		}

		if (!(StringUtils.isEmpty(news.getNewsContent()) || news.getNewsContent().equals(savedNews.getNewsContent()))) {
			savedNews.setNewsContent(news.getNewsContent());
			log.info("new NewsContent is: " + savedNews.getNewsContent());
		}

		if (!(StringUtils.isEmpty(news.getSection()) || news.getSection().equals(savedNews.getSection()))) {
			savedNews.setSection(news.getSection());
			log.info("new Section is: " + savedNews.getSection());
		}

		if (!(StringUtils.isEmpty(news.getSubSection()) || news.getSubSection().equals(savedNews.getSubSection()))) {
			savedNews.setSubSection(news.getSubSection());
			log.info("new SubSection is: " + savedNews.getSubSection());
		}

		if (!(StringUtils.isEmpty(news.getShortDesc()) || news.getShortDesc().equals(savedNews.getShortDesc()))) {
			savedNews.setShortDesc(news.getShortDesc());
			log.info("new ShortDescription is: " + savedNews.getShortDesc());
		}

		if (!(StringUtils.isEmpty(news.getImage()) || news.getImage().equals(savedNews.getImage()))) {
			savedNews.setImage(news.getImage());
			log.info("new Image is: " + savedNews.getImage());
		}
	}

	@Override
	public Iterable<News> getAllNews() {
		return newsRepository.findAll();
	}
}