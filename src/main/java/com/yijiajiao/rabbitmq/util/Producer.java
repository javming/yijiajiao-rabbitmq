package com.yijiajiao.rabbitmq.util;

public class Producer {
	private static final String USERNAME=Config.getString("rabbit.username");
	private static final String PASSWORD = Config.getString("rabbit.password");
	private static final String HOST = Config.getString("rabbit.hosts");
	private static final int PORT = Integer.parseInt(Config.getString("rabbit.port"));
	private static final String ROUTINGKEY = Config.getString("rabbit.routingKey");
	private static final String EXCHANGENAME=Config.getString("rabbit.exchange");
	
	public static void sendMessage(Object object){

	}
}
