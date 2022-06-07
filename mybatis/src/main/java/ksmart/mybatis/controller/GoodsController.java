package ksmart.mybatis.controller;

import org.springframework.stereotype.Controller;

import ksmart.mybatis.dto.Member;

@Controller
public class GoodsController {

	public String goodsController(Member member) {
		
	System.out.println(member.toString());
		
	
		
		
		
		return "/goods/goodsRegForm";
		
		
	}
	
	
}
