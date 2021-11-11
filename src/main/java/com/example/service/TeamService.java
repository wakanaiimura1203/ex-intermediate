package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

@Service
@Transactional
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	/**
	 * チーム一覧情報を全件取得
	 * idを引数に各チーム情報を取得
	 * 
	 * @return　チーム一覧情報。リポから帰ってきた情報をコントローラに戻す
	 */
	public List<Team> findAll(){
		return teamRepository.findAll();
	}
	
	public Team load(Integer id) {
		return teamRepository.load(id);
	}

}
