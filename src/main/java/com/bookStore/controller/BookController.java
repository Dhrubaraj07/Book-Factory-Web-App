package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Book;
import com.bookStore.entity.myReadList;
import com.bookStore.service.BookService;
import com.bookStore.service.myBookListService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	@Autowired
	private myBookListService myBookListService;
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/book_add")
	public String bookAdd() {
		return "bookAdd";
	}
	@GetMapping("/books_to_read")
	public ModelAndView getAllBook() {
		List<Book> list=service.getAllbook();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("bookList");
		mv.addObject("ListName", list);
		return mv;
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/books_to_read";
	}
	
	@GetMapping("/my_Read_books")
	public ModelAndView myReadBooks() {
		List<myReadList> list=myBookListService.getAllBooks();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("myReadBook");
		mv.addObject("readList",list);
		return mv;
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id){
		Book b=service.getBookById(id);
		myReadList mdList=new myReadList(b.getId(),b.getName(),b.getAuthor(),b.getGenre());
		myBookListService.saveMyBooks(mdList);
		service.deleteById(id);
		return "redirect:/my_Read_books";
	}
	
	@RequestMapping("/deleteABook/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/books_to_read";
	}
	@RequestMapping("/editBook/{id}")
	public String editABook(@PathVariable("id") int id,Model model) {
		Book book=service.getBookById(id);
		model.addAttribute("particularBook",book);
		return "bookEdit";
	}
}
