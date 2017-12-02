package com.newsportal.domain.news;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.newsportal.domain.general.Section;
import com.newsportal.domain.general.SubSection;

@Document
public class News {
	
	@Id
	private String id;
	
	private Section section;
	
	private SubSection subSection;
	
	@NotNull(message = "The main title cannot be null. Please make necessary changes.")
	private String mainTitle;
	
	private String shortDesc;
	
	@NotNull(message = "The news content cannot be null. Please make appropriate amendments.")
	private String newsContent;
	
	private String image;
	
	private Date publicationDate;

	public News() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public SubSection getSubSection() {
		return subSection;
	}

	public void setSubSection(SubSection newsSection) {
		this.subSection = newsSection;
	}

	public String getMainTitle() {
		return mainTitle;
	}

	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
}