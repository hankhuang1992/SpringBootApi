package com.hank.SpringBootAPI.service;

import java.io.IOException;
import java.net.MalformedURLException;
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
		Map<String, Object> rtnData = new HashMap<String, Object>();
		String nowPage = "https://www.dcard.tw/_api/forums/sex/posts?limit=30&popular=true";

		try {
			Document currentPage = HtmlUtil.loadHtml(nowPage);

			Elements pageValue = currentPage.getElementsByTag("body");
			
			rtnData.put("data", pageValue.get(0).text());
		} catch (MalformedURLException e) {
			return null;
		} catch (IOException e) {
			return null;
		}

		return rtnData;
	}
}
