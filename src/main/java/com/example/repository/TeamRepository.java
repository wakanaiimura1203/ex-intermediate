package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

@Repository
public class TeamRepository {

	// リザルトセットオブジェクトをteamオブジェクトに変換
	public static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));

		return team;
	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * チーム一覧情報を発足日順で全件取得
	 * 
	 */
	public List<Team> findAll() {
		String sql = "SELECT * FROM teams ORDER BY inauguration ASC";

		// SQLの実行処理。複数の値を返す。
		List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);

		return teamList;
	}

	/**
	 * 主キーから各チーム情報を取得
	 * 
	 * @param 取得したいチームID
	 * @return 各idに対応するチーム情報
	 */
	public Team load(Integer id) {
		String sql = "SELECT * FROM teams WHERE id=:id";
		// Mapインスタンス化
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		return team;
	}
}
