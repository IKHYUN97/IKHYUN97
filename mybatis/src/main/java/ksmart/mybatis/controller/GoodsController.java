package ksmart.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart.mybatis.dto.Goods;
import ksmart.mybatis.service.GoodsService;




//@RequestMapping의 의미 : /goods 안써도 공통ㅇ드로 쓰게 해줌

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);
	
	public GoodsService goodsService;
	
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	@PostMapping("/addGoods")
	public String addGoods(Goods goods) {
				
		log.info("상품 등록 화면에서 입력받은 데이터 : {}", goods);
		
		goodsService.addGoods(goods);
		
		return "redirect:/goods/goodsList";
	}
	
	@GetMapping("/addGoods")
	public String addGoods(Model model) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		List<Goods> goodsList = goodsService.getGoodsList(paramMap);
		
		model.addAttribute("goodsList", goodsList);
		
		return "goods/addGoods";
	}
	
	@GetMapping("/goodsList")
	public String getGoodsList(Model model, HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionLevel = (String) session.getAttribute("SLEVEL");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		if(sessionId != null && sessionLevel.equals("2")) {
			paramMap.put("memberId", sessionId);
		}
		
		List<Goods> goodsList = goodsService.getGoodsList(paramMap);
		
		log.info("상품 목록 조회 goodsList : {}", goodsList);
		
		model.addAttribute("goodsList", goodsList);
		
		return "goods/goodsList";
	}
	
	
	@GetMapping("/test001")
	public String test01() {
		
		return "/goods/e_commerce";
	}
}
