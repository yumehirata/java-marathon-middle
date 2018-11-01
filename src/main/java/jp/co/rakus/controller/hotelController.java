package jp.co.rakus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.Hotel;
import jp.co.rakus.repository.HotelRepository;

/**
 * 料金でホテルを検索するコントローラー.
 * 
 * @author yume.hirata
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelRepository repository;

	/**
	 * 検索画面を表示する.
	 * 
	 * @return 検索画面
	 */
	@RequestMapping("/")
	public String toSearch() {
		return "searchHotel";
	}

	/**
	 * 検索結果とともに画面を再表示する.
	 * 
	 * @param price
	 *            検索キーとなる価格
	 * @param model
	 *            結果画面に引き渡すための変数
	 * @return 検索結果画面
	 */
	@RequestMapping("/result")
	public String result(Integer price, Model model) {
		List<Hotel> hotelList = repository.findByPrice(price);
		model.addAttribute("price", price);
		model.addAttribute("hotelList", hotelList);

		return "searchHotel";
	}

}
