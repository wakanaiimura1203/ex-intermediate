package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;


@Service
@Transactional
public class HotelService {
	
	/**
	 *　リポジトリ―からメソッドをもってくる為にリポジトリ―をインスタンス化。
	 *
	 */
	@Autowired
	private HotelRepository hotelRepository;
	
	/**
	 *　リポジトリ―からfindAll()メソッドを呼ぶ
	 * 引数の値が空の場合はホテル情報を全件取得する。
	 * 金額条件に応じたホテルの詳細条件を取得する。
	 * 取得した情報をコントローラにわたす。
	 */
	
	public List<Hotel> findByLessThanPrice(String price) {
		if("".equals(price)) {
		return hotelRepository.findAll();
	} else {
		return hotelRepository.findByLessThanPrice(Integer.parseInt(price));
		}
	}

	
}
	