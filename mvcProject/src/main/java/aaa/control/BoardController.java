package aaa.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.BoardDAO;
import aaa.model.BoardDTO;
import aaa.model.PageMapping;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("board")
public class BoardController {
	// DAO
	@Autowired
	BoardDAO bDao;
	
	// 페이지 처리 클래스
	@Autowired
	PageMapping pmp;
	
	// 페이지 처리 Attribute
	@ModelAttribute("page")
	Object boPage() {
		return pmp;
	}
	
	// 게시판 목록 List
	@ModelAttribute("list")
	Object boList() {
		return bDao.list();
	}
	
	// 게시판 상세보기 DTO
	@ModelAttribute("detail")
	Object boDetail(@PathVariable(name = "pid", required = false) String pid) {
		BoardDTO bDto = null;
		
		// 게시글 번호를 PathVariable로 받아 해당하는 게시글 조회
		if(pid != null) {
			bDto = bDao.detail(Integer.parseInt(pid));
		}
		return bDto;
	}
	
	// 게시글 작성 처리
	@PostMapping("BoWrite")
	String boWrite(
			Model md,
			BoardDTO bDto) {
		// System.out.println(bDto);
		fileSave(bDto); // 파일 저장
		bDao.write(bDto); // DB에 반영
		md.addAttribute("msg", "게시글 작성");
		md.addAttribute("url", "BoList");
		return "board/inc/alert";
	}
	
	// 게시글 삭제 처리
	@PostMapping("BoDelete")
	String boDelete(
			Model md,
			BoardDTO bDto) {
		// System.out.println(bDto);
		if(bDao.idPwChk(bDto)) { // 게시글 번호, 암호 일치 확인
			bDao.delete(bDto); // DB 게시글 삭제
			md.addAttribute("msg", "게시글 삭제");
			md.addAttribute("url", "BoList");
		}else {
			md.addAttribute("msg", "비밀번호 틀림");
			md.addAttribute("url", "BoDelete/" + bDto.getPid());
		}
		return "board/inc/alert";
	}
	
	// 게시글 수정 처리
	@PostMapping("BoModify")
	String boModify(
			Model md,
			BoardDTO bDto) {
		// System.out.println(bDto);
		if(bDao.idPwChk(bDto)) { // 게시글 번호, 암호 일치 확인
			if(bDto.getMf() != null) { // 파일이 있을 때
				fileSave(bDto); // 파일 저장
			}
			
			bDao.update(bDto); // 게시글 DB 수정
			md.addAttribute("msg", "게시글 수정");
			md.addAttribute("url", "BoDetail/" + bDto.getPid());
		}else {
			md.addAttribute("msg", "비밀번호 틀림");
			md.addAttribute("url", "BoModify/" + bDto.getPid());
		}
		return "board/inc/alert";
	}
	
	// 페이지 번호, 게시글 번호 PathVariable로 받아 처리
	@RequestMapping("{menu}/{pid}")
	String boardDetail(
			BoardDTO bDto,
			@PathVariable String pid,
			@PathVariable String menu) {
		// System.out.println("일반경로");
		if(menu.equals("BoDetail")) { // 상세보기로 진입시 게시글 번호로 인식
			bDao.cntUp(Integer.parseInt(pid));
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
		return "board/templates";
	}
	
	// 파일저장
	void fileSave(BoardDTO bDto) {
		String path = "D:\\assignment_Spring\\mvcProject\\src\\main\\webapp\\up";
		String ptn = ".";
		String ptn2 = null;
		String ptn3 = ".* \\(1\\)$";
		String fName = bDto.getMf().getOriginalFilename();
		File ff = new File(path+"\\"+fName);
		
		try {
			String rename = null;
			String exe = null;
			
			int i = 1;
			while(ff.exists()) { // 중복 확인
				// 확장자 앞 파일 제목
				rename = fName.substring(0, fName.lastIndexOf(ptn));
				// 확장자
				exe = fName.substring(fName.lastIndexOf(ptn), fName.length());
				boolean checkFile = Pattern.matches(ptn3, rename);
				
				// 새로고침했을 때 반복된 파일업로드 고려(실제로 새로고침을 해도 파일이 올라가지 않게
				// 막을테니 큰 의미 없다고 생각)
				if(!checkFile && i==1) {
					rename += " (1)";
					fName = rename + exe;
					ff = new File(path+"\\"+fName);
					continue;
				}
				
				ptn2 = rename.substring(rename.length()-(3+(i+"").length()));
				
				while(true) {
					if(ptn2.equals(" (" + i + ")")) {
						i++;
					}else {
						if(i > 1) {
							rename = rename.replace(ptn2, (" (" + i + ")"));
							fName = rename + exe;
							break;
						}
					}
					
				}
				
				ff = new File(path+"\\"+fName);
			}
			
			FileOutputStream fos = new FileOutputStream(ff);
			fos.write(bDto.getMf().getBytes());
			bDto.setUpfile(fName); // DB에 입력될 실제 파일 제목(중복처리 후)
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 파일 다운로드
	@RequestMapping("{menu}/{pid}/{fileName}")
	void download(@PathVariable String fileName, HttpServletResponse response) {
		String path = "D:\\assignment_Spring\\mvcProject\\src\\main\\webapp\\up";
		
		try {
			// 다운로드 할 파일 제목을 PathVariable로 받음
			FileInputStream fis = new FileInputStream(path+"\\"+fileName);
			String encName = URLEncoder.encode(fileName, "utf-8");
			response.setHeader("Content-Disposition", "attachment;filename="+encName);
			
			ServletOutputStream sos = response.getOutputStream();
			byte[] buf = new byte[1024];
			
			while(fis.available() > 0) {
				int len = fis.read(buf);
				sos.write(buf, 0, len);
			}
			sos.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 게시글 수정 시 파일 삭제
	@RequestMapping("modiDel")
	String modiDel(Model md, BoardDTO bDto) {
		String path = "D:\\assignment_Spring\\mvcProject\\src\\main\\webapp\\up";
		// System.out.println(bDto);
		
		// session을 통해 로그인 시 게시글 수정을 할 수 있게 할 생각으로
		// 암호와 게시글 번호 일치 확인을 하지 않음
		new File(path+"\\"+bDto.getUpfile()).delete();
		bDao.fileDelete(bDto);
		
		md.addAttribute("msg", "파일 삭제");
		md.addAttribute("url", "BoModify?pid=" + bDto.getPid());
		return "board/inc/alert";
	}
}
