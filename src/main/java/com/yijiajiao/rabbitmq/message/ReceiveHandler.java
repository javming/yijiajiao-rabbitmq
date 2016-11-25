package com.yijiajiao.rabbitmq.message;

import com.rabbitmq.client.Channel;
import com.yijiajiao.rabbitmq.service.*;
import com.yijiajiao.rabbitmq.util.HessionCodecFactory;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import net.rubyeye.xmemcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description	消息消费者，处理异步业务
 * @author  zhaoming
 * @date 2016-8-13
 */
public class ReceiveHandler implements ChannelAwareMessageListener {
	
	private static Logger log = LoggerFactory.getLogger(ReceiveHandler.class);
	private EventExecutorGroup group = new DefaultEventExecutorGroup(1);
	@Autowired
	MemcachedClient memcachedClient;
	@Autowired
	WareLogic wareLogic;
	@Autowired
	UserLogic userLogic;
	@Autowired
	SaleLogic saleLogic;
	@Autowired
	SolutionLogic solutionLogic;
	@Autowired
	TeachLogic teachLogic;
	@Autowired
	OssLogic ossLogic;
	@Autowired
	FinanceLogic financeLogic;
	@Autowired
	MsgLogic msgLogic;
	@Autowired
	BaseDataLogic baseDataLogic;
	@Override
	public void onMessage(Message message, Channel channel){

		long start = System.currentTimeMillis();
		String receiveMsg=null;
		try {
			receiveMsg =(String) HessionCodecFactory.deSerialize(message.getBody());
		} catch (Exception e) {
			log.info(e.toString(),e);
		}
		try {
			channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
			channel.close();
			log.info("----channel.basicAck success!-----");
		} catch (Exception e) {
			log.error("-----channel.basicAck failed :"+e.getMessage()+"------");
		}
		if(receiveMsg != null && !"".equals(receiveMsg)){
			log.info("get command is  :\n" + receiveMsg);
			Future<?> f = group.submit(new LogicThread(receiveMsg,memcachedClient,wareLogic,userLogic,
					saleLogic,solutionLogic,teachLogic,ossLogic,
					financeLogic, msgLogic, baseDataLogic));
			f.addListener( new FutureListener() {
				@Override
				public void operationComplete(Future arg0) throws Exception {
					System.out.println("ok!!!");
				}
			});
		}

		long end = System.currentTimeMillis();
		log.info("-------------------spend "+(end-start)+" ms------------------");
	}

}
