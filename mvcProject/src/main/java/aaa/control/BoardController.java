package aaa.control;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.BoardDTO;
import aaa.model.FileUploadDownload;
import aaa.model.PageMapping;
import aaa.model.ReplyDTO;
import aaa.service.BoardMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("board")
public class BoardController {
	// DAO(MyBatis의 Mapper)
	@Resource
	BoardMapper mapper;
	
	// 페이지 처리 클래스
	@Autowired
	PageMapping pmp;
	
	// 파일 업로드, 다운로드 클래스
	@Resource
	FileUploadDownload fud;
	
	// 페이지 처리 Attribute
	@ModelAttribute("page")
	Object boPage() {
		return pmp;
	}
	
	// 게시판 목록 List
	@ModelAttribute("list")
	Object boList() {
		return mapper.list();
	}
	
	// 게시판 상세보기 DTO
	@ModelAttribute("detail")
	Object boDetail(
			@PathVariable(required = false) String pid) {
		BoardDTO bDto = null;
		if(pid != null) {
			bDto = mapper.detail(Integer.parseInt(pid));
		}else {
			bDto = mapper.detail(1);
		}
		return bDto;
	}
	
	// 게시글 작성 처리
	@PostMapping("BoWrite")
	String boWrite(
			BoardDTO bDto,
			PageMapping pmp) {
		// System.out.println(bDto);
		// 저장할 파일제목
		// System.out.println(mapper.maxPid());
		bDto.setRid(mapper.maxPid()+1);
		// System.out.println(bDto.getRid());
		bDto.setUpfile(bDto.getMf().getOriginalFilename());
		if(!bDto.getUpfile().equals("")) {
			fud.fileSave(bDto.getMf()); // 파일 저장
		}
		mapper.insert(bDto); // DB에 반영
		pmp.setMsg("게시글 작성");
		pmp.setUrl("BoList");
		return "board/inc/alert";
	}
	
	// 게시글 삭제 처리
	@PostMapping("BoDelete")
	String boDelete(
			BoardDTO bDto,
			PageMapping pmp) {
		System.out.println(bDto);
		String path = "D:\\assignment_Spring\\mvcProject\\src\\main\\webapp\\up";
		pmp.setMsg("비밀번호 틀림");
		pmp.setUrl("BoDelete/"+bDto.getPid());
		int result = mapper.delete(bDto);
		if(result > 0) {
			new File(path+"\\"+bDto.getUpfile()).delete();
			pmp.setMsg("게시글 삭제");
			pmp.setUrl("BoList");
		}
		return "board/inc/alert";
	}
	
	// 게시글 수정 처리
	@PostMapping("BoModify")
	String boModify(
			BoardDTO bDto,
			PageMapping pmp) {
		pmp.setMsg("비밀번호 틀림");
		pmp.setUrl("BoModify/"+bDto.getPid());
		bDto.setUpfile(bDto.getMf().getOriginalFilename());
		// System.out.println(bDto);
		if(!bDto.getUpfile().equals("")) { // 파일이 있을 때
			// 저장할 파일제목
			fud.fileSave(bDto.getMf()); // 파일 저장
		}
		int result = mapper.modify(bDto);
		if(result > 0) { // 게시글 번호, 암호 일치 확인
			pmp.setMsg("게시글 수정");
			pmp.setUrl("BoDetail/" + bDto.getPid());
		}
		return "board/inc/alert";
	}
	
	@PostMapping("BoReply")
	String boReply(
			BoardDTO bDto,
			PageMapping pmp) {
		System.out.println(bDto);
		mapper.updateSeq(bDto);
		mapper.insertReply(bDto);
		pmp.setMsg("게시글 작성");
		pmp.setUrl("BoList");
		return "board/inc/alert";
	}
	
	// 페이지 번호, 게시글 번호 PathVariable로 받아 처리
	@RequestMapping("{menu}/{pid}")
	String boardDetail(
			BoardDTO bDto,
			ReplyDTO rDto,
			@PathVariable String menu,
			@PathVariable String pid) {
		// System.out.println("일반경로");
		if(menu.equals("BoDetail")) { // 상세보기로 진입시 게시글 번호로 인식
			mapper.cntUp(Integer.parseInt(pid)); // 조회수 증가
		}else if(menu.equals("BoList")) { // 게시글 목록으로 진입시 페이지 번호로 인식
			// System.out.println("진입 " + pid);
			if(pid != null) {
				pmp.setPageStart(Integer.parseInt(pid)); // 페이지 시작 번호 할당
				// System.out.println(pmp.getPageNum());
			}
		}
		return "board/templates";
	}
	
	@RequestMapping("{menu}")
	String boardHome(
			BoardDTO bDto,
			@PathVariable String menu) {
		pmp.setPageStart(1); // 게시글 목록 페이지 진입시 최초 페이지 번호 1
		// System.out.println(mapper.totalPage());
		return "board/templates";
	}
	
	// 파일 다운로드
	@RequestMapping("{menu}/{pid}/{fileName}")
	void down(@PathVariable String fileName, HttpServletResponse response) {
		fud.download(fileName, response);
	}
	
	// 게시글 수정 시 파일 삭제
	@RequestMapping("modiDel")
	String modiDel(BoardDTO bDto, PageMapping pmp) {
		String path = "D:\\assignment_Spring\\mvcProject\\src\\main\\webapp\\up";
		// System.out.println(bDto);
		// session을 통해 로그인 시 게시글 수정을 할 수 있게 할 생각으로
		// 암호와 게시글 번호 일치 확인을 하지 않음
		new File(path+"\\"+bDto.getUpfile()).delete();
		mapper.fileDelete(bDto);
		pmp.setMsg("파일 삭제");
		pmp.setUrl("BoModify/" + bDto.getPid());
		return "board/inc/alert";
	}
}
