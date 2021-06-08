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

@WebServlet(name="BookController", urlPatterns = "/book/*")
public class BookController extends HttpServlet implements Controller{

    private final BookService boardService = new BookService();
    private static Book target;
    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();

        if(url.equals("/book/list")) {
            if(request.getMethod().equals("GET")) {
                modelAndView.setViewName("major/booklist");
            }

        }
        else if(url.equals("/book/detail")) {
            if(request.getMethod().equals("GET")) {
                modelAndView.setViewName("major/bookdetail");
            }
            else if(request.getMethod().equals("POST")) {

            }
        }
        else {
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return modelAndView;
    }
}
