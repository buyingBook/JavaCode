package service;

import java.util.ArrayList;

import domain.Board;
import domain.BuyBook;
import domain.Member;
import persistence.BoardRepository;
import persistence.MypageRepository;

public class MypageService {
	private final MypageRepository mypageRepository = MypageRepository.getInstacne();
	private final BoardRepository boardRepository = BoardRepository.getInstacne();
	public MypageService() {
		
	}
	
	// 로그인 검증
	public boolean checkLogin(String id, String pwd)
	{
		return mypageRepository.checkLogin(id, pwd);
	}
	
	
	// 개인정보 조회
	public Member displayMyInfo(String id)
	{
		return mypageRepository.getMyInfo(id);
	}
	
	//구매목록 조회
	public ArrayList<BuyBook> displayPurchaseList(String id) {
        return mypageRepository.getPurchaseList(id);
    }
	
	//장바구니 조회
	public ArrayList<BuyBook> displayShoppingList(String id) {
        return mypageRepository.getShoppingList(id);
    }

    //내가쓴 게시글 조회
	public ArrayList<Board> displayWritingList(String id) {
		return boardRepository.findByOwnId(id);
	}
	
}
