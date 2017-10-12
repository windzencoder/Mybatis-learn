package com.wz.mybatis.test3;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.wz.mybatis.bean.Class;
import com.wz.mybatis.bean.Order;


public class Test03 {

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
	public void testClass(){
		String statement = "com.wz.mybatis.test3.classMapper.getClass";
		Class clazz = session.selectOne(statement, 1);
		System.out.println(clazz);
		
	}
	
	@Test
	public void testClass2(){
		String statement = "com.wz.mybatis.test3.classMapper.getClass2";
		Class clazz = session.selectOne(statement, 1);
		System.out.println(clazz);
	}

}
