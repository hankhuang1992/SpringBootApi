package com.hank.SpringBootAPI.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hank.SpringBootAPI.service.BeautyService;
import com.hank.SpringBootAPI.service.StockService;


@RestController
@RequestMapping(path = "/getData")
public class GetDataController {

	@Autowired
	StockService stockService;
	
	@Autowired
	BeautyService beautyService;
	
	/**
	 * 時間 觸發啟動HEROKU
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/doStart", method = RequestMethod.GET)
	public Map<String, Object> doStart() {
		Map<String, Object> rtnData = new HashMap<String, Object>();
		rtnData.put("status", "ok");
		return rtnData;
	}
	
	/**
	 * 取得股票
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/Stock/{data}", method = RequestMethod.GET)
	public Map<String, Object> getStockData(@PathVariable("data") String data) {
		Map<String, Object> rtnData = stockService.getStockData(data);
		return rtnData;
	}
	
	/**
	 * 取得 特別 表特
	 * @param data
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/SpecialBeauty", method = RequestMethod.GET)
	public Map<String, Object> getSpecialBeautyData() throws IOException {
		Map<String, Object> rtnData = beautyService.getSpecialBeautyData();
		return rtnData;
	}
	
//	/**
//	 * 取得 特別 表特
//	 * @param data
//	 * @return
//	 */
//	@RequestMapping(value = "/SpecialBeauty2", method = RequestMethod.GET)
//	public Map<String, Object> getSpecialBeautyData2() {
//		Map<String, Object> rtnData = beautyService.getSpecialBeautyData2();
//		return rtnData;
//	}

}
