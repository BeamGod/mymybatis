package com.mymybatis.sqlsession;

import java.lang.reflect.Proxy;

public class MySqlsession {
	
	private Excutor excutor = new  MyExcutor();
	
	private MyConfiguration myConfiguration = new MyConfiguration();
	
	public <T> T selectOne(String statement,Object parameter){
		return excutor.query(statement, parameter);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> cls){
		//动态代理
		return (T)Proxy.newProxyInstance(cls.getClassLoader(), new Class[] {cls}, 
				new MyMapperProxy(myConfiguration,this));
		
	}
	

}
