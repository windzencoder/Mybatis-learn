package com.wz.mybatis.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class UserCRUDTest {

	private SqlSession session = null;
	
	@Before
	public void before() throws IOException{
        String resource = "Configuration.xml";
        //加载mybatis 的配置文件（它也加载关联的映射文件）
        Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession 的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql 的sqlSession
        session = sessionFactory.openSession();
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAdd(){
		String statement = "com.wz.mybatis.test.userMapper.addUser";
		int insert =  session.insert(statement, new User(-1, "KK", 123));
		session.commit();
		System.out.println("insert = "+insert);
	}
	
	@Test
	public void testDelete(){
		String statement = "com.wz.mybatis.test.userMapper.deleteUser";
		int delete =  session.delete(statement, 4);
		session.commit();
		System.out.println("delete = "+ delete);
	}
	
	@Test
	public void testUpdate(){
		String statement = "com.wz.mybatis.test.userMapper.updateUser";
		int update =  session.update(statement, new User(5, "KK6", 123));
		session.commit();
		System.out.println("update = "+update);
	}
	
	@Test
	public void testSelectAll(){
		String statement = "com.wz.mybatis.test.userMapper.getAllUsers";
		List<User> users =  session.selectList(statement);
		session.commit();
		System.out.println("users = "+ users);
	}

}
