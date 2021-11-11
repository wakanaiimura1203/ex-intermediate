package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * hotelsテーブルを操作するリポジトリ
 *
 */
@Repository
public class HotelRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * hotelオブジェクトを生成するローマッパー。 ラムダ式でローマッパーインターフェイスを実装。
	 * リザルトセットから各要素を取得してhotelオブジェクトにセット。 ※この時要素名データベースに合わせる。
	 */

	public static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearest_station(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));

		return hotel;
	};

	/**
	 * ホテル情報を価格順（降順）で取得
	 * 
	 * @return 全ホテル情報
	 */
	public List<Hotel> findAll() {
		String sql = "SELECT * FROM hotels ORDER BY price DESC;";

		// SQLの実行処理。複数の値を返す。
		List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);
		return hotelList;
	}

	/**
	 * 入力された金額以下のpriceから各ホテル情報を取得
	 * 
	 * @param price 入力される金額（まだ未確定）
	 * @return 条件と金額が一致するホテル情報
	 */
	public List<Hotel> findByLessThanPrice(Integer price) {

		String sql = "SELECT * FROM hotels WHERE price<=:price ORDER BY price;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);

		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);
		return hotelList;
	}

}
