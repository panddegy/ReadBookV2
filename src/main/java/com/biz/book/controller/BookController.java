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
	public String writeBook(Model model, @ModelAttribute BookVO bookVO) {
		
		model.addAttribute("BODY", "WRITE");
		model.addAttribute("SUBTITLE", "Write");
		
		return "home";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String writeBook(Model model, @ModelAttribute @Valid BookVO bookVO, BindingResult result, MultipartHttpServletRequest request) {
		
		bookService.insert(bookVO, request);
		
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
		model.addAttribute("bookVO", bookService.findByID(b_id));
		model.addAttribute("SUBTITLE", "Update");
		
		return "home";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updateBook(Model model, @ModelAttribute BookVO bookVO, BindingResult result, MultipartHttpServletRequest request) {
		
		bookService.update(bookVO, request);
		log.debug(result.getAllErrors().toString());
		
		return "redirect:/";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String deleteBook(Model model, @RequestParam long b_id) {
		
		bookService.delete(b_id);
		
		return "redirect:/";
	}
}





























