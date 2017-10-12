package com.wz.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.wz.mybatis.bean.Employee;

public class MybatisTest {

	@Test
	public void test() throws IOException {
		
        String resource = "mybatis-config.xml";
        //加载mybatis 的配置文件（它也加载关联的映射文件）
        Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession 的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql 的sqlSession
        SqlSession session = sessionFactory.openSession();	
        
        try {
        		Employee employee = (Employee) session.selectOne("com.wz.mybatis.EmployeeMapper.selectEmp", 1);
        		System.out.println(employee);
        	} finally {
        	  session.close();
        	}
	
	}
	
	

}
