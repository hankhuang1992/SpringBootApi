package com.hank.SpringBootAPI.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hank.SpringBootAPI.utils.CommonUtils;
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
	 * @throws IOException 
	 */
	public Map<String, Object> getSpecialBeautyData() throws IOException {
		System.out.println("getSpecialBeautyData ===");
		Map<String, Object> rtnData = new HashMap<String, Object>();
//		String nowPage = "https://www.dcard.tw/_api/forums/sex/posts?limit=30&popular=true";
//
//		try {
//			Document currentPage = HtmlUtil.loadHtml(nowPage);
//			
////			System.out.println(currentPage.toString());
//			Elements pageValue = currentPage.getAllElements();
//			System.out.println(pageValue.get(0).text());
//			rtnData.put("data", pageValue.get(0).text());
//		} catch (Exception e) {
//			System.out.println("==========getSpecialBeautyData ERR==========");
//			System.out.println(e.toString());
//			return null;
//		}
//
//		return rtnData;
		
		String nowPage = "https://www.dcard.tw/_api/forums/sex/posts?limit=30&popular=true";
		InputStream inputStream = HtmlUtil.constructInputStream(nowPage);
		
		if (inputStream == null) {
			rtnData.put("htmlStr", "empty");
			return rtnData;
		}
		
		rtnData.put("htmlStr", CommonUtils.convertStreamToString(inputStream, "UTF-8"));
		return rtnData;
	}
	
//	public static void main(String[] args) throws IOException {
//		String nowPage = "https://www.dcard.tw/_api/forums/sex/posts?limit=30&popular=true";
//		InputStream inputStream = HtmlUtil.constructInputStream(nowPage);
//		
//		if (inputStream == null)
//			return;
//		
//		System.out.println(CommonUtils.convertStreamToString(inputStream, "UTF-8"));
//	}
	
	
	
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
	
//	public WebDriver launchBrowser() {
//		String driverPath = "";
//		if (getOS().equals(OS.WINDOWS)) {
//			driverPath = "agent//chromedriver.exe";
//			System.setProperty("webdriver.chrome.driver", driverPath);
//		}
//
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
//		options.addArguments("window-size=1200x600");
//		if (getOS().equals(OS.LINUX)) {
//			try { // GOOGLE_CHROME_SHIM GOOGLE_CHROME_BIN
//				String binaryPath = EnvironmentUtils.getProcEnvironment().get("GOOGLE_CHROME_SHIM");
//				System.out.println("Path: " + binaryPath);
//				options.setBinary(binaryPath);
//				options.addArguments("--disable-gpu");
//				options.addArguments("--no-sandbox");
//			} catch (Exception e) {
//
//			}
//		}
//
//		WebDriver driver = new ChromeDriver(options);
//
//		return driver;
//	}
}
