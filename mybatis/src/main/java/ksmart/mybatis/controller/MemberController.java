package ksmart.mybatis.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart.mybatis.dto.Member;
import ksmart.mybatis.dto.MemberLevel;
import ksmart.mybatis.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	
	//DI (의존성 주입)
	// 3. 생성자 메서드 주입방식
	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	/**
	 * 회원탈퇴화면
	 */
	@GetMapping("/removeMember")
	
	public String removeMember(Model model
			,@RequestParam(name= "memberId", required = false) String memberId
			, @RequestParam(name="result", required = false) String result){
		
		model.addAttribute("title", "회원탈퇴화면");
		model.addAttribute("memberId", memberId);
		if(result != null) model.addAttribute("result", result);
		return "member/removeMember";
		
	}
	
	
	//false : 아이디 중복 true : 아이디 중복 x
	@ResponseBody//전송을 했을때 데이터 응답할때 body 영역에 쓰여져서 응답, json 형식으로 파싱해줌
	@PostMapping("/idCheck")
	public boolean idCheck(@RequestParam(name="memberId") String memberId){
	log.info("id중복체크: {}", memberId);
	
	boolean isIdCheck = true;
	
	Member member = memberService.getMemberInfoById(memberId);
	
	if(member != null) {
		isIdCheck = false;
	
	}
	
	return isIdCheck;
	}
	@PostMapping("/modifyMember")
	public String modifyMember(Member member) {
		
		log.info("수정화면에서 입력받은 data: {}", member);
		
		memberService.modifyMember(member);
		
		return "redirect:/member/memberList";
	}
	
	@GetMapping("/modifyMember")
	public String mofifyMember(@RequestParam(name="memberId", required = false) String memberId
								,Model model) {
		
		log.info("화면에서 입력받은 data: {}", memberId);
		Member member = memberService.getMemberInfoById(memberId);
		List<MemberLevel> memberLevelList = memberService.getMemberLevelList();
		
		model.addAttribute("member", member);
		model.addAttribute("memberLevelList", memberLevelList);
		return "member/modifyMember";
	}
	/*
	 * 커맨드 객체 : http 통신 시에 data(key, value) => DTO(멤버변수 명 일치 시) 자동으로 바인딩 하는 객체
	 * String memberId = request.getParameter("memberId")
	 * Member member = new Member();
	 * member.setMemberId(memberID);
	 * @RequestParam(name="memberId", required, defaultValue, value) String memberId (==) String memberId = request.getParameter("memberId")
	 * @param Member member (커맨드 객체)
	 * @return Controller (String) "redirect:/" == response.sendRedirect("/")
	 * */
	
	@PostMapping("/addMember")
	public String addMember(Member member 
								,@RequestParam(name="memberId", required =false, defaultValue = "id001") String memberId 
								,HttpServletRequest request) {
		log.info("회원가입화면에서 입력한 data : {}", member);
		log.info("회원가입화면에서 입력한 memberId : {}", memberId);
		
		memberService.addMember(member);
		
		return "redirect:/member/memberList";
	}
	
	@GetMapping("/addMember")
	public String addMember(Model model) {
		
		List<MemberLevel> memberLevelList = memberService.getMemberLevelList();
		
		model.addAttribute("memberLevelList", memberLevelList);
		
		return "member/addMember";
	}
	/*
	 *  http://localhost/member/memberList
	 *  @param model
	 * 	@return
	 * */
	
	
	@GetMapping("/memberList")
	public String getMemberList(Model model) {
		
		List<Member> memberList = memberService.getMemberList();
		//log.info("회원 전체 목록: {}", memberList);
		model.addAttribute("memberList", memberList);
		
		return "member/memberList";
	}
}
