package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

/**
 * @author nemur
 *
 */
@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;

	/**
	 * @author nemur 
	 * チーム一覧を全件取得するためのメソッド
	 * サービスからもらった情報をリストに格納し、リストをリクエストスコープに格納
	 */
	@RequestMapping("/list")
	public String showList(Model model) {
		List<Team> teamList = teamService.findAll();
		model.addAttribute("teamList", teamList);
		return "team";
	}
	
	/**
	   * 各チームの情報を取得。
	   * 各チームごとのページに遷移後、チームごとの情報を表示
	   * @param model Model
	   * @return 各チームの情報詳細画面
	   */
	@RequestMapping("/showResult")
	public String showResult(Integer id,Model model) {
		Team team = teamService.load(id);
		model.addAttribute("team", team);
		return "result";
	}
}
	
	
	
