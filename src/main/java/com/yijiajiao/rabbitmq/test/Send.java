package com.yijiajiao.rabbitmq.test;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.yijiajiao.rabbitmq.util.Config;
import com.yijiajiao.rabbitmq.util.HessionCodecFactory;
import org.junit.Test;


public class Send {
	private final String username=Config.getString("rabbit.username");
	private final String password = Config.getString("rabbit.password");
	private final String host = Config.getString("rabbit.hosts");
	private final int port = Integer.parseInt(Config.getString("rabbit.port"));
	@Test
	public  void sendMessage() throws Exception{

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setUsername(username);
		factory.setPassword(password);
		factory.setPort(port);
		
		Connection connection = factory.newConnection();
		final Channel channel = connection.createChannel();
		//    exchangeName：交换机名字 exchangeType(direct)类型 durable是否持久化 autoDelete不使用时是否自动删除
		channel.exchangeDeclare("test_exchange","direct",true);
		String queueName = channel.queueDeclare("test_queue",true,false,false,null).getQueue();
		channel.queueBind(queueName, "test_exchange", "async_routingkey");
		
		
		//String message ="{\"requestId\":\"a6d613e038a54cdea40dc8bb4ed3a038\",\"httpCode\":\"\",\"code\":200,\"message\":\"success\",\"result\":[0,1,0]}";
		//channel.basicPublish(exchangeName, routingKey, null, HessionCodecFactory.serialize(message));
		for(int i=0;i<100;i++){
			String message = "the "+i+"th message";
			channel.basicPublish("test_exchange", "async_routingkey", null, HessionCodecFactory.serialize(message));
			System.out.println(message);
		}
	}
}
