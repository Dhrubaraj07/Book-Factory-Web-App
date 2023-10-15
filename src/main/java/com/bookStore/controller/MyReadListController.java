package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.service.myBookListService;

@Controller
public class MyReadListController {
	@Autowired
	private myBookListService mybookService; 
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		mybookService.deleteById(id);
		return "redirect:/my_Read_books";
	}
}
