package com.kopo.hello.cafeService;

import com.kopo.hello.cafeDAO.MenuDAO;
import com.kopo.hello.cafeVO.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final MenuDAO menuDAO;


    @Autowired
    public MenuService(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    // 모든 메뉴 조회
    public List<Menu> getAllMenus() {
        return menuDAO.findAll();
    }

    // 특정 ID의 메뉴 조회
    public Menu getMenuById(long itemId) {
        return menuDAO.findById(itemId);
    }

    // 새로운 메뉴 저장
    public Menu createMenu(Menu menu) {
        return menuDAO.save(menu);
    }

    // 초기화: 예시 데이터 추가
    public void initializeMenuData() {
        menuDAO.initMenu();
    }
}
