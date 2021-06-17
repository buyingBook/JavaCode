package controller;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.*;
import service.*;

@WebServlet(name="MainController", urlPatterns = "/main/*")
public class MainController extends HttpServlet implements Controller{

    private final BoardService boardService = new BoardService();
    private final BookService bookService = new BookService();
    private static Book target;
    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();

        if(url.equals("/main/list")) {
            ArrayList<Book> books = bookService.findBooks(1);
            ArrayList<Board> boards = boardService.findBoards(1);
            modelAndView.setViewName("main");
            modelAndView.getModel().put("books", books);
            modelAndView.getModel().put("boards", boards);
        }
        else {
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return modelAndView;
    }
}
