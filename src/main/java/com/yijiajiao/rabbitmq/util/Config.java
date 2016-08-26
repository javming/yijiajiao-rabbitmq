package com.yijiajiao.rabbitmq.util;

import java.util.ResourceBundle;

public class Config {
	/**
	 * 
	 * @author davis.shi
	 */
	private static final ResourceBundle config = ResourceBundle
			.getBundle("config");

	/**
     *
     */
	private Config() {
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		return config.getString(key);
	}

	public static int getInt(String key) {
		String temp = config.getString(key);
		int value = Integer.parseInt(temp);
		return value;
	}

}