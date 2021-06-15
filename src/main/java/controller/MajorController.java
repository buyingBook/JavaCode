package controller;

import java.io.IOException;
import java.sql.Date;
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

@WebServlet(name="MajorController", urlPatterns = "/major/*")
public class MajorController extends HttpServlet implements Controller{
    private final MajorService majorService = new MajorService();
    private final BookService bookService = new BookService();
    private final LectureService lectureService = new LectureService();
    private final BuyBookService buyBookService = new BuyBookService();
    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        if(url.equals("/major/list") || url.equals("/major/page")) {
            int totalcnt = majorService.totalcnt();
            System.out.println("totalcount: " + totalcnt);
            PageMaker pm = new PageMaker();
            Criteria cri = new Criteria();
            if(url.equals("/major/page"))
                cri.setPage(Integer.parseInt(request.getParameter("idx")));
            ArrayList<Major> majors = majorService.findAll(cri.getPageStart());
            for(int i = 0; i < majors.size(); i++)
                System.out.println(majors.get(i).toString());
            pm.setCri(cri);
            pm.setTotalCount(totalcnt);
            modelAndView.setViewName("major/majorlist");
            modelAndView.getModel().put("majors", majors);
            modelAndView.getModel().put("pageMaker", pm);
        }

        else if(url.equals("/major/detail")) {
            String id = request.getParameter("id");
            System.out.println(id);
            modelAndView.setViewName("major/bookdetail");
            String name = majorService.findById(id);
        }
//        else if(url.equals("/book/detail")) {
//            System.out.println(request.getMethod());
//            if(request.getMethod().equals("GET")) {
//                String targetId;
//                Book booktarget;    Lecture lecturetarget;  InfoMapping target;
//
//                modelAndView.setViewName("major/bookdetail");
//                targetId = request.getParameter("id");
//                booktarget = bookService.findTarget(targetId);
//                lecturetarget = lectureService.findTarget(targetId);
//                target = new InfoMapping(lecturetarget.getLectureNum(),
//                        lecturetarget.getLectureName(),lecturetarget.getMajorName(),
//                        lecturetarget.getProfessor(), lecturetarget.getBookNum(), lecturetarget.getGrade(),
//                        booktarget.getBookName(), booktarget.getBookAuthor(), booktarget.getBookPub(),
//                        booktarget.getBookPrice(), booktarget.getImageURL());
//                modelAndView.getModel().put("target", target);
//            }
//        }
        else if(url.equals("/book/pay")) {
            int memberId = 1;
            int bookNum = Integer.parseInt(request.getParameter("id"));
            int count = Integer.parseInt(request.getParameter("cnt"));
            int status = Integer.parseInt(request.getParameter("status"));
            Date today = new java.sql.Date(System.currentTimeMillis());

            BuyBook buy = new BuyBook(memberId, bookNum, status, today, count);
            buyBookService.inputInfo(buy);
        }
        else {
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return modelAndView;
    }
}
