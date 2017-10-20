package com.q.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.q.dao.UserDao;
import com.q.model.TbUser;

/**
 * �û�ҵ���
 * �û�ע��,�û�����,�û�ɾ��,��ѯ�����û�,����id��ѯ�û�,�����û�����ѯ�û�
 * @author Qloud
 * */
@Service("userService")
public class UserService {
	
	private UserDao userDao;
	
	/**
	 * �û�ע��
	 * @param user
	 * */
	public void regiest(TbUser user){
		userDao.regiest(user);
	}
	
	/**
	 * �û�����
	 * @param user
	 * */
	public void alertUser(TbUser user){
		userDao.alertUser(user);
	}
	
	/**
	 * �û�ɾ��
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
	 * ��ѯ�����û�
	 * @param page
	 * @return List<TbUser>
	 * */
	public List<TbUser> queryAllUser(int page){
		List<TbUser> userList = userDao.getAll(page);
		return userList;
	}
	
	/**
	 * �����û�����ѯ�û�
	 * @param name
	 * @return List<TbUser>
	 * */
	public List<TbUser> queryUserByName(String name){
		List<TbUser> userList = userDao.queryUserByName(name);
		return userList;
	}
	
	/**
	 * ��ȡ��ҳ��
	 * dao��ȡ�����û���Ϣ
	 * ��������û�list��size��ȡ��ҳ����һҳʮ���û�
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
	 * �û���¼
	 * dao�����û���Ϣ
	 * ����Ч�������Ƿ�һ��
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
	 * ��ѯ�����û���Ϣ
	 * @return List<TbUser>
	 * */
	public List<TbUser> getAllUser(){
		List<TbUser> users = userDao.getTotal();
		return users;
	}
	
	/**
	 * �������� 
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
	 * ��ѯ�����û�
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