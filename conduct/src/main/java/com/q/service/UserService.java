package com.q.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.q.dao.UserDao;
import com.q.model.TbUser;

/**
 * �û�ҵ���
 * �û�ע��,�û�����,�û�ɾ��,��ѯ�����û�,����id��ѯ�û�
 * @author Qloud
 * */
@Service("userService")
public class UserService {
	
	private UserDao userDao;
	
	//�û�ע��
	public void regiest(TbUser user){
		userDao.regiest(user);
	}
	
	//�û�����
	public void alertUser(TbUser user){
		userDao.alertUser(user);
	}
	
	//�û�ɾ��
	public List<TbUser> deleteUser(TbUser user, int page){
		userDao.deleteUser(user);
		List<TbUser> userList = userDao.getAll(page);
		return userList;
	}
	
	//��ѯ�����û�
	public List<TbUser> queryAllUser(int page){
		List<TbUser> userList = userDao.getAll(page);
		return userList;
	}
	
	//�����û�����ѯ�û�
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
