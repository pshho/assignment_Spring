package aaa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class BoardDAO {
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	BoardDTO bDto;
	
	// application.yaml에 입력한 데이터베이스 연결 정보를 바탕으로 만들어진
	// DataSource를 bean으로 당겨옴
	@Autowired
	DataSource dataSource;
	
	// 연결 닫기
	public void close() {
		if(con != null) {try { con.close(); } catch(Exception e) {}};
		if(ptmt != null) {try { ptmt.close(); } catch(Exception e) {}};
		if(rs != null) {try { rs.close(); } catch(Exception e) {}};
	}
	
	// 게시글 목록
	public List<BoardDTO> list(){
		sql = "select * from board";
		List<BoardDTO> bList = new ArrayList<>();
		
		try {
			con = dataSource.getConnection();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				bDto = new BoardDTO();
				bDto.setPid(rs.getInt("pid"));
				bDto.setTitle(rs.getString("title"));
				bDto.setWriter(rs.getString("writer"));
				bDto.setPw(rs.getString("pw"));
				bDto.setUpfile(rs.getString("upfile"));
				bDto.setContent(rs.getString("content"));
				bDto.setReg_date(rs.getTimestamp("reg_date"));
				bDto.setCnt(rs.getInt("cnt"));
				bDto.setSeq(rs.getInt("seq"));
				bDto.setLev(rs.getInt("lev"));
				bDto.setRid(rs.getInt("rid"));
				
				bList.add(bDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return bList;
	}
	
	// 게시글 상세보기
	public BoardDTO detail(int pid) {
		sql = "select * from board where pid = ?";
		
		try {
			con = dataSource.getConnection();
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, pid);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				bDto = new BoardDTO();
				bDto.setPid(rs.getInt("pid"));
				bDto.setTitle(rs.getString("title"));
				bDto.setWriter(rs.getString("writer"));
				bDto.setPw(rs.getString("pw"));
				bDto.setUpfile(rs.getString("upfile"));
				bDto.setContent(rs.getString("content"));
				bDto.setReg_date(rs.getTimestamp("reg_date"));
				bDto.setCnt(rs.getInt("cnt"));
				bDto.setSeq(rs.getInt("seq"));
				bDto.setLev(rs.getInt("lev"));
				bDto.setRid(rs.getInt("rid"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return bDto;
	}
	
	// 게시글 작성
	public void write(BoardDTO bDto) {
		sql = "insert into board(title, writer, pw, content, upfile, cnt, seq, lev, rid) "
				+ "values(?, ?, ?, ?, ?, 0, 0, 0, 0)";
		
		try {
			con = dataSource.getConnection();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, bDto.getTitle());
			ptmt.setString(2, bDto.getWriter());
			ptmt.setString(3, bDto.getPw());
			ptmt.setString(4, bDto.getContent());
			ptmt.setString(5, bDto.getUpfile());
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	// 조회수 증가
	public void cntUp(int pid) {
		sql = "update board set cnt = cnt + 1 where pid = ?";
		
		try {
			con = dataSource.getConnection();
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, pid);
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	// 게시글 번호, 암호 확인
	public boolean idPwChk(BoardDTO bDto) {
		sql = "select * from board where pid = ? and pw = ?";
		boolean ck = false;
		
		try {
			con = dataSource.getConnection();
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, bDto.getPid());
			ptmt.setString(2, bDto.getPw());
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				ck = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return ck;
	}
	
	// 게시글 삭제
	public void delete(BoardDTO bDto) {
		sql = "delete from board where pid = ?";
		
		try {
			con = dataSource.getConnection();
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, bDto.getPid());
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	// 게시글 수정
	public void update(BoardDTO bDto) {
		sql = "update board set title = ?, content = ?, upfile = ? where pid = ?";
		
		try {
			con = dataSource.getConnection();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, bDto.getTitle());
			ptmt.setString(2, bDto.getContent());
			ptmt.setString(3, bDto.getUpfile());
			ptmt.setInt(4, bDto.getPid());
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	// 게시글 수정 시 파일 삭제하고 재업로드할 때 DB 변경
	public void fileDelete(BoardDTO bDto) {
		sql = "update board set upfile = '' where pid = ?";
		
		try {
			con = dataSource.getConnection();
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, bDto.getPid());
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	// 페이지 처리를 위한 게시글 총 개수 검색
	public int totalPage() {
		sql = "select count(*) from board";
		int res = 0;
		
		try {
			con = dataSource.getConnection();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				res = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
}
