package jp.co.rakus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.domain.BaseballTeam;
import jp.co.rakus.repository.CentralLeagueRepository;

@Controller
@RequestMapping("/cl")
public class CentralLeagueController {
	
	@Autowired
	private CentralLeagueRepository repository;
	
	@RequestMapping("/")
	public String toList(Model model) {
		
		List<BaseballTeam> teamList = repository.findAll();
		model.addAttribute("teamList",teamList);
		
		return "centralList";
	}
	
	@RequestMapping("/toOutput")
	public String toOutput(Integer id,Model model) {
		BaseballTeam baseballTeam = repository.load(id);
		model.addAttribute("baseballTeam",baseballTeam);
		
		return "centralOutput";
	}

}
