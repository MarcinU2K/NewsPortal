package com.newsportal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newsportal.domain.news.News;
import com.newsportal.service.news.NewsService;

@RestController
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService newsService;
	
	@PreAuthorize("hasAnyRole('ADMIN','EDITOR','EDITOR_IN_CHIEF')")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<News> addNews(@Valid @RequestBody News news) {
		try {
			return ResponseEntity.ok(newsService.addNews(news));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@PreAuthorize("hasAnyRole('ADMIN','EDITOR','EDITOR_IN_CHIEF')")
	@RequestMapping(value = "/remove/{id}/", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeNewsById(@PathVariable("id")String id) {
		try {
			return ResponseEntity.ok(newsService.removeNewsById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PreAuthorize("hasAnyRole('ADMIN','EDITOR','EDITOR_IN_CHIEF')")
	@RequestMapping(value = "/edit/{id}/", method = RequestMethod.PUT)
	public ResponseEntity<?> editNewsById(@RequestBody News news, @PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(newsService.editNewsById(news, id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Iterable<News> getAllNews() {
		return newsService.getAllNews();
	}
}
