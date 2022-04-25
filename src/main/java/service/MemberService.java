package service;

import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberService {
	public static final int JOIN_SUCCESS = 201;
	public static final int JOIN_FAIL = 409;
	
	public int join(MemberDTO newMemberInfo) {		
		
		// 회원 가입 처리
		MemberDAO dao = new MemberDAO();
		
		boolean result = dao.insertMemberInfo(newMemberInfo);
		
		// 회원가입 처리 결과 반환
		// 회원 가입 성공 : 200 반환
		// 회원 가입 실패 : 
		// 1. 이미 사용 중인 아이디 : 409 반환
		
		if(result) {
			return HttpServletResponse.SC_CREATED;
		} else {
			return HttpServletResponse.SC_CONFLICT;
		} // if문 끝		
	}
	
	public boolean login(MemberDTO memberDto) {
		// 로그인 처리
		MemberDAO dao = new MemberDAO();
		
		MemberDTO selectedMemberDTO = dao.selectMemberInfo(memberDto);
		
		if (selectedMemberDTO == null) {
			return false;
		} else {
			return true;
		}
				
	}
}
