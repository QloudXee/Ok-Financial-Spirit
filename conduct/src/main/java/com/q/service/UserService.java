package com.q.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.q.dao.UserDao;
import com.q.model.TbUser;

/**
 * 用户业务层
 * 用户注册,用户改密,用户删除,查询所有用户,根据id查询用户
 * @author Qloud
 * */
@Service("userService")
public class UserService {
	
	private UserDao userDao;
	
	//用户注册
	public void regiest(TbUser user){
		userDao.regiest(user);
	}
	
	//用户改密
	public void alertUser(TbUser user){
		userDao.alertUser(user);
	}
	
	//用户删除
	public List<TbUser> deleteUser(TbUser user, int page){
		userDao.deleteUser(user);
		List<TbUser> userList = userDao.getAll(page);
		return userList;
	}
	
	//查询所有用户
	public List<TbUser> queryAllUser(int page){
		List<TbUser> userList = userDao.getAll(page);
		return userList;
	}
	
	//根据用户名查询用户
	public List<TbUser> queryUserByName(String name){
		List<TbUser> userList = userDao.queryUserByName(name);
		return userList;
	}

	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public int getTotal() {
		List<TbUser> users = userDao.getTotal();
		int total = 0;
		int temp = users.size();
		while(temp/10>0){
			total++;
			temp-=10;
		}
		total++;
		return total;
	}
	
}
