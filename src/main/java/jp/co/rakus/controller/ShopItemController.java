package jp.co.rakus.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.Shop;
import jp.co.rakus.form.ShopForm;
import jp.co.rakus.repository.ShopRepository;

/**
 * shopテーブルに関する検索結果を受け渡すコントローラー.
 * 
 * @author yume.hirata
 *
 */
@Controller
@RequestMapping("/shopItem")
public class ShopItemController {

	@Autowired
	private ShopRepository repository;

	@ModelAttribute
	public ShopForm setUpForm() {
		return new ShopForm();
	}

	/**
	 * 検索の初期画面を表示する.
	 * 
	 * @param model
	 *            結果を渡すための変数
	 * @return 初期検索画面
	 */
	@RequestMapping("/")
	public String toSearchItem(Model model) {
		Map<Integer, String> genderMap = new HashMap<>();
		genderMap.put(0, "男");
		genderMap.put(1, "女");
		model.addAttribute("genderMap", genderMap);

		List<String> colorList = new ArrayList<>();
		colorList.add("赤");
		colorList.add("青");
		colorList.add("黄");
		colorList.add("白");
		model.addAttribute("colorList", colorList);
		return "searchShopItem";
	}

	/**
	 * 検索結果を表示する
	 * 
	 * @param form
	 *            受け取ってきたリクエストパラメータ
	 * @param model
	 *            結果を渡すための変数
	 * @return 検索結果画面
	 */
	@RequestMapping("/searchedItem")
	public String searchedItem(ShopForm form, Model model) {
		Integer gender = form.getIntGender();
		String color = form.getColor();
		List<Shop> shopList = repository.findByGenderAndColor(gender, color);
		model.addAttribute("shopList", shopList);

		return toSearchItem(model);
	}

}
