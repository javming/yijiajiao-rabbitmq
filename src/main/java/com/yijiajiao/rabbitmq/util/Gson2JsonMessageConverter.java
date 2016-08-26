package com.yijiajiao.rabbitmq.util;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractJsonMessageConverter;
import org.springframework.amqp.support.converter.ClassMapper;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.MessageConversionException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
/**
 * @description	RabbitMQ已经实现了Jackson的消息转换（Jackson2JsonMessageConverter），由于考虑到效率，如下使用Gson实现消息转换。
								如下消息的转换类的接口MessageConverter，Jackson2JsonMessageConverter的父类AbstractJsonMessageConverter针对
								json转换的基类,我们实现Gson2JsonMessageConverter转换类也继承AbstractJsonMessageConverter。
 * @author  zhaoming
 * @date 2016-8-2
 */
public class Gson2JsonMessageConverter extends AbstractJsonMessageConverter{
	private static Logger log = LoggerFactory.getLogger(Gson2JsonMessageConverter.class);
	private static ClassMapper classMapper = new DefaultClassMapper();
	private static Gson gson = new Gson();
	
	 public Gson2JsonMessageConverter() {  
	        super();  
	    }  
	@Override
	public  Message createMessage(Object object, MessageProperties messageProperties) {
        byte[] bytes = null;  
        try {  
            String jsonString = gson.toJson(object);  
            bytes = jsonString.getBytes(getDefaultCharset());  
        }  
        catch (IOException e) {  
            throw new MessageConversionException(  
                    "Failed to convert Message content", e);  
        }  
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);  
        messageProperties.setContentEncoding(getDefaultCharset());  
        if (bytes != null) {  
            messageProperties.setContentLength(bytes.length);  
        }  
        classMapper.fromClass(object.getClass(),messageProperties);  
        return new Message(bytes, messageProperties);  
	}

	@Override
	public Object fromMessage(Message message) throws MessageConversionException {
        Object content = null;  
        MessageProperties properties = message.getMessageProperties();  
        if (properties != null) {  
            String contentType = properties.getContentType();  
            if (contentType != null && contentType.contains("json")) {  
                String encoding = properties.getContentEncoding();  
                if (encoding == null) {  
                    encoding = getDefaultCharset();  
                }  
                try {  
                        Class<?> targetClass = getClassMapper().toClass(  
                                message.getMessageProperties());  
                        content = convertBytesToObject(message.getBody(),  
                                encoding, targetClass);  
                }  
                catch (IOException e) {  
                    throw new MessageConversionException(  
                            "Failed to convert Message content", e);  
                }  
            }  
            else {  
                log.warn("Could not convert incoming message with content-type ["  
                        + contentType + "]");  
            }  
        }  
        if (content == null) {  
            content = message.getBody();  
        }  
        return content;  
	}
	private Object convertBytesToObject(byte[] body, String encoding,  
	        Class<?> clazz) throws UnsupportedEncodingException {  
	    String contentAsString = new String(body, encoding);  
	    return gson.fromJson(contentAsString, clazz);  
	}  
}
