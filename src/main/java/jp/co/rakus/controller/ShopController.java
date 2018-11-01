package jp.co.rakus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.Shop;
import jp.co.rakus.repository.ShopRepository;

/**
 * shopテーブルに関する検索結果を受け渡すコントローラー.
 * 
 * @author yume.hirata
 *
 */
@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private ShopRepository repository;
	
	/**
	 * 検索の初期画面を表示する.
	 * 
	 * @return	検索画面
	 */
	@RequestMapping("/")
	public String toSearch() {
		return "searchShop";
	}
	
	@RequestMapping("/toResult")
	public String toResult(Integer gender,String color,Model model) {
		List<Shop> shopList = repository.findByColor(gender, color);
		model.addAttribute("shopList",shopList);
		
		return "searchShop";
	}

}
