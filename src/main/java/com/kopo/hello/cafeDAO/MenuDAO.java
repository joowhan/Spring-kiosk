package com.kopo.hello.cafeDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kopo.hello.cafeVO.menu.Menu;
import com.kopo.hello.cafeVO.menu.Size;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDAO {
	private static final Map<Long, Menu> cafeMenuStore = new HashMap<Long, Menu>();
	private static long sequence = 0L;
	
	//메뉴 저장
	public Menu save(Menu menu) {
		menu.setItemId(++sequence);
		cafeMenuStore.put(menu.getItemId(), menu);
		return menu;
		
	}

	// 모든 메뉴 조회
	public List<Menu> findAll() {
		return new ArrayList<>(cafeMenuStore.values());
	}

	// 특정 카테고리의 메뉴 조회
	public List<Menu> findByCategory(String category) {
		return cafeMenuStore.values().stream()
				.filter(menu -> menu.getCategory().equalsIgnoreCase(category))
				.collect(Collectors.toList());
	}

	// 초기 데이터 설정 메서드
	public void initMenu() {
		save(new Menu(1, "커피", "아메리카노", "3000", "/images/americano.jpg", List.of(Size.SMALL, Size.MEDIUM, Size.LARGE)));
		save(new Menu(2, "커피", "카페라떼", "3500", "/images/latte.jpg", List.of(Size.SMALL, Size.MEDIUM, Size.LARGE)));
		save(new Menu(3, "음료", "딸기 에이드", "4500", "/images/strawberry_ade.jpg", null)); // 사이즈 없음
		save(new Menu(4, "푸드", "크로와상", "3000", "/images/croissant.png", null)); // 사이즈 없음
	}
	//아이템 아이디로 상세 메뉴 조회
	public Menu findById(long itemId) {
		return cafeMenuStore.get(itemId);
	}
}
