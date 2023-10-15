package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.myReadList;
import com.bookStore.repository.myBookRepository;

@Service
public class myBookListService {
	@Autowired
	private myBookRepository myRepo;
	
	public void saveMyBooks(myReadList book) {
		myRepo.save(book);
	}
	
	public List<myReadList> getAllBooks(){
		return myRepo.findAll();
	}

	public void deleteById(int id) {
		myRepo.deleteById(id);
	}
}
