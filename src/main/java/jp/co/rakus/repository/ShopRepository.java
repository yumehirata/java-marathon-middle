package jp.co.rakus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.domain.Shop;

/**
 * shopテーブルでアイテム検索をするリポジトリ.
 * 
 * @author yume.hirata
 *
 */
@Repository
public class ShopRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * RowMapperの定義
	 */
	private final static RowMapper<Shop> SHOP_ROW_MAPPER = (rs,i) ->{
		Shop shop = new Shop();
		shop.setId(rs.getInt("id"));
		shop.setCategory(rs.getString("category"));
		shop.setGenre(rs.getString("genre"));
		shop.setGender(rs.getInt("gender"));
		shop.setColor(rs.getString("color"));
		shop.setPrice(rs.getInt("price"));
		shop.setSize(rs.getString("size"));
		return shop;
	};
	
	/**
	 * 色と性別でアイテムを検索する.
	 * 
	 * @param color	検索キーとなる色
	 * @param gender	検索キーとなる性別
	 * @return	検索結果のリストを返す
	 */
	public List<Shop> findByGenderAndColor(Integer gender,String color) {
		String sql = "SELECT id,category,genre,gender,color,price,size FROM shops WHERE gender=:gender AND color=:color ORDER BY price";
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
		
		List<Shop> shopList = template.query(sql, param, SHOP_ROW_MAPPER);
		
		return shopList;
	}

}
