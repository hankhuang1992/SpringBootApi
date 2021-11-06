package com.hank.SpringBootAPI.service;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.hank.SpringBootAPI.utils.HtmlUtil;

/**
 * 表特資訊
 * 
 * @author USER
 *
 */
@Service
public class BeautyService {
	
	/**
	 * 取得 特別 表特
	 * 
	 * @param inputStockId
	 * @return
	 */
	public Map<String, Object> getSpecialBeautyData() {
		System.out.println("getSpecialBeautyData ===");
		Map<String, Object> rtnData = new HashMap<String, Object>();
		String nowPage = "https://www.dcard.tw/_api/forums/sex/posts?limit=30&popular=true";

		try {
			Document currentPage = HtmlUtil.loadHtml(nowPage);
			
//			System.out.println(currentPage.toString());
			Elements pageValue = currentPage.getAllElements();
			System.out.println(pageValue.get(0).text());
			rtnData.put("data", pageValue.get(0).text());
		} catch (Exception e) {
			System.out.println("==========getSpecialBeautyData ERR==========");
			System.out.println(e.toString());
			return null;
		}

		return rtnData;
	}
}
