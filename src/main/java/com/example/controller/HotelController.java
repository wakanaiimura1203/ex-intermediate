package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.form.HotelSearchForm;
import com.example.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@ModelAttribute
	public HotelSearchForm setUpForm() {
		return new HotelSearchForm();
	}
	
	/**
	 * トップページを表示するためのメソッド
	 *
	 */
	@RequestMapping("")
	public String index() {
		return "hotel";
	}
	
		
	/**
	 * 入力された金額条件に該当するホテル情報を取得し、表示させる。 loadメソッドを呼ぶ
	 */
	@RequestMapping("/output")
	public String output(HotelSearchForm form, Model model) {
		
		List<Hotel> hotelList = hotelService.findByLessThanPrice(form.getPrice());
		model.addAttribute("hotelList", hotelList);

		return "redirect:/hotel";
	}
	
}
