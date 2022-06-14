package ksmart.mybatis.dto;

public class GoodsImg {
	private String goods_image_code;
	private String goods_image_reg;
	private String goods_image_reg_date;
	@Override
	public String toString() {
		return "GoodsImg [goods_image_code=" + goods_image_code + ", goods_image_reg=" + goods_image_reg
				+ ", goods_image_reg_date=" + goods_image_reg_date + "]";
	}
	public String getGoods_image_code() {
		return goods_image_code;
	}
	public void setGoods_image_code(String goods_image_code) {
		this.goods_image_code = goods_image_code;
	}
	public String getGoods_image_reg() {
		return goods_image_reg;
	}
	public void setGoods_image_reg(String goods_image_reg) {
		this.goods_image_reg = goods_image_reg;
	}
	public String getGoods_image_reg_date() {
		return goods_image_reg_date;
	}
	public void setGoods_image_reg_date(String goods_image_reg_date) {
		this.goods_image_reg_date = goods_image_reg_date;
	}
}
