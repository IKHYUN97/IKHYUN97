package ksmart.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ksmart.mybatis.dto.Member;
import ksmart.mybatis.dto.MemberLevel;

@Mapper
public interface MemberMapper {
	
	//회원 삭제
	public Member removeMember(Member member);
	
	//회원 수정 
	public int modifyMember(Member member);
	
	//회원 상세정보 조회
	public Member getMemberInfoById(String memberId); 
	
	//회원등록
	public int addMember(Member member); 
	
	// 회원목록조회
	public List<Member> getMemberList();
	
	//회원등급 조회
	public List<MemberLevel> getMemberLevelList();
}
