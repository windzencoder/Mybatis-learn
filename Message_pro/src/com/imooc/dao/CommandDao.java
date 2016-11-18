package com.imooc.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Command;
import com.imooc.db.DBAccess;

/*
 * 指令Dao 指令表对应的数据库操作
 */
public class CommandDao {

	/*
	 * 根据查询条件查询指令列表
	 */
	public List<Command> queryMessageList(String name, String description){
		DBAccess dbAccess =  new DBAccess();
		SqlSession sqlSession = null;
		List<Command> commandList = new ArrayList<>();
		try {
			sqlSession = dbAccess.getSqlSession();
			//多个参数 封装到一个对象中
			Command command = new Command();
			command.setName(name);
			command.setDescription(description);
			//通过sqlSession执行SQL语句
			commandList = sqlSession.selectList("Command.queryCommandList", command);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return commandList;
	}
	
}
