package ksmart.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart.mybatis.dto.Member;
import ksmart.mybatis.dto.MemberLevel;

@Mapper
public interface MemberMapper {
	// 로그인 이력 조회 (페이징)
	public List<Map<String,Object>> getLoginHistory(Map<String,Object> paramMap);
	
	// 로그인 이력테이블 총 row(튜플)수
	public int getLoginHistoryCount();
	
	// 회원 목록조회(복잡한 결과 맵핑 has one 관계 : association)
	public List<Member> getMemberInfoList();
	
	// 판매자 목록조회(복잡한 결과 맵핑 has a many 관계)
	public List<Member> getSellerInfoList();
	
	// 회원 검색
	public List<Member> getSearchMemberList(String searchKey, String searchValue);
	
	//tb_order (상품코드에 연관된 튜플 삭제) - 판매자
	public int removeOrderByGCode(String memberId);
	
	//tb_goods (판매자 등록한 상품 목록 삭제) - 판매자
	public int removeGoodsById(String memberId);
	
	//tb_order (구매자 구매한 주문내역 삭제) - 구매자
	public int removeOrderById(String memberId);
	
	//tb_login (회원이 로그인 이력 삭제) - 회원
	public int removeLoginHistoryById(String memberId);
	
	//tb_member (회원 탈퇴) - 회원
	public int removeMemberById(String memberId);
	
/*	
	// 상품 코드에 따른 구매 이력 삭제
	public int removeOrderBySellerId(String memberId);
	
	// 판매자가 등록한 상품 삭제
	public int removeGoodsBySellerId(String memberId);
	
	// 구매자가 구매한 이력 삭제
	public int removeOrder(String memberId);
	
	// 회원 로그인 이력 삭제
	public int removeLoginHistory(String memberId);
	
	// 회원 삭제
	public int removeMember(String memberId); */
	
	// 회원 수정
	public int modifyMember(Member member);
	
	// 회원 상세정보 조회
	public Member getMemberInfoById(String memberId);
	
	// 회원 등록
	public int addMember(Member member);
	
	// 회원목록조회
	public List<Member> getMemberList();
	
	// 회원등급조회
	public List<MemberLevel> getMemberLevelList();
}
