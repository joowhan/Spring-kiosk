package com.kopo.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.kopo.cafe.global.enums.SizeEnum;

@Getter
@Setter
public class MenuDTO {
	private long itemId;
	private String category;
	private String name;
	private String price;
	private String imgUrl;
	private List<SizeEnum> sizes;
	private SizeEnum selectedSize; // 사용자가 선택한 사이즈 -> 제거 후 사용자가 선택한 사이즈는 카트에서 표시

	public MenuDTO(long itemId, String category, String name, String price, String imgUrl, List<SizeEnum> sizes) {
		this.itemId = itemId;
		this.category = category;
		this.name = name;
		this.price = price;
		this.imgUrl = imgUrl;
		this.sizes = sizes;
	}
	public boolean hasSizes() {
		return sizes != null && !sizes.isEmpty();
	}
}
