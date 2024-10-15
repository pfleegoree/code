package com.adminportal.controller;

import com.adminportal.domain.Book;  // Importing Book domain object
import com.adminportal.service.BookService;  // Importing Book service
import jakarta.websocket.server.PathParam;
import org.hibernate.sql.ast.tree.expression.ModifiedSubQueryExpression;
import org.springframework.beans.factory.annotation.Autowired;  // For dependency injection
import org.springframework.stereotype.Controller;  // Marks this class as a Spring MVC Controller
import org.springframework.ui.Model;  // Used for adding attributes to the model
import org.springframework.web.bind.annotation.ModelAttribute;  // Binds form data to model object
import org.springframework.web.bind.annotation.RequestMapping;  // Maps URL requests to controller methods
import org.springframework.web.bind.annotation.RequestMethod;  // Defines HTTP methods (GET, POST)
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;  // For handling file uploads

import jakarta.servlet.http.HttpServletRequest;  // Used to access request data (part of Jakarta Servlet API)
import java.io.BufferedOutputStream;  // Output stream for writing image data
import java.io.File;  // Represents file and directory paths
import java.io.FileOutputStream;  // Allows writing to a file
import java.io.IOException;  // Handles input/output exceptions
import java.util.List;  // Used for working with collections (list of books)
import java.util.Optional;

@Controller  // Declares this class as a controller to handle web requests
@RequestMapping("/book")  // Maps requests that start with "/book" to this controller
public class BookController {

    @Autowired  // Injects the BookService bean
    private BookService bookService;

    // Handles GET requests to "/book/add", displays the form for adding a new book
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        Book book = new Book();  // Creates an empty book object
        model.addAttribute("book", book);  // Adds the book object to the model to be used in the form
        return "addBook";  // Returns the "addBook" view
    }

    // Handles POST requests to "/book/add", saves the book and handles image upload
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
        bookService.save(book);  // Saves the book object to the database

        MultipartFile bookImage = book.getBookImage();  // Retrieves the uploaded book image from the form

        try {
            byte[] bytes = bookImage.getBytes();  // Converts the image to a byte array
            String imagePath = "src/main/resources/static/image/book/";  // Directory to store the book images
            File dir = new File(imagePath);  // Creates a File object pointing to the directory

            // Ensure the directory exists, if not create it
            if (!dir.exists()) {
                dir.mkdirs();  // Create directories if they don't exist
            }

            String name = book.getId() + ".png";  // Constructs the image file name using the book ID
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(new File(imagePath + name)));  // Opens a stream to write the image file
            stream.write(bytes);  // Writes the image bytes to the file
            stream.close();  // Closes the stream
        } catch (IOException e) {
            e.printStackTrace();  // Handles any file I/O exceptions
        }

        return "redirect:/book/bookList";  // Redirects to the book list page after saving the book
    }

    // Handles requests to "/book/bookList", retrieves and displays the list of books
    @RequestMapping("/bookList")
    public String bookList(Model model) {
        List<Book> bookList = bookService.findAll();  // Fetches the list of all books from the service
        model.addAttribute("bookList", bookList);  // Adds the book list to the model

        return "bookList";  // Returns the "bookList" view
    }

    @RequestMapping("/bookInfo")
    public String bookInfo(@PathParam("id") Long id, Model model) {

        Optional<Book> bookOptional = bookService.findById(id);
        if (bookOptional.isPresent()) {
            model.addAttribute("book", bookOptional.get());  // Unwrap the Optional here
        } else {
            return "error/bookNotFound";  // Handle the case where the book is not found
        }
        return "bookInfo";
    }

    @RequestMapping("updateBook")
    public String updateBook(@RequestParam("id") Long id, Model model){
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "updateBook";
        }
        return "error/bookNotFound"; // Handle book not found
    }
}
