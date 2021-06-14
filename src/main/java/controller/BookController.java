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

    private final BookService bookService = new BookService();
    private final LectureService lectureService = new LectureService();
    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();

        if(url.equals("/book/list")) {
            ArrayList<Book> books = bookService.findAllBooks();
            for (int i = 0; i < books.size(); i++) {
                System.out.println(books.get(i).toString());
            }
            modelAndView.setViewName("major/booklist");
            modelAndView.getModel().put("books", books);
        }
        else if(url.equals("/book/detail")) {
            String targetId;
            Book booktarget;    Lecture lecturetarget;
            InfoMapping target;
            if(request.getMethod().equals("GET")) {
                modelAndView.setViewName("major/bookdetail");
                targetId = request.getParameter("id");
                booktarget = bookService.findTarget(targetId);
                lecturetarget = lectureService.findTarget(targetId);
                target = new InfoMapping(lecturetarget.getLectureNum(),
                        lecturetarget.getLectureName(),lecturetarget.getMajorName(),
                        lecturetarget.getProfessor(), lecturetarget.getBookNum(), lecturetarget.getGrade(),
                        booktarget.getBookName(), booktarget.getBookAuthor(), booktarget.getBookPub(),
                        booktarget.getBookPrice(), booktarget.getImageURL());
                modelAndView.getModel().put("target", target);
            }
        }
        else {
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return modelAndView;
    }
}
