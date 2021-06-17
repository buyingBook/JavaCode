package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Board;
import domain.Criteria;
import domain.Major;
import domain.Member;
import service.BoardService;
import util.PageMaker;

import static java.time.LocalTime.now;

@WebServlet(name="BoardController", urlPatterns = "/board/*")
public class BoardController extends HttpServlet implements Controller{

    private final BoardService boardService = new BoardService();
    private static Board target;
    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();

        if(url.equals("/board/list") || url.equals("/board/page")) {
            int totalcnt = boardService.totalCnt();
            System.out.println("totalcount: " + totalcnt);
            PageMaker pm = new PageMaker();
            Criteria cri = new Criteria(10);
            if(url.equals("/board/page"))
                cri.setPage(Integer.parseInt(request.getParameter("idx")));
            ArrayList<Board> boards = boardService.findBoards(cri.getPageStart());
            for(int i = 0; i < boards.size(); i++)
            pm.setCri(cri);
            pm.setTotalCount(totalcnt);
            modelAndView.setViewName("/board/board-list");
            modelAndView.getModel().put("boards", boards);
            modelAndView.getModel().put("pageMaker", pm);
        }
        else if(url.equals("/board/write")) {
            if(request.getMethod().equals("GET")) {
                modelAndView.setViewName("board/board-form");
            }
            else if(request.getMethod().equals("POST")) {
                Board board= new Board();
                if(request.getParameter("writer").equals(""))
                    board.setWriter((String)request.getSession().getAttribute("id"));
                else
                    board.setWriter(request.getParameter("writer"));
                board.setTitle(request.getParameter("title"));
                board.setContents(request.getParameter("contents"));
                board.setRegdate(new java.sql.Date(System.currentTimeMillis()));
                board.setHit(0);
                boardService.write(board);
                f5(modelAndView);
            }
        }
        else if(url.equals("/board/detail")) {
            String targetId;
            Board target;
            if(request.getMethod().equals("GET")) {
                modelAndView.setViewName("board/board-detail");
                targetId = request.getParameter("id");
                target = boardService.findTarget(targetId);
                modelAndView.getModel().put("target", target);
            }
        }
        else if(url.equals("/board/detail/delete")) {
            String targetId;
            if(request.getMethod().equals("POST")) {
                modelAndView.setViewName("board/board-detail");
                targetId = request.getParameter("id");
                boardService.deleteTarget(targetId);
                f5(modelAndView);
            }
        }
        else {
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return modelAndView;
    }

    public void f5(ModelAndView mv) {
        int totalcnt = boardService.totalCnt();
        PageMaker pm = new PageMaker();
        Criteria cri = new Criteria(10);
        ArrayList<Board> boards = boardService.findBoards(cri.getPageStart());
        pm.setCri(cri);
        pm.setTotalCount(totalcnt);
        mv.setViewName("/board/board-list");
        mv.getModel().put("boards", boards);
        mv.getModel().put("pageMaker", pm);
    }
}
