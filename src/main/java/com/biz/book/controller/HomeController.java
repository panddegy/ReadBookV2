package com.biz.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.book.model.BookFormVO;
import com.biz.book.service.BookService;

@Controller
public class HomeController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("BODY", "MAIN");
		model.addAttribute("BOOK", bookService.mainPage());
		
		return "home";
	}
	
}
