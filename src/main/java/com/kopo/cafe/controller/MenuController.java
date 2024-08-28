package com.kopo.cafe.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kopo.cafe.dto.MenuDTO;
import com.kopo.cafe.global.util.PickUp;
import com.kopo.cafe.model.PickUpFactory;
import com.kopo.cafe.service.MenuService;

//import com.kopo.hello.cafeDAO.MenuDAO;
//import com.kopo.hello.cafeService.MenuService;

@Controller
public class MenuController {

	private final MenuService menuService;

	@Autowired //
	public MenuController(MenuService menuService) { //
		this.menuService = menuService; //
		this.menuService.initializeMenuData();
	}

	// 프로젝트 초기 모든 메뉴 등록
//    @PostConstruct
//    public void init() {
//        menuDAO.initMenu();  // 초기 메뉴 설정
//    }

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/menu")
	public String showMenuPage(@RequestParam(value = "category", defaultValue = "커피") String category, Model model) {
		List<MenuDTO> menuList = menuService.getAllMenus();// 모든 메뉴 조회
		// List<Menu> menuList = menuRepository.findByCategory(category); // 카테고리별 조회 ->
		// 카테고리 선택 시 다시 요청
		for (MenuDTO menu : menuList) {
			System.out.println(menu.getName());
		}
		model.addAttribute("menuList", menuList); // 메뉴 리스트를 모델에 추가
		model.addAttribute("selectedCategory", category); // 선택된 카테고리
		return "menu";
	}

	@RequestMapping("/selectPickUpType")
	public String selectPickUpType(@RequestParam("pickUpType") String pickUpType, HttpSession session) {
		// 고객이 선택한 pick up 방식을 factory에서 불러와 저장
		PickUp pickUp = PickUpFactory.getPickUp(pickUpType);
		// 세션에 PickUp 객체 저장
		session.setAttribute("pickUpOption", pickUp);
		return "redirect:menu";
	}

	@RequestMapping("/menu/detail")
	public String showMenuDetail(@RequestParam("id") long itemId, Model model) {
		MenuDTO menu = menuService.getMenuById(itemId); // 특정 메뉴 조회
		model.addAttribute("menu", menu); // 메뉴 정보를 모델에 추가
		return "menuDetail"; // menuDetail.jsp 파일을 반환
	}

}
