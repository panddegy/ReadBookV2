package com.biz.book.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.book.model.BookFormVO;
import com.biz.book.model.BookVO;
import com.biz.book.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookController {
	
	@Autowired
	BookService bookService;

	@RequestMapping(value="write", method=RequestMethod.GET)
	public String writeBook(Model model, @ModelAttribute BookFormVO bookFormVO) {
		
		model.addAttribute("BODY", "WRITE");
		
		return "home";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String writeBook(Model model, @ModelAttribute @Valid BookFormVO bookFormVO, BindingResult result,MultipartHttpServletRequest request) {
		
		int ret=bookService.insert(bookFormVO, request);
		
		log.debug(result.getAllErrors().toString());
		
		return "redirect:/";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String bookList(Model model) {
		
		model.addAttribute("BODY", "LIST");
		model.addAttribute("LIST", bookService.selectAll());
		
		return "home";
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String updateBook(Model model, @RequestParam long b_id, @ModelAttribute BookVO bookVO) {
		
		model.addAttribute("BODY", "UPDATE");
		model.addAttribute("BOOK", bookService.findByID(b_id));
		
		return "home";
	}
}





























