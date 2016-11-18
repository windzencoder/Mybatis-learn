package com.imooc.dao;

import java.util.List;

import com.imooc.bean.Message;

/*
 * 与Message配置文件相对应的接口
 * 
 *  配置文件的namespace与包名统一
 */
public interface IMessage {

	/*
	 * queryMessageList为语句id相对应
	 * 参数与参数类型相对应
	 * 返回值也相对应
	 */
	public List<Message> queryMessageList(Message message);
	
}
