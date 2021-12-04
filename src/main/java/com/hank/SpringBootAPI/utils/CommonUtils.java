package com.hank.SpringBootAPI.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommonUtils {
	
	/**
	 * InputStream 轉換 String
	 * @param is
	 * @param ecoding
	 * @return
	 * @throws IOException
	 */
	public static String convertStreamToString(InputStream is, String ecoding) throws IOException {
		StringBuilder sb = new StringBuilder(Math.max(16, is.available()));
		char[] tmp = new char[4096];
		try {
			InputStreamReader reader = new InputStreamReader(is, ecoding);
			for (int cnt; (cnt = reader.read(tmp)) > 0;)
				sb.append(tmp, 0, cnt);
		} finally {
			is.close();
		}
		return sb.toString();
	}
}
