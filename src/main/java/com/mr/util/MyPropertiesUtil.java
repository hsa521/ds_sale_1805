package com.mr.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * MyPropertiesUtil
 */
public class MyPropertiesUtil {

	/**
	 * 从properties文件中获取到值
	 * @param pro :所要获取的 properties 文件名
	 * @param key ：key值
	 * @return
	 */
	public static String getPropertiesVal(String pro, String key) {
		//1：创建Properties 对象
		Properties properties = new Properties();
		
		//2：获取当前文件输入流
		InputStream inputStream = MyPropertiesUtil.class.getClassLoader().getResourceAsStream(pro);
		
		//3：调用load方法加载输入流
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String property = properties.getProperty(key);
		return property;
	}

}
