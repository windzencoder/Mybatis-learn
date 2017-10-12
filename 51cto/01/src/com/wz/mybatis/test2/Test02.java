package com.wz.mybatis.test2;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.wz.mybatis.bean.Order;


public class Test02 {

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
	public void testAdd(){
		String statement = "com.wz.mybatis.test2.orderMapper.getOrder2";
		Order order = session.selectOne(statement, 1);
		System.out.println(order);
		
	}

}
