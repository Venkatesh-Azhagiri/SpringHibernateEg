package com.ibatis.poc.user.daoImplementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


import com.ibatis.poc.common.BeanManager;
import com.ibatis.poc.user.model.UserModel;

import com.ibatis.sqlmap.client.SqlMapClient;

public class UserDAOImplementation extends SqlMapClientDaoSupport{


	@Autowired
	BeanManager beanManager;
	
	//private UserModel userModel;
    
	
	/*public UserModel getUserModel() {
		return (UserModel )beanManager.createBeanObject("userModel");
	}    

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
*/

		
	/*public List<UserModel> listUsers() {
		String s = "venkatesh, venky";
		String[] s1 = s.split(",");
		List<UserModel> lst = new ArrayList<UserModel>();
		for(int i = 0; i < s1.length; ++i){
			UserModel userModel = getUserModel();
			System.out.println("namehg***"+s1[i]);
			userModel.setUserName(s1[i]);
			lst.add(userModel);		
		}		
		return lst;
	}*/
    
	public int getValidUser(UserModel userModel){
		int retCount = 0;
		Map<String,String> map= new HashMap<String, String>();
		map.put("userId", userModel.getUserId());
		map.put("password", userModel.getPassword());
		System.out.println();
		try {
			System.out.println("");
			retCount = Integer.parseInt(getSqlMapClient().queryForObject("getValidUser", map).toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("exception***"+e);
			e.printStackTrace();
		}
		
		return retCount;
		
		
	}

	public List<UserModel> getListUser(String password) {
		password = "password";
		List<UserModel> modelList = new ArrayList<UserModel>();
		UserModel model = null;
		try {
			System.out.println("");
			modelList = (List<UserModel>)getSqlMapClient().queryForList("getUserList", password);
			System.out.println("list size is"+modelList.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return modelList;
	}
	
}




