package controller;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.BookService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class BookController {
    private BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }


    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home(HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

    //get Book
    @RequestMapping(value = {"/books"}, method = RequestMethod.GET)
    public ModelAndView displayAllBooks() {
        ModelAndView mv = new ModelAndView();
        List<Book> books = service.getAllBooks();
        mv.addObject("All books", books);
        mv.setViewName("allBooks");
        return mv;
    }

    @RequestMapping(value = {"/addBook"}, method = RequestMethod.GET)
    public ModelAndView displayNewBookForm() {
        ModelAndView mv = new ModelAndView("addBook");
        mv.addObject("Header MESSAGE!!!!!", "ADD BOOK DETAILS");
        mv.addObject("book", new Book());
        return mv;
    }

    @RequestMapping(value = {"/addBook"}, method = RequestMethod.POST)
    public ModelAndView saveNewBook(@ModelAttribute Book book, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/home");
        if (result.hasErrors()) {
            return new ModelAndView("error");
        }
        boolean isAdded = service.saveBook(book);
        if (isAdded) {
            mv.addObject("message", "New Book successfully added");
        } else {
            return new ModelAndView("error");
        }
        return mv;
    }

    @RequestMapping(value = {"/editBook/{id}"}, method = RequestMethod.GET)
    public ModelAndView displayEditForm(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("editBook");
        Book book = service.getBookById(id);
        mv.addObject("headerMessage!!!!!1", "Edit Book Details");
        mv.addObject("book", book);
        return mv;
    }

    @RequestMapping(value = {"/editBook/{id}"}, method = RequestMethod.POST)
    public ModelAndView editBook(@ModelAttribute Book book, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/home");
        if (result.hasErrors()) {
            System.out.println(result.toString());
            return new ModelAndView("error");
        }
        boolean isSaved = service.saveBook(book);
        if (!isSaved) {
            return new ModelAndView("error");
        }
        return mv;
    }

    @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUserById(@PathVariable Long id) {
        boolean isDeleted = service.deleteBook(id);
        System.out.println("DELETED???: " + isDeleted);
        return new ModelAndView("redirect:/home");
    }

}