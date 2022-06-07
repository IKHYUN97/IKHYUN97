package ksmart.mybatis.service;

import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ksmart.mybatis.dto.Member;
import ksmart.mybatis.dto.MemberLevel;
import ksmart.mybatis.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {
	
	// DI (의존성 주입) 
	// 1. 필드주입방식
	
	/* 
		@Autowired
		private MemberMapper memberMapper;
	 */
	
	// 2. setter 메서드 주입방식 
	
	/*
		@Autowired
		private MemberMapper memberMapper;
		
		public void setMemberMapper(MemberMapper memberMapper) {
			this.memberMapper = memberMapper;
		}
	 */
	
	// 3. 생성자 메서드 주입방식 
	private final MemberMapper memberMapper;
	
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	/*
	 * 
	 * 회원수정
	 * 
	 * */
	public int modifyMember(Member member) {
		
		int result = memberMapper.modifyMember(member);
		
		return result;
	}
	/*
	 * 회원 상세 정보
	 * 
	 * */
	public Member getMemberInfoById(String memberId) {
		
		Member member = memberMapper.getMemberInfoById(memberId);
		
		return member;
	}
	
	
	/*
	 * 회원 가입
	 * 
	 * */
	public int addMember(Member member) {
		
		int result = memberMapper.addMember(member);
		
		return result;
	}
	/*
	 * 회원 등급 목록 조회
	 * 
	 * */
	
	public List<MemberLevel> getMemberLevelList(){
		
		List<MemberLevel> memberLevelList = memberMapper.getMemberLevelList();
		
		return memberLevelList;
	}
	/*
	 * 회원목록조회
	 * @return 회원목록(List<Member>)
	 * */
	
	public List<Member> getMemberList(){
		
		List<Member> memberList = memberMapper.getMemberList();
		/*
		 * 관리자 :1  판매자:2  구매자:3
		 * */
		if(memberList != null) {
			//향상된 for문
			for(Member member : memberList) {
				String memberLevel = member.getMemberLevel();
				if(memberLevel != null) {
					if("1".equals(memberLevel)) {
						member.setMemberLevel("관리자");
					}else if("2".equals(memberLevel)) {
						member.setMemberLevel("판매자");
					}else if("3".equals(memberLevel)) {
						member.setMemberLevel("판매자");
					}else {
						member.setMemberLevel("일반회원");
				}
			}
		}
	}
		return memberList;
	}
}
