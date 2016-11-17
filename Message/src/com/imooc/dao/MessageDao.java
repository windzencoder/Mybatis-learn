package com.imooc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

/*
 * 和Message表相关的数据库操作
 */
public class MessageDao {

	public List<Message> queryMessageList(String command, String description){
		DBAccess dbAccess =  new DBAccess();
		SqlSession sqlSession = null;
		List<Message> messageList = new ArrayList<>();
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
			//多个参数 封装到一个对象中
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			messageList = sqlSession.selectList("Message.queryMessageList", message);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	/*
	 * 单条删除
	 */
	public boolean deleteOne(int id){
		DBAccess dbAccess =  new DBAccess();
		SqlSession sqlSession = null;
		int count = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
			count = sqlSession.delete("Message.deleteOne", id);
			//提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return count > 0 ? true : false;
	}
	
	
	/*
	 * 多条删除
	 */
	public void deleteBatch(List<Integer> ids){
		DBAccess dbAccess =  new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
			sqlSession.delete("Message.deleteBatch", ids);
			//提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/*
	 * 测试
	 */
	public static void main(String[] args) {
		MessageDao messageDao = new MessageDao();
		messageDao.queryMessageList("", "");
		
	}
	
	/*
	 * 根据查询条件查询消息列表
	 */
	/*
	public List<Message> queryMessageList(String command, String description){
		//jdbc连接数据库
		List<Message> messageList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message?characterEncoding=utf8","root","");
			StringBuilder sql = new StringBuilder( "select ID, COMMAND, DESCRIPTION, CONTENT from message where 1=1");
			List<String> paramList = new ArrayList<>();
			if (command != null && !"".equals(command.trim())) {
				sql.append(" and COMMAND=?");
				paramList.add(command);
			}
			if (description != null && !"".equals(description.trim())) {
				sql.append(" and DESCRIPTION like '%' ? '%' ");
				paramList.add(description);
			}
			
			PreparedStatement statement = connection.prepareStatement(sql.toString());
			
			for (int i=0; i < paramList.size(); i++) {
				statement.setString(i+1, paramList.get(i));
			}
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Message message = new Message();
				messageList.add(message);
				message.setID(rs.getString("ID"));
				message.setCommand(rs.getString("COMMAND"));
				message.setDescription(rs.getString("DESCRIPTION"));
				message.setContent(rs.getString("CONTENT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return messageList;
	}
	*/
	
}
