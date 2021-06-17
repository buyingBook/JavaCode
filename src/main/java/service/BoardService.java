package service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import domain.Board;
import domain.Member;
import persistence.BoardRepository;

public class BoardService {
    private final BoardRepository boardRepository = BoardRepository.getInstacne();
    public BoardService() {

    }

    public int totalCnt() {
        return boardRepository.totalCount();
    }

    public void write(Board board) {
        boardRepository.save(board);
    }

    public void deleteTarget(String id) {
        boardRepository.delete(Integer.parseInt(id));
    }
    public ArrayList<Board> findBoards() {
        return boardRepository.findAll();
    }
    public ArrayList<Board> findBoards(int idx) {
        return boardRepository.findAll(idx);
    }

    public Board findTarget(String id) {
        System.out.println(id);
        return boardRepository.findById(Integer.parseInt(id));
    }
}
