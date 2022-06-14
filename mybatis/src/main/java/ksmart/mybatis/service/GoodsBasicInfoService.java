package ksmart.mybatis.service;

import java.util.List;
import java.util.Map;


import ksmart.mybatis.dto.GoodsReg;
import ksmart.mybatis.mapper.GoodsBasicInfoMapper;

public class GoodsBasicInfoService {

	//상품 기본정보 조회
		public List<GoodsReg> getGoodsBasicInfo(Map<String, Object> paramMap){
			List<GoodsReg> goodsBasicInfo = GoodsBasicInfoMapper.getGoodsBasicInfo(paramMap);
			return goodsBasicInfo;
		}
		
	
		
		
	
}
