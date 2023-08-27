package aaa.model;

import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import lombok.Data;

@Component
@Data
public class PageMapping {
	int pageStart, pageEnd, totalPage, endPage, listStart, listEnd;
	int pageLJump, pageRJump;
	int pageLimit = 5;
	
	@Resource
	BoardDAO bDao;

	// 마지막 페이지 번호
	public int getEndPage() {
		if(getTotalPage() % pageLimit != 0) {
			endPage = getTotalPage()/pageLimit + 1;
		}else {
			endPage = getTotalPage()/pageLimit;
		}
		
		return endPage;
	}

	// 출력 페이지에서 마지막 페이지 번호 할당
	public int getPageEnd() {
		// 기본적으로 5개씩 보여줌
		pageEnd = pageStart + 4;
		
		// 마지막 페이지 번호를 넘어가면 마지막 페이지 번호로 할당
		if(pageEnd > getEndPage()) {
			pageEnd = getEndPage();
		}
		
		return pageEnd;
	}

	// 전체 게시글 개수
	public int getTotalPage() {
		totalPage = bDao.totalPage();
		return totalPage;
	}

	// 게시글 인덱스 시작 번호
	public int getListStart() {
		listStart = (pageStart - 1) * pageLimit;
		return listStart;
	}

	// 게시글 인덱스 끝 번호
	public int getListEnd() {
		listEnd = listStart + 4;
		
		if(pageStart == getEndPage()) {
			listEnd = getTotalPage() - 1;
		}
		
		return listEnd;
	}

	// '<' 페이지 건너뛰기
	public int getPageLJump() {
		pageLJump = pageStart - 1;
		// 페이지 시작번호보다 작아지지 않게 함
		if(pageStart == 1) {
			pageLJump = 1;
		}
		return pageLJump;
	}

	// '>' 페이지 건너뛰기
	public int getPageRJump() {
		pageRJump = pageStart + 1;
		// 마지막 페이지 번호를 넘지 않게 함
		if(pageStart == getPageEnd()) {
			pageRJump = getPageEnd();
		}
		
		return pageRJump;
	}
}
