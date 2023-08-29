package aaa.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import aaa.model.BoardDTO;

@Mapper
public interface BoardMapper {
	List<BoardDTO> list();
	BoardDTO detail(int pid);
	void insert(BoardDTO bDto);
	int delete(BoardDTO bDto);
	int modify(BoardDTO bDto);
	void cntUp(int pid);
	int totalPage();
	int maxPid();
	void fileDelete(BoardDTO bDto);
	void insertReply(BoardDTO bDto);
	void updateSeq(BoardDTO bDto);
	int maxSeq();
	int countSeq();
}
