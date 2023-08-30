package aaa.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import aaa.model.ReplyDTO;

@Mapper
public interface ReplyMapper {
	List<ReplyDTO> reList(int pid);
	void insertReply(ReplyDTO rDto);
	int maxRePid();
	void updateReply(ReplyDTO rDto);
	ReplyDTO reDetail(int repid);
	void deleteReply(int repid);
	void insertReReply(ReplyDTO rDto);
	void updateReSeq(ReplyDTO rDto);
}
