package com.hank.SpringBootAPI.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.hank.SpringBootAPI.utils.DateUtil;
import com.hank.SpringBootAPI.utils.HtmlUtil;

/**
 * 股票資訊
 * 
 * @author USER
 *
 */
@Service
public class StockService {

	/**
	 * 取得股票價格
	 * 
	 * @param inputStockId
	 * @return
	 */
	public Map<String, Object> getStockData(String inputStockId) {
		Map<String, Object> rtnData = new HashMap<String, Object>();
		String nowPage = "https://invest.cnyes.com/twstock/TWS/" + inputStockId;

		String dateStr = DateUtil.getNowDateStr("MM/dd");
		try {
			Document currentPage = HtmlUtil.loadHtml(nowPage);

			Elements stockId = currentPage.getElementsByClass("main_title");
			Elements stockName = currentPage.getElementsByClass("main_subTitle");
			rtnData.put("stockId", stockId.get(0).text());
			rtnData.put("stockName", stockName.get(0).text());

			// 判斷交易日期是否為當天，當天才發送
			Elements timeElements = currentPage.getElementsByClass("header-time");
			for (Element timeElement : timeElements) {
				String[] timeList = (timeElement.getAllElements().text()).split(" ");

				if (!timeList[1].equals(dateStr)) {
					return null;
				}
			}

			// 取得價格
			Elements priceElements = currentPage.getElementsByClass("header-info");
			for (Element priceElement : priceElements) {
				String[] timeList = (priceElement.getAllElements().text()).split(" ");
				rtnData.put("nowPrice", timeList[0]);
				rtnData.put("nowI_D", timeList[1]);
				rtnData.put("nowI_D_percent", timeList[2]);
			}
		} catch (MalformedURLException e) {
			return null;
		} catch (IOException e) {
			return null;
		}

		return rtnData;
	}
}
