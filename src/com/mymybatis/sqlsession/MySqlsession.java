package com.mymybatis.sqlsession;

import java.lang.reflect.Proxy;

import com.mymybatis.pojo.User;

public class MySqlsession {
	
	private Excutor excutor  ;
	
	private MyConfiguration myConfiguration ;
	
	
	public <T> T selectOne(String statement,Object parameter,Class clzz){
		return excutor.query(statement, parameter,clzz);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> cls){
		//动态代理
		return (T)Proxy.newProxyInstance(cls.getClassLoader(), new Class[] {cls}, 
				new MyMapperProxy(myConfiguration,this));
		
	}

	public MySqlsession(Excutor excutor,MyConfiguration myConfiguration) {
		super();
		// TODO Auto-generated constructor stub
		this.excutor = excutor;
		this.myConfiguration = myConfiguration;
	}
	
	
	
	

}
