package com.mymybatis.test;

import javax.servlet.jsp.jstl.core.Config;

import com.mymybatis.config.MybatisConfig;
import com.mymybatis.pojo.User;

public class Test {
	
	
	
	public static void main(String[] args){
		
		Test test = new Test();
		System.out.println("url :" + test.getClass().getClassLoader().getResource("resources/config.xml").getPath());
		
				String path = new MybatisConfig().getConfigXmlLocation("resources/config.xml");
		System.out.println("path " + path);
				
	}
	
	

}
