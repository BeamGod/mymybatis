package com.mymybatis.test;

import com.mymybatis.mapper.CompanyMapper;
import com.mymybatis.mapper.UserMapper;
import com.mymybatis.pojo.Company;
import com.mymybatis.pojo.User;
import com.mymybatis.sqlsession.Excutor;
import com.mymybatis.sqlsession.MyConfiguration;
import com.mymybatis.sqlsession.MyExcutor;
import com.mymybatis.sqlsession.MySqlsession;


public class TestMybatis {
	
    public static void main(String[] args) {  
    	MyConfiguration myConfiguration =new MyConfiguration("resources/config.xml","resources/CompanyMapper.xml");
        MySqlsession sqlsession=new MySqlsession(new MyExcutor(myConfiguration),myConfiguration);  
        CompanyMapper mapper = sqlsession.getMapper(CompanyMapper.class);  
        if(mapper == null ){
        	System.out.println(" null1 ");
        }
        Company company = mapper.getCompanyById("1");  
        System.out.println(company);
        
        //
        
        MyConfiguration myConfiguration2 =new MyConfiguration("resources/config.xml","resources/UserMapper.xml");
        MySqlsession sqlsession2=new MySqlsession(new MyExcutor(myConfiguration2),myConfiguration2);  
        UserMapper mapper2 = sqlsession2.getMapper(UserMapper.class);  
        if(mapper2 == null ){
        	System.out.println(" null2 ");
        }
        User user = mapper2.getUserById("11");  
        System.out.println(user);
    } 

}
