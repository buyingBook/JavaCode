package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Board;
import domain.BuyBook;
import domain.Member;
import service.MypageService;

@WebServlet(name="MypageController", urlPatterns = "/mypage/*")
public class MypageController extends HttpServlet implements Controller{

    private final MypageService mypageService = new MypageService();
    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        
        
        //마이페이지 요청
        if(url.equals("/mypage")) {
        	
        	System.out.println("마이페이지 요청");
        	
        	if (request.getSession().getAttribute("id") == null )
        	{
        		System.out.println("세션 로그인 없음");
        		System.out.println("페이지 띄움");
        		modelAndView.setViewName("mypage/login");
        	}
        	else
        	{
        		System.out.println("세션 로그인 감지");
            	String id = (String) request.getSession().getAttribute("id");
            	
            	System.out.println("세션 로그인 : " + id);
            	
     			Member member = new Member();
     			member = mypageService.displayMyInfo(id);
     			
     			ArrayList<BuyBook> purchaseList = mypageService.displayPurchaseList(id);
     			ArrayList<BuyBook> shoppingList = mypageService.displayShoppingList(id);
     			ArrayList<Board> writingList = mypageService.displayWritingList(id);
     			
     			modelAndView.setViewName("mypage/mypage");
     			modelAndView.getModel().put("member", member);
     			modelAndView.getModel().put("purchaseLists", purchaseList);
     			modelAndView.getModel().put("shoppingLists", shoppingList);
        		modelAndView.getModel().put("writingLists", writingList);
        	}
        	
 			
		}
        else if(url.equals("/mypage/check"))	// 로그인 검증
        {
        	
        	String userid = request.getParameter("id");
        	String userpwd = request.getParameter("pwd");
    		System.out.println(userid);
    		System.out.println(userpwd);
    		
    		if ( mypageService.checkLogin(userid, userpwd) ) // 아이디 비번 맞으면 true 
    		{
    			System.out.println("로그인 성공");
    			request.getSession().setAttribute("id", userid); //session에 등록
    			modelAndView.setViewName("main");
    		}
    		else
    		{
    			System.out.println("로그인 실패");
    			modelAndView.setViewName("mypage/login");
    		}
    		
        }
        else if(url.equals("/mypage/logout")) {
			HttpSession userSession = request.getSession();
			userSession.invalidate();
			modelAndView.setViewName("main");
		}
        else {
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return modelAndView;
    }
}
