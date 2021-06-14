package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.*;
import service.*;
import util.PageMaker;

@WebServlet(name="BookController", urlPatterns = "/book/*")
public class BookController extends HttpServlet implements Controller{

    private final BookService bookService = new BookService();
    private final LectureService lectureService = new LectureService();
    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();

        if(url.equals("/book/list")) {
            int totalcnt = bookService.totalcnt();
            PageMaker pm = new PageMaker();
            Criteria cri = new Criteria();
            ArrayList<Book> books = bookService.findBooks(cri.getPageStart());
            pm.setCri(cri);
            pm.setTotalCount(totalcnt);
            modelAndView.setViewName("major/booklist");
            modelAndView.getModel().put("books", books);
            modelAndView.getModel().put("pageMaker", pm);
        }
        else if(url.equals("/book/page")) {
            int totalcnt = bookService.totalcnt();
            PageMaker pm = new PageMaker();
            Criteria cri = new Criteria();
            cri.setPage(Integer.parseInt(request.getParameter("idx")));
            ArrayList<Book> books = bookService.findBooks(cri.getPageStart());
            pm.setCri(cri);
            pm.setTotalCount(totalcnt);
            modelAndView.setViewName("major/booklist");
            modelAndView.getModel().put("books", books);
            modelAndView.getModel().put("pageMaker", pm);
        }
        else if(url.equals("/book/search")) {
            String major = request.getParameter("major");
            String grade = request.getParameter("grade");
            int totalcnt = bookService.totalcnt(major, grade);
            PageMaker pm = new PageMaker();
            Criteria cri = new Criteria();
            ArrayList<Book> books = bookService.findBooks(cri.getPageStart(), major, grade);
            pm.setCri(cri);
            pm.setTotalCount(totalcnt);
            modelAndView.setViewName("major/booksearchresult");
            modelAndView.getModel().put("books", books);
            modelAndView.getModel().put("pageMaker", pm);

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
