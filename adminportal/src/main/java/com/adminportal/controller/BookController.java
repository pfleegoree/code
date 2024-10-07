package com.adminportal.controller;

import com.adminportal.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/add")
    public String addBook(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "addBook";
    }

}
