package com.springapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springapp.vo.BoardVO;

@Repository
public class MybatisBoardDAO {
	// CRUD
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// ----------R-------------
	@Transactional
	public List list() {
		return sqlSessionTemplate.selectList("board_ns.selectAllBoards");
	}
	@Transactional
	public BoardVO findBySeq(String seq) {
	
		Map map = new HashMap();
		map.put("seq", seq);// 글번호 맵에 저장		

		return (BoardVO) sqlSessionTemplate.selectOne(
				"board_ns.selectBySeqBoard", map);

	}

	// ------------------------------
	// CUD
	// -----------------------------
	// 글등록
	@Transactional
	public void insert(BoardVO vo) {
		sqlSessionTemplate.insert("board_ns.insertBoard", vo);
	}

	@Transactional
	public void update(BoardVO vo) {
		sqlSessionTemplate.update("board_ns.updateBoard", vo);
	}

	/*
	 * public void delete(String seq) {
	 * sqlMapClientTemplate.delete("board_ns.deleteBoard" ,
	 * Integer.parseInt(seq)); }
	 */
	@Transactional
	public void delete(String seq, String blevel) {
		BoardVO boardVO = new BoardVO();
		boardVO.setSeq(Integer.parseInt(seq));
		boardVO.setBlevel(Integer.parseInt(blevel));
		sqlSessionTemplate.delete("board_ns.deleteBoard", boardVO);
	}

	// ----------------------------------
	@Transactional
	public void insertReply(BoardVO vo) {
		// TODO Auto-generated method stub
		System.out.println("------------------");
		System.out.println(vo.getBref());
		System.out.println(vo.getBstep());
		sqlSessionTemplate.update("board_ns.replyUpdateBoard", vo);
		sqlSessionTemplate.insert("board_ns.insertReplyBoard", vo);

	}
}
