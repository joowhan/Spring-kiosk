package com.kopo.cafe.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kopo.cafe.dto.MenuDTO;
import com.kopo.cafe.global.enums.SizeEnum;

@Repository
public class MenuDAO {
	private static final Map<Long, MenuDTO> cafeMenuStore = new HashMap<Long, MenuDTO>();
	private static long sequence = 0L;
	
	//메뉴 저장
	public MenuDTO save(MenuDTO menu) {
		menu.setItemId(++sequence);
		cafeMenuStore.put(menu.getItemId(), menu);
		return menu;
		
	}

	// 모든 메뉴 조회
	public List<MenuDTO> findAll() {
		return new ArrayList<>(cafeMenuStore.values());
	}

	// 특정 카테고리의 메뉴 조회
//	public List<Menu> findByCategory(String category) {
//		return cafeMenuStore.values().stream()
//				.filter(menu -> menu.getCategory().equalsIgnoreCase(category))
//				.collect(Collectors.toList());
//	}

	// 초기 데이터 설정 메서드
	public void initMenu() {
		save(new MenuDTO(1, "커피", "아메리카노", "3000", "/images/americano.jpg", List.of(SizeEnum.SMALL, SizeEnum.MEDIUM, SizeEnum.LARGE)));
		save(new MenuDTO(2, "커피", "카페라떼", "3500", "/images/latte.jpg", List.of(SizeEnum.SMALL, SizeEnum.MEDIUM, SizeEnum.LARGE)));
		save(new MenuDTO(3, "음료", "딸기 에이드", "4500", "/images/strawberry_ade.jpg", null)); // 사이즈 없음
		save(new MenuDTO(4, "푸드", "크로와상", "3000", "/images/croissant.png", null)); // 사이즈 없음
	}
	//아이템 아이디로 상세 메뉴 조회
	public MenuDTO findById(long itemId) {
		return cafeMenuStore.get(itemId);
	}
}
