package com.imooc.bean;

/**
 * 与消息表对应的实体类
 * @author Miller
 *
 */
public class Message {

	/*
	 * 主键
	 */
	private String ID;
	/*
	 * 指令名称
	 */
	private String command;
	/*
	 * 描述
	 */
	private String description;
	/*
	 * 内容
	 */
	private String content;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
