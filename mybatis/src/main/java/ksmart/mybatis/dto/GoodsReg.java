package ksmart.mybatis.dto;

public class GoodsReg {
	private String goods_basic_info_code;
	private String goods_sub_category_code;
	private String goods_name;
	private String goods_description;
	private String goods_basic_info_reg_date;
	@Override
	public String toString() {
		return "GoodsReg [goods_basic_info_code=" + goods_basic_info_code + ", goods_sub_category_code="
				+ goods_sub_category_code + ", goods_name=" + goods_name + ", goods_description=" + goods_description
				+ ", goods_basic_info_reg_date=" + goods_basic_info_reg_date + "]";
	}
	public String getGoods_basic_info_code() {
		return goods_basic_info_code;
	}
	public void setGoods_basic_info_code(String goods_basic_info_code) {
		this.goods_basic_info_code = goods_basic_info_code;
	}
	public String getGoods_sub_category_code() {
		return goods_sub_category_code;
	}
	public void setGoods_sub_category_code(String goods_sub_category_code) {
		this.goods_sub_category_code = goods_sub_category_code;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_description() {
		return goods_description;
	}
	public void setGoods_description(String goods_description) {
		this.goods_description = goods_description;
	}
	public String getGoods_basic_info_reg_date() {
		return goods_basic_info_reg_date;
	}
	public void setGoods_basic_info_reg_date(String goods_basic_info_reg_date) {
		this.goods_basic_info_reg_date = goods_basic_info_reg_date;
	}
	
	
}
