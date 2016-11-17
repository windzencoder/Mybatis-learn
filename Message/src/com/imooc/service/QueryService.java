package com.imooc.service;

import java.util.List;
import java.util.Random;

import com.imooc.bean.Command;
import com.imooc.bean.CommandContent;
import com.imooc.bean.Message;
import com.imooc.dao.CommandDao;
import com.imooc.dao.MessageDao;
import com.imooc.util.Iconst;

/**
 * 查询相关的业务功能
 */
public class QueryService {
	public List<Message> queryMessageList(String command,String description) {
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command, description);
	}
	
	/**
	 * 通过指令查询自动回复的内容
	 * @param command 指令
	 * @return 自动回复的内容
	 */
	public String queryByCommand(String name) {
		CommandDao commandDao = new CommandDao();
		List<Command> commandList;
		if(Iconst.HELP_COMMAND.equals(name)) {//帮助
			//查询所有的指令
			commandList = commandDao.queryMessageList(null, null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < commandList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + commandList.get(i).getName() + "]可以查看" + commandList.get(i).getDescription());
			}
			return result.toString();
		}
		//查询对应的指定
		commandList = commandDao.queryMessageList(name, null);
		if(commandList.size() > 0) {
			List<CommandContent> contentList = commandList.get(0).getContentList();
			int i = new Random().nextInt(contentList.size());
			return contentList.get(i).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
	
	
	
	/**
	 * 通过指令查询自动回复的内容(原来的查询)
	 * @param command 指令
	 * @return 自动回复的内容
	 */
	/*
	public String queryByCommand(String command) {
		MessageDao messageDao = new MessageDao();
		List<Message> messageList;
		if(Iconst.HELP_COMMAND.equals(command)) {//帮助
			//查询所有的指令
			messageList = messageDao.queryMessageList(null, null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < messageList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + messageList.get(i).getCommand() + "]可以查看" + messageList.get(i).getDescription());
			}
			return result.toString();
		}
		//查询对应的指定
		messageList = messageDao.queryMessageList(command, null);
		if(messageList.size() > 0) {
			return messageList.get(0).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
	*/
	
}
