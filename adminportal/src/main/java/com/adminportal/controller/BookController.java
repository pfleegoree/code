package com.adminportal.controller;

import com.adminportal.domain.Book;
import com.adminportal.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "addBook";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
        bookService.save(book);

        MultipartFile bookImage = book.getBookImage();

        if (!bookImage.isEmpty()) {
            try {
                byte[] bytes = bookImage.getBytes();

                // Update the directory path to an external location
                String imagePath = "/Users/elena/code/adminportal/src/main/resources/static/image/book/";

                File dir = new File(imagePath);
                if (!dir.exists()) {
                    dir.mkdirs(); // Create the directory if it doesn't exist
                }

                String name = book.getId() + ".png"; // Image file name based on the book's ID
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(imagePath + name)));
                stream.write(bytes); // Write the image bytes to the file
                stream.close(); // Close the output stream
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/book/bookList";
    }

    @RequestMapping("/bookList")
    public String bookList(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "bookList";
    }

    @RequestMapping("/bookInfo")
    public String bookInfo(@RequestParam("id") Long id, Model model) {
        Optional<Book> bookOptional = bookService.findById(id);
        if (bookOptional.isPresent()) {
            model.addAttribute("book", bookOptional.get());
        } else {
            return "error/bookNotFound";
        }
        return "bookInfo";
    }

    @RequestMapping("/updateBook")
    public String updateBook(@RequestParam("id") Long id, Model model) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "updateBook";
        }
        return "error/bookNotFound";
    }

    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public String updateBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
        bookService.save(book);
        MultipartFile bookImage = book.getBookImage();

        if (!bookImage.isEmpty()) {
            try {
                byte[] bytes = bookImage.getBytes();

                // Update the directory path to an external location
                String imagePath = "/Users/elena/code/adminportal/src/main/resources/static/image/book/";

                File dir = new File(imagePath);
                if (!dir.exists()) {
                    dir.mkdirs(); // Create the directory if it doesn't exist
                }

                String name = book.getId() + ".png";
                Files.deleteIfExists(Paths.get(imagePath + name)); // Delete the old image if it exists

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(imagePath + name)));
                stream.write(bytes); // Write the new image
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/book/bookInfo?id=" + book.getId();
    }
}
