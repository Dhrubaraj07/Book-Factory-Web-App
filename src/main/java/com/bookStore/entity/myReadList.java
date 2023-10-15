package com.bookStore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class myReadList {
	@Id
	private int id;
	private String name;
	private String author;
	private String genre;
//	private String takeaways;
	public myReadList(int id, String name, String author, String genre) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.genre = genre;
//		this.takeaways = takeaways;
	}
	public myReadList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
//	public String getTakeaways() {
//		return takeaways;
//	}
//	public void setTakeaways(String takeaways) {
//		this.takeaways = takeaways;
//	}
}
