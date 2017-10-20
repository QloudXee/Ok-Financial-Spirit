package com.q.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.q.dao.UserDao;
import com.q.model.TbUser;

/**
 * 用户业务层
 * 用户注册,用户改密,用户删除,查询所有用户,根据id查询用户,根据用户名查询用户
 * @author Qloud
 * */
@Service("userService")
public class UserService {
	
	private UserDao userDao;
	
	/**
	 * 用户注册
	 * @param user
	 * */
	public void regiest(TbUser user){
		userDao.regiest(user);
	}
	
	/**
	 * 用户改密
	 * @param user
	 * */
	public void alertUser(TbUser user){
		userDao.alertUser(user);
	}
	
	/**
	 * 用户删除
	 * @param user , page
	 * @return List<TbUser>
	 * */
	public List<TbUser> deleteUser(TbUser user, int page){
		TbUser user1 = userDao.getUserById(user.getId());
		user1.setStatues(0);
		userDao.deleteUser(user1);
		List<TbUser> userList = userDao.getAll(page);
		return userList;
	}
	
	/**
	 * 查询所有用户
	 * @param page
	 * @return List<TbUser>
	 * */
	public List<TbUser> queryAllUser(int page){
		List<TbUser> userList = userDao.getAll(page);
		return userList;
	}
	
	/**
	 * 根据用户名查询用户
	 * @param name
	 * @return List<TbUser>
	 * */
	public List<TbUser> queryUserByName(String name){
		List<TbUser> userList = userDao.queryUserByName(name);
		return userList;
	}
	
	/**
	 * 获取总页数
	 * dao获取所有用户信息
	 * 这里根据用户list的size获取总页数，一页十个用户
	 * @return int
	 * */
	public int getTotal() {
		List<TbUser> users = userDao.getTotal();
		int total = 0;
		int temp = users.size();
		while(temp/10>0){
			total++;
			temp-=10;
		}
		if(temp>0){
			total++;
		}
		return total;
	}

	/**
	 * 用户登录
	 * dao返回用户信息
	 * 这里效验密码是否一致
	 * @param name , password
	 * @return int
	 * */
	public TbUser login(String name, String password) {
		TbUser user = userDao.login(name);
		if(user == null){
			return null;
		}else if(user.getPassword().equals(password)){
			return user;
		}else{
			return null;
		}
	}
	
	/**
	 * 查询所有用户信息
	 * @return List<TbUser>
	 * */
	public List<TbUser> getAllUser(){
		List<TbUser> users = userDao.getTotal();
		return users;
	}
	
	/**
	 * 忘记密码 
	 * @param name , email , password
	 * @return int
	 * */
	public int forget(String name, String email, String password) {
		TbUser user = userDao.getUserByName(name);
		if(user.getEmail().equals(email)){
			user.setPassword(password);
			userDao.forget(user);
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 查询所有用户
	 * @param name
	 * @return TbUser
	 * */
	public TbUser getUserByName(String name){
		TbUser user = userDao.getUserByName(name);
		return user;
	}
	
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
}