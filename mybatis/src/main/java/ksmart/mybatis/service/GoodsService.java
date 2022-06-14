package ksmart.mybatis.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart.mybatis.dto.Goods;
import ksmart.mybatis.dto.GoodsReg;
import ksmart.mybatis.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {

	private GoodsMapper goodsMapper;
	
	
	public GoodsService(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}
	
	//상품 등록
	public void addGoods(Goods goods) {
		goodsMapper.addGoods(goods);
		
	}
	
	//상품 목록 조회
	public List<Goods> getGoodsList(Map<String, Object> paramMap){
		List<Goods> goodsList = goodsMapper.getGoodsList(paramMap);
		return goodsList;
	}
	
	
	//상품 대분류
	public List<Goods> getGoodsTopCategory(Map<String, Object> paramMap) {
		List<Goods> goodsTopCategory = goodsMapper.getGoodsTopCategory(paramMap);
		return goodsTopCategory;
	}
	
	//상품 소분류
	public List<Goods> getgoodsSubCategory(Map<String, Object> paramMap) {
		List<Goods> goodsSubCategory = goodsMapper.getGoodsSubCategory(paramMap);
		return goodsSubCategory;
	}
}
