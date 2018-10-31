package jp.co.rakus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.domain.BaseballTeam;

@Repository
public class CentralLeagueRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<BaseballTeam> BASEBALLTEAM_ROW_MAPPER = (rs,i) ->{
		BaseballTeam baseballTeam = new BaseballTeam();
		baseballTeam.setId(rs.getInt("id"));
		baseballTeam.setLeagueName(rs.getString("league_name"));
		baseballTeam.setTeamName(rs.getString("team_name"));
		baseballTeam.setHeadquarters(rs.getString("headquarters"));
		baseballTeam.setInauguration(rs.getString("inauguration"));
		baseballTeam.setHistory(rs.getString("history"));
		return baseballTeam;
	};
	
	public BaseballTeam load(Integer id) {
		String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM baseball_teams WHERE id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		
		BaseballTeam baseballTeam = template.queryForObject(sql, param, BASEBALLTEAM_ROW_MAPPER);
		
		return baseballTeam;
	}
	
	public List<BaseballTeam> findAll(){
		String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM baseball_teams";
		
		List<BaseballTeam> teamList = template.query(sql, BASEBALLTEAM_ROW_MAPPER);
		
		return teamList;
	}
	
}
