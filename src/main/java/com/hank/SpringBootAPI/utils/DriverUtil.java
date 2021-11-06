package com.hank.SpringBootAPI.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtil {

	public void doOpen(){
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");  
        
        //初始化一個chrome瀏覽器例項，例項名稱叫driver  
        WebDriver driver = new ChromeDriver();  
        //最大化視窗  
        driver.manage().window().maximize();  
        //設定隱性等待時間  
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);  
          
        // get()開啟一個站點  
        driver.get("https://www.dcard.tw/service/api/v2/forums/sex/posts?limit=30&popular=true");  
        //getTitle()獲取當前頁面title的值  
        System.out.println("當前開啟頁面的標題是： "+ driver.getTitle());  
          
        //關閉並退出瀏覽器  
        driver.quit();  
	}
}
