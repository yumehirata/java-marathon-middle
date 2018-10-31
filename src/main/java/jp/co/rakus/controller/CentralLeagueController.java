package jp.co.rakus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.BaseballTeam;
import jp.co.rakus.repository.CentralLeagueRepository;

/**
 * 球団の概要を表示するコントローラー.
 * 
 * @author yume.hirata
 *
 */
@Controller
@RequestMapping("/cl")
public class CentralLeagueController {
	
	@Autowired
	private CentralLeagueRepository repository;
	
	/**
	 * 球団の一覧を表示する.
	 * 
	 * @param model	表示用の変数
	 * @return	一覧画面
	 */
	@RequestMapping("/")
	public String toList(Model model) {
		
		List<BaseballTeam> teamList = repository.findAll();
		model.addAttribute("teamList",teamList);
		
		return "centralList";
	}
	
	/**
	 * 詳細画面を表示する.
	 * 
	 * @param id	詳細画面を表示する球団のID
	 * @param model	表示用の変数
	 * @return	詳細画面
	 */
	@RequestMapping("/toOutput")
	public String toOutput(Integer id,Model model) {
		BaseballTeam baseballTeam = repository.load(id);
		model.addAttribute("baseballTeam",baseballTeam);
		
		return "centralOutput";
	}

}
