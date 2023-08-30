package aaa.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aaa.model.ReplyDTO;
import aaa.service.ReplyMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReplyController {
	
	@Resource
	ReplyMapper rMapper;

	@GetMapping("board/BoDetail/{pid}/comments")
	public List<ReplyDTO> reList(@PathVariable int pid) {
		// System.out.println("보냄?");
		// System.out.println(pid);
		return rMapper.reList(pid);
	}
	
	@PostMapping("board/BoDetail/{pid}/comments")
	public Map<String, String> reAdd(
			@RequestBody ReplyDTO rDto) {
		rDto.setGid(rMapper.maxRePid()+1);
		// System.out.println(rDto);
		Map<String, String> msg = new HashMap<>();
		msg.put("msg", "댓글 작성");
		rMapper.insertReply(rDto);
		return msg;
	}
	
	@GetMapping("board/BoDetail/{pid}/comments/{repid}")
	public ReplyDTO reDetail(@PathVariable int repid) {
		// System.out.println("보냄?");
		// System.out.println(pid);
		return rMapper.reDetail(repid);
	}
	
	@PostMapping("board/BoDetail/{pid}/comments/{repid}")
	public Map<String, String> reUpd(
			@RequestBody ReplyDTO rDto, @PathVariable int repid
			){
		// System.out.println(repid);
		// System.out.println(rDto);
		rDto.setRepid(repid);
		rMapper.updateReply(rDto);
		Map<String, String> msg = new HashMap<>();
		msg.put("msg", "댓글 수정");
		return msg;
	}
	
	@PostMapping("board/BoDetail/{pid}/comments/delete/{repid}")
	public Map<String, String> reDel(@PathVariable int repid){
		// System.out.println(repid);
		// System.out.println(rDto);
		rMapper.deleteReply(repid);
		Map<String, String> msg = new HashMap<>();
		msg.put("msg", "댓글 삭제");
		return msg;
	}
	
	@GetMapping("board/BoDetail/{pid}/comments/reply/{repid}")
	public ReplyDTO reReply(@PathVariable int repid) {
		// System.out.println("보냄?");
		// System.out.println(pid);
		return rMapper.reDetail(repid);
	}
	
	@PostMapping("board/BoDetail/{pid}/comments/reply/{repid}")
	public Map<String, String> reReplyAdd(
			@RequestBody ReplyDTO rDto, @PathVariable int repid) {
		// System.out.println("보냄?");
		rDto.setGid(rMapper.reDetail(repid).getGid());
		rMapper.updateReSeq(rDto);
		rDto.setSeq(rDto.getSeq()+1);
		rMapper.insertReReply(rDto);
		System.out.println(rDto);
		Map<String, String> msg = new HashMap<>();
		msg.put("msg", "답글 등록");
		return msg;
	}

}
