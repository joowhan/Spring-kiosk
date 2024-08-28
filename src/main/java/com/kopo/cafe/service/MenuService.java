package com.kopo.cafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kopo.cafe.dao.MenuDAO;
import com.kopo.cafe.dto.MenuDTO;

@Service
public class MenuService {
	private final MenuDAO menuDAO;

	@Autowired
	public MenuService(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	// 모든 메뉴 조회
	public List<MenuDTO> getAllMenus() {
		return menuDAO.findAll();
	}

	// 특정 ID의 메뉴 조회
	public MenuDTO getMenuById(long itemId) {
		return menuDAO.findById(itemId);
	}

	// 새로운 메뉴 저장
	public MenuDTO createMenu(MenuDTO menu) {
		return menuDAO.save(menu);
	}

	// 초기화: 예시 데이터 추가
	public void initializeMenuData() {
		menuDAO.initMenu();
	}
}
