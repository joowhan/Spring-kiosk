package com.kopo.hello.cafeVO.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Menu {
	private long itemId;
	private String category;
	private String name;
	private String price;
	private String imgUrl;
	private List<Size> sizes;
	private Size selectedSize; // 사용자가 선택한 사이즈

	public Menu(long itemId, String category, String name, String price, String imgUrl, List<Size> sizes) {
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
