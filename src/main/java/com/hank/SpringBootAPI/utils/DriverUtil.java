//package com.hank.SpringBootAPI.utils;
//
//import java.util.concurrent.TimeUnit;
//
//import org.apache.commons.exec.environment.EnvironmentUtils;
//import org.junit.jupiter.api.condition.OS;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//public class DriverUtil {
//
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
//}
