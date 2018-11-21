package com.mymybatis.test;

import com.mymybatis.mapper.UserMapper;
import com.mymybatis.pojo.User;
import com.mymybatis.sqlsession.MySqlsession;


public class TestMybatis {
	
    public static void main(String[] args) {  
    	
        MySqlsession sqlsession=new MySqlsession();  
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);  
        
        User user = mapper.getUserById("11");  
        System.out.println(user);
    } 

}
