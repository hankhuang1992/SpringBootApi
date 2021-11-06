package com.hank.SpringBootAPI.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
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
	
//	/**
//	 * 取得 特別 表特
//	 * 
//	 * @param inputStockId
//	 * @return
//	 */
//	public Map<String, Object> getSpecialBeautyData2() {
//		Map<String, Object> rtnData = new HashMap<String, Object>();
//		System.setProperty("GOOGLE_CHROME_BIN", "/app/.apt/usr/bin/google-chrome"); 
//		System.setProperty("CHROMEDRIVER_PATH", "/app/.chromedriver/bin/chromedriver");
//
//		ChromeOptions options = new ChromeOptions();
//		options.setBinary("/app/.apt/usr/bin/google-chrome");   
//		options.addArguments("--enable-javascript"); 
//		options.addArguments("--headless"); 
//		options.addArguments("--disable-gpu"); 
//		options.addArguments("--no-sandbox");
//
//		WebDriver driver = new ChromeDriver(options);
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get("https://www.dcard.tw/service/api/v2/forums/sex/posts?limit=30&popular=true");
//		
//		String data = driver.findElement(By.xpath("/html/body/pre/text()[1]")).getText();
//		rtnData.put("data", data);
//		return rtnData;
//	}
}
