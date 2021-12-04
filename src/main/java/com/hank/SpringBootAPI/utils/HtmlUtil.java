package com.hank.SpringBootAPI.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlUtil {

	public static Document loadHtml(String url) throws MalformedURLException, IOException {
		// open connection
		HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

		// set HTTP header
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		// con.setRequestProperty("cookie","uuid_tt_dd=10_34114282980-1529461157344-597613;
		// "); //请求头信息、cookie、UserAgent参数等都可以放在这里
		con.setRequestProperty("cookie", "over18=1; "); // 请求头信息、cookie、UserAgent参数等都可以放在这里

		// if response is 200, extract html data, else return null
		int responseCode = con.getResponseCode();
		if (responseCode == 200) {
			StringBuilder strBuilder = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				strBuilder.append(line);
			}
			br.close();

			return Jsoup.parse(strBuilder.toString());
		} else {
			return null;
		}
	}

	/**
	 * 建立一個用於下載的 input stream 到指定的 url。
	 * 
	 * @param url
	 *            input stream 的來源
	 * @return 如果該 url 連結成功，傳回一個 input stream；失敗或者不存在皆傳回 null
	 */
	public static InputStream constructInputStream(String url) {
		try {
			// Set request
			HttpsURLConnection con = (HttpsURLConnection) new URL(url).openConnection();

			// 如果沒有設定 User-Agent，就會被丟 403 Forbidden
			con.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			con.setRequestMethod("GET");

			// Check response status
			int responseCode = con.getResponseCode();
			if (responseCode != 200)
				return null;

			return con.getInputStream();
		} catch (IOException e) {
			System.err.println("Exception when " + url + ": " + e.getMessage());
			return null;
		}
	}
}