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
		TbUser user1 = userDao.getUserById(user.getId());
		user1.setStatues(0);
		userDao.deleteUser(user1);
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
	
	/**
	 * 获取总页数
	 * dao获取所有用户信息
	 * 这里根据用户list的size获取总页数，一页十个用户
	 * @author Qloud
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
	 * @author Qluod
	 * @return int
	 * */
	public int login(String name, String password) {
		TbUser user = userDao.login(name);
		int i = 0;
		if(user == null){
			i = 0;
			return i;
		}else if(user.getPassword().equals(password)){
			i = 1;
			return i;
		}else{
			i = 2;
			return i;
		}
	}
	
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}

}