package controller;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.BookService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }
    @Autowired
    void setBookService(BookService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
    public ModelAndView home(HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }
    //get Book
    @RequestMapping(value = {"/books"},method = RequestMethod.GET)
    public ModelAndView displayAllBooks(){
        ModelAndView mv = new ModelAndView();
        List<Book> books = service.getAllBooks();
        mv.addObject("All books",books);
        return mv;
    }
    //find book by id



}
