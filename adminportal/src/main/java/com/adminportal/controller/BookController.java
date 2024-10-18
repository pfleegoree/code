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

@Controller  // Declares this class as a Spring MVC controller to handle web requests.
@RequestMapping("/book")  // Maps all requests that start with "/book" to this controller.
public class BookController {

    @Autowired  // Automatically injects the BookService bean to manage book-related operations.
    private BookService bookService;

    // Handles GET requests to "/book/add", displays the form to add a new book.
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        Book book = new Book();  // Creates an empty Book object to bind form data.
        model.addAttribute("book", book);  // Adds the empty Book object to the model for the form.
        return "addBook";  // Returns the "addBook" view (Thymeleaf template).
    }

    // Handles POST requests to "/book/add", saves the book details and uploads the book image.
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
        bookService.save(book);  // Saves the book object to the database.

        MultipartFile bookImage = book.getBookImage();  // Retrieves the uploaded book image from the form.

        if (!bookImage.isEmpty()) {  // Checks if the image is not empty.
            try {
                byte[] bytes = bookImage.getBytes();  // Converts the uploaded image into a byte array.

                // Specifies the directory path to save the book images.
                String imagePath = "/Users/elena/code/adminportal/src/main/resources/static/image/book/";

                File dir = new File(imagePath);  // Creates a File object for the directory.
                if (!dir.exists()) {
                    dir.mkdirs();  // Creates the directory if it does not exist.
                }

                String name = book.getId() + ".png";  // Constructs the image file name using the book's ID.
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(imagePath + name)));  // Opens a stream to write the image file.
                stream.write(bytes);  // Writes the image bytes to the file.
                stream.close();  // Closes the stream after writing the file.
            } catch (IOException e) {
                e.printStackTrace();  // Handles any file I/O exceptions.
            }
        }

        return "redirect:/book/bookList";  // Redirects the user to the book list page after saving.
    }

    // Handles requests to "/book/bookList", retrieves and displays a list of all books.
    @RequestMapping("/bookList")
    public String bookList(Model model) {
        List<Book> bookList = bookService.findAll();  // Fetches all the books from the service.
        model.addAttribute("bookList", bookList);  // Adds the list of books to the model.
        return "bookList";  // Returns the "bookList" view (Thymeleaf template).
    }

    // Handles requests to display information about a specific book.
    @RequestMapping("/bookInfo")
    public String bookInfo(@RequestParam("id") Long id, Model model) {
        Optional<Book> bookOptional = bookService.findById(id);  // Retrieves the book by its ID.
        if (bookOptional.isPresent()) {
            model.addAttribute("book", bookOptional.get());  // If the book exists, add it to the model.
        } else {
            return "error/bookNotFound";  // If the book is not found, return an error page.
        }
        return "bookInfo";  // Returns the "bookInfo" view (Thymeleaf template).
    }

    // Handles GET requests to update an existing book.
    @RequestMapping("/updateBook")
    public String updateBook(@RequestParam("id") Long id, Model model) {
        Optional<Book> book = bookService.findById(id);  // Retrieves the book by its ID.
        if (book.isPresent()) {
            model.addAttribute("book", book.get());  // If the book exists, add it to the model for editing.
            return "updateBook";  // Returns the "updateBook" view (Thymeleaf template).
        }
        return "error/bookNotFound";  // If the book is not found, return an error page.
    }

    // Handles POST requests to update the book's details and image.
    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public String updateBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
        bookService.save(book);  // Updates the book object in the database.

        MultipartFile bookImage = book.getBookImage();  // Retrieves the uploaded book image from the form.

        if (!bookImage.isEmpty()) {  // Checks if the image is not empty.
            try {
                byte[] bytes = bookImage.getBytes();  // Converts the uploaded image into a byte array.

                // Specifies the directory path to save the book images.
                String imagePath = "/Users/elena/code/adminportal/src/main/resources/static/image/book/";

                File dir = new File(imagePath);  // Creates a File object for the directory.
                if (!dir.exists()) {
                    dir.mkdirs();  // Creates the directory if it does not exist.
                }

                String name = book.getId() + ".png";  // Constructs the image file name using the book's ID.
                Files.deleteIfExists(Paths.get(imagePath + name));  // Deletes the old image file if it exists.

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(imagePath + name)));  // Opens a stream to write the new image file.
                stream.write(bytes);  // Writes the new image bytes to the file.
                stream.close();  // Closes the stream after writing the file.
            } catch (IOException e) {
                e.printStackTrace();  // Handles any file I/O exceptions.
            }
        }

        return "redirect:/book/bookInfo?id=" + book.getId();  // Redirects the user to the book's info page after updating.
    }
}
